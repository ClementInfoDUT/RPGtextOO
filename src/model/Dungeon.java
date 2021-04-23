package model;

public class Dungeon {

  private Room startingRoom;

  public Dungeon() {
    super();
    initRooms();
  }

  private void initRooms() {

    Room entry = new Room("une petite pièce banale avec un paillasson \"Bienvenue\"");
    Room salleAmi = new Room("un grand couloir qui sent bon le salami");
    Room salleSePareille = new Room("une zone étrange qui ressemble à un village de Schtroumpfs");
    Room salleSuffit = new Room("un cul de sac");
    Room salleAMeche = new Room("un long et étroit passage sinueux qui tourne dans tous les sens");

    entry.setNorthRoom(salleAmi);
    salleAmi.setWestRoom(salleSePareille);
    salleSePareille.setSouthRoom(salleAMeche);
    salleAMeche.setSouthRoom(salleAmi);
    salleAmi.setEastRoom(salleSuffit);

    startingRoom = entry;
  }

  public Room getStartingRoom() {
    return startingRoom;
  }

}
