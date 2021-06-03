package controller;

import java.util.ArrayList;
import java.util.List;

import model.Boss;
import model.Enemy;
import model.GameModel;
import model.Healing;
import model.Item;
import model.Player;
import model.Weapon;
import view.Action;
import view.Console;
import view.GameScreen;
import view.PossibleAction;

public class GameLogic {

  private GameModel gameModel;
  private GameScreen screen;

  private Player player;
  private Boss boss;

  public GameLogic(GameModel theRootModel, GameScreen theRootView) {
    gameModel = theRootModel;
    screen = theRootView;

    player = gameModel.getPlayer();
    boss = gameModel.getBoss();
  }

  public void start() {
    screen.welcomeMessage();

    while (!endOfTheGame()) {
      screen.describeCurrentRoom(player.getCurrentLocation());
      
      if (player.getCurrentLocation().getMob() != null){
      	if (player.getCurrentLocation().getMob().isAlive()){
      		screen.describeCurrentMob(player.getCurrentLocation().getMob());
      	}
      }
      
      if (player.getCurrentLocation().getTrap() != null){
        	screen.describeCurrentTrap(player.getCurrentLocation().getTrap());
        	if(player.getCurrentLocation().getTrap().isMortal()){
        		player.getCurrentLocation().getTrap().kill(player);
        	}else{
        		player.getCurrentLocation().getTrap().attack(player);
        	}
      }
      
      if (player.getCurrentLocation().getChest() != null){
    	  if (player.getCurrentLocation().getChest().isOpen() == false){
    		  screen.describeCurrentChest(player.getCurrentLocation().getChest());
    	  }
      }
      

      List<Action> contextualPossibleActions = getContextualActions();

      screen.proposeAvailableActions(contextualPossibleActions);

      PossibleAction actionToDo = screen.readActionToDo(contextualPossibleActions);
      
      doAnAction(actionToDo);
      
    }
    if (player.isAlive()) {
      screen.goodEnding();
    } else {
      screen.badEnding();
    }
  }

  public List<Action> getContextualActions() {

    List<Action> result = new ArrayList<>();
    
    result.add(new Action('I', "Voir l'inventaire", PossibleAction.LOOK));
    
    boolean hasHealingItems = false;
	hasHealingItems = player.hasHealingItem();
	if (hasHealingItems){
		result.add(new Action('U', "Utiliser un objet de soin", PossibleAction.HEAL));
	}
    
    if (player.getCurrentLocation().getWestRoom() != null) {
      result.add(new Action('O', "Aller vers l'ouest", PossibleAction.GOWEST));
    }
    if (player.getCurrentLocation().getEastRoom() != null) {
      result.add(new Action('E', "Aller vers l'est", PossibleAction.GOEAST));
    }
    if (player.getCurrentLocation().getNorthRoom() != null) {
      result.add(new Action('N', "Aller vers le nord", PossibleAction.GONORTH));
    }
    if (player.getCurrentLocation().getSouthRoom() != null) {
      result.add(new Action('S', "Aller vers le sud", PossibleAction.GOSOUTH));
    }
    if (player.getCurrentLocation().getMob() != null){
    	if (player.getCurrentLocation().getMob().isAlive()){
    		result.clear();
    		result.add(new Action('A', "Attaquer", PossibleAction.ATTACK));
    	}
    }
    
    if (player.getCurrentLocation().getChest() != null){
    	if (player.getCurrentLocation().getChest().isOpen() == false){
        	result.add(new Action('C', "Ouvrir le coffre", PossibleAction.OPEN));
        }
    }
    
    if (player.getCurrentLocation().getTrap() != null){
    	if (player.getCurrentLocation().getTrap().isMortal()){
    		result.clear();
    		result.add(new Action('P', "Passer le temps", PossibleAction.PASS));
    	}
  	}

    return result;
  }

  private void doAnAction(PossibleAction action) {
    switch (action) {
    case GOWEST:
      player.goWest();
      break;
    case GOEAST:
      player.goEast();
      break;
    case GONORTH:
      player.goNorth();
      break;
    case GOSOUTH:
      player.goSouth();
      break;
    case ATTACK:
    	Fight(player, player.getCurrentLocation().getMob());
    	break;
    case OPEN:
    	player.getCurrentLocation().getChest().setOpen(true);
    	screen.describeItemGet(player.getCurrentLocation().getChest().getContent());
    	if (player.getCurrentLocation().getChest().getContent().getClass() == Weapon.class){
    		if(((Weapon) player.getCurrentLocation().getChest().getContent()).getDamage() > player.getCurrentWeapon().getDamage()){
    			player.setCurrentWeapon((Weapon)player.getCurrentLocation().getChest().getContent());
    			screen.describeNewWeaponEquipped((Weapon)player.getCurrentLocation().getChest().getContent());
    		}
    	}
    	player.addInInventory(player.getCurrentLocation().getChest().getContent());
    	break;
    case LOOK:
    	screen.describeInventory(player.getInventory());
    	break;
    	
    case PASS:
    	Console.displayln("Vous passez le temps");
    	break;
    	
    case HEAL:
    	ArrayList<Item> inventory = new ArrayList<Item>();
    	inventory = player.getInventory();
    	for (Item items: inventory){
    		if(items.getClass() == Healing.class){
    			player.setHp(((Healing) items).getHeal());
    			screen.describeHealing((Healing)items);
    			((Healing) items).setUsed(true);
    		}
    	}
    	
   
    }

  }


public void Fight(Player player, Enemy mob){
		Console.displayln("==== Joueur VS " + mob.getName() + " ====");
		while (player.getCurrentLocation().getMob().isAlive() && player.isAlive()){
		  player.attack(mob);
		  screen.describePlayerTurnFight(player, player.getCurrentLocation().getMob());
		  if(player.getCurrentLocation().getMob().isAlive() && player.isAlive()){
			  player.getCurrentLocation().getMob().attack(player);
			  screen.describeEnemyTurnFight(player.getCurrentLocation().getMob(), player);
		  }
	  		if (!player.getCurrentLocation().getMob().isAlive()){
	  			screen.killText(player.getCurrentLocation().getMob());
	  			Console.displayln("==== Victoire du Joueur ====");
	  		}
	  }
	}

  private boolean endOfTheGame() {
	    boolean end = false;
	    //Si le joueur meurt
	    if (player.isAlive()){
	        if (boss.getCurrentLocation().getMob().isAlive()) {
	            end = false;
	        }else {
	            end = true;
	        }
	    } else {
	        end = true;
	    }
	    //Si le boss meurt
	    return end;
	  }

}
