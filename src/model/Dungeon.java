package model;

public class Dungeon {

  private Room startingRoom;

  public Dungeon() {
    super();
    initRooms();
  }

  private void initRooms() {

    Room entry = new Room("une petite pièce banale avec un paillasson \"Bienvenue\"");
    Room pieceEnT = new Room("un grand couloir avec des armures rouillées et vides (normalement)");
    Room pieceEnCoin = new Room("une pièce avec un seqelette posé dans un coin, seul...");
    Room couloir = new Room("un couloir avec, accroché au mur, des tableaux de... voitures?");
    Room grandCouloirCentre = new Room("un long couloir parsemer de preuve d'un passé plus glorieux");
    Room grandCouloirOuest = new Room("la partie Ouest du grand couloir");
    Room grandCouloirEst = new Room("la partie Est du grand couloir");
    
    Room salleSePareille = new Room("une zone étrange qui ressemble à un village de Schtroumpfs");
    Room salleSuffit = new Room("un cul de sac");
    Room salleAMeche = new Room("un long et étroit passage sinueux qui tourne dans tous les sens");

    entry.setNorthRoom(pieceEnT);
    
    pieceEnT.setSouthRoom(entry);
    pieceEnT.setWestRoom(pieceEnCoin);
    pieceEnT.setEastRoom(salleSuffit);
    
    pieceEnCoin.setEastRoom(pieceEnT);
    pieceEnCoin.setNorthRoom(couloir);
    
    couloir.setSouthRoom(pieceEnCoin);
    couloir.setNorthRoom(grandCouloirCentre);
    
    grandCouloirCentre.setSouthRoom(couloir);
    grandCouloirCentre.setWestRoom(grandCouloirOuest);
    grandCouloirCentre.setEastRoom(grandCouloirEst);
    
    salleSePareille.setSouthRoom(salleAMeche);
    salleAMeche.setSouthRoom(pieceEnT);
    

    startingRoom = entry;
  }

  public Room getStartingRoom() {
    return startingRoom;
  }

}
