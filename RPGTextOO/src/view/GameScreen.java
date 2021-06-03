package view;

import java.util.ArrayList;
import java.util.List;

import model.Chest;
import model.Enemy;
import model.Healing;
import model.Item;
import model.Player;
import model.Room;
import model.Trap;
import model.Weapon;

public class GameScreen {

  public void welcomeMessage() {
    Console.displayln("Bienvenue dans la forteresse du Tyran");
    Console.displayln("Le Tyran vous attends de pied ferme...");
    Console.displayln("Allez-vous tomber? Ou allez-vous LE faire tomber?");
  }

  public void badEnding() {
    Console.displayln("Vous êtes mort...");
    Console.displayln("La règne du Tyran continuera encore");
    
  }

  public void goodEnding() {
    Console.displayln("Bravo ! Vous avez gagné");
    Console.displayln("Le Tyran est tombé");
  }

  public void describeCurrentRoom(String currentRoomDescription) {
    Console.displayln("Vous êtes dans " + currentRoomDescription);
  }
  

  public void proposeAvailableActions(List<Action> actions) {
    for (Action a : actions) {
      Console.displayln("(" + a.getCharToRead() + ") " + a.getMessage());
    }
  }

  public PossibleAction readActionToDo(List<Action> actions) {
    PossibleAction result = null;

    Interaction.resetKeys();
    for (Action a : actions) {
      Interaction.acceptKey(a.getCharToRead());
    }

    Console.systemeInfo("Votre choix ?");
    char rep = Interaction.readAction();

    for (Action a : actions) {
      if (Character.toLowerCase(rep) == Character.toLowerCase(a.getCharToRead())) {
        result = a.getAction();
        break;
      }
    }

    return result;
  }

public void describeCurrentRoom(Room currentLocation) {
	String desc = currentLocation.getDesc();
	describeCurrentRoom(desc);
}

public void describeCurrentMob(Enemy mob) {
	String desc = "Vous rencontrez " + mob.getName();
	Console.displayln(desc);
}

public void describePlayerTurnFight(Player player, Enemy mob){
	String fightText = FightView.PlayerAttack(player, mob);
	Console.displayln(fightText);
	String mobHealth = FightView.CurrentHealthMob(mob);
	Console.displayln(mobHealth);
}

public void describeEnemyTurnFight(Enemy mob, Player player) {
	String fightText = FightView.EnemyAttack(mob, player);
	Console.displayln(fightText);
	String health = FightView.CurrentHealthPlayer(player);
	Console.displayln(health);
	
}

public void killText(Enemy mob) {
	String text = "Vous avez vaincu " + mob.getName();
	Console.displayln(text);
}

//Description du coffre
public void describeCurrentChest(Chest chest){
	String desc = "Il y a " + chest.getDescChest();
	Console.displayln(desc);
}

public void describeInventory(ArrayList<Item> inventory){
	Console.displayln("==== Inventaire ====");
	for (Item items: inventory){
		Console.displayln(items.toString());
	}
}

public void describeItemGet(Item content) {
	String desc = "Vous obtenez "+ content.getName();
	Console.displayln(desc);
}

public void describeNewWeaponEquipped(Weapon weapon) {
	String desc = "Vous vous équipez de " + weapon;
	Console.displayln(desc);
}

public void describeCurrentTrap(Trap trap) {
	String desc = "Vous tombez sur " + trap.getName();
	Console.displayln(desc);
	
}

public void describeHealing(Healing items) {
	String desc = "Vous vous soignez de " + items.getHeal() + " points de vie";
	Console.displayln(desc);
}

public void describeKeyOpen() {
	String desc = "Vous venez d'ouvrir la porte !";
	Console.displayln(desc);
}

public void hasntKey() {
	String desc = "Vous ne possédez pas la clé";
	Console.displayln(desc);
}

}
