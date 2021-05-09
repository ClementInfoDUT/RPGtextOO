package view;

import java.util.List;

import model.Room;

public class GameScreen {

  public void welcomeMessage() {
    Console.displayln("Bienvenue dans le donjon de l'oubli !");
    Console.displayln("Oui, en fait, il n'y a pas de fin, de boss, de princesse à délivrer...");
    Console.displayln("Vous pouvez seulement vous promener...");
  }

  public void badEnding() {
    Console.displayln("Oh non ! Tu as échoué...");
    Console.displayln("La princesse restera captive du méchant POO");
  }

  public void goodEnding() {
    Console.displayln("Bravo ! Vous avez gagné");
    Console.displayln("... le droit de rejouer !!");
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

}
