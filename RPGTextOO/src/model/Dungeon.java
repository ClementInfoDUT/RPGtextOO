package model;

public class Dungeon {

  private Room startingRoom;

  public Dungeon() {
    super();
    initRooms();
  }

  private void initRooms() {

    Room entry = new Room("une petite pi�ce banale avec un paillasson \"Bienvenue\"");
    //Ennemi -->
    Room salleEnCroix = new Room("une intersection avec de grandes colonnes et 4 portes");
    //Salle pi�g�e mortelle
    Room sallePiegee = new Room("une salle qui se verouille et se transforme en incin�rateur !\nEnfin, si on avait fait les pi�ges...");
    Room couloirL = new Room("une pi�ce qui tourne avec une chaise pos�e dans un coin");
    //Ennemi -->
    Room petitCouloir = new Room("un couloir avec, accroch� au mur, des tableaux de... voitures?");
    //Salle pi�g�e non-mortelle
    Room couloirLPiege = new Room("une pi�ce avec un seqelette pos� dans un coin, seul...");
    //Coffre avec une arme
    Room salleCoffreA = new Room("une petite pi�ce avec un coffre, mais que contient-il?\nSpoil: Rien");
    //Coffre avec une potion
    Room salleCoffreP = new Room("une petite pi�ce avec un coffre, mais que contient-il?\nSpoil: Rien");
    //Ennemi --> Armure Rouill�e
    Room couloir = new Room("un couloir avec des armures rouill�es et vides (normalement)\nSurtout qu'on a pas fait les ennemis...");
    Room grandCouloir = new Room("un long couloir parsemer de preuve d'un pass� plus glorieux");
    Room sasBossWest = new Room("un petite pi�ce a l'aura pesante avec en face de vous, une immense porte");
    Room sasBossEast = new Room("un petite pi�ce a l'aura pesante avec en face de vous, une immense porte");
    //Coffre avec le cl� du boss
    Room salleCoffreKBoss = new Room("un petite pi�ce avec un coffre majestueux, vous �tes impatient de d�couvrir son contenu");
    //Boss Final -->
    Room salleBoss = new Room("une immense salle ressemblant � une ar�ne somptueuse, avec des pilliers gigantesques\nLes spectateurs semblent �tre l� depuis toujours...\nLe ma�tre des lieux se tient debout au centre, attendant l'heure de l'affrontement...");

    entry.setNorthRoom(salleEnCroix);
    
    salleEnCroix.setNorthRoom(sallePiegee);
    salleEnCroix.setWestRoom(petitCouloir);
    salleEnCroix.setEastRoom(couloirL);
    salleEnCroix.setSouthRoom(entry);
    
    sallePiegee.setSouthRoom(salleEnCroix);
    
    petitCouloir.setEastRoom(salleEnCroix);
	petitCouloir.setNorthRoom(couloirLPiege);
    petitCouloir.setWestRoom(salleCoffreA);
    petitCouloir.setSouthRoom(salleCoffreP);
    
    salleCoffreA.setEastRoom(petitCouloir);
    
    salleCoffreP.setNorthRoom(petitCouloir);
    
    couloirLPiege.setSouthRoom(petitCouloir);
    couloirLPiege.setNorthRoom(couloir);
    
    couloir.setSouthRoom(couloirLPiege);
    couloir.setEastRoom(sasBossWest);
    
    sasBossWest.setWestRoom(couloir);
    sasBossWest.setEastRoom(salleBoss);
    
    couloirL.setWestRoom(salleEnCroix);
    couloirL.setNorthRoom(grandCouloir);
    
    grandCouloir.setSouthRoom(couloirL);
    grandCouloir.setNorthRoom(salleCoffreKBoss);
    grandCouloir.setWestRoom(sasBossEast);
    
    salleCoffreKBoss.setSouthRoom(grandCouloir);
    
    sasBossEast.setEastRoom(grandCouloir);
    sasBossEast.setWestRoom(salleBoss);

    startingRoom = entry;
  }

  public Room getStartingRoom() {
    return startingRoom;
  }

}