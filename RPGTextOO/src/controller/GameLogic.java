package controller;

import java.util.ArrayList;
import java.util.List;

import model.Boss;
import model.GameModel;
import model.Player;
import view.Action;
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
    	result.add(new Action('A', "Attaquer", PossibleAction.ATTACK));
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
    	player.attack(player.getCurrentLocation().getMob());
    }

  }

  private boolean endOfTheGame() {
	    boolean end = false;
	    //Si le joueur meurt
	    if (player.isAlive()){
	        if (boss.isAlive()) {
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
