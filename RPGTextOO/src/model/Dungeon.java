package model;

public class Dungeon {

  private Room startingRoom;
  private Room bossRoom;
  

  public Dungeon() {
    super();
    initRooms();
  }

  private void initRooms() {

    Room entry = new Room("une petite pièce banale avec un paillasson \"Bienvenue\"");
    //Ennemi -->
    Room salleEnCroix = new Room("une intersection avec de grandes colonnes et 4 portes");
    //Salle piégée mortelle
    Room sallePiegee = new Room("une salle qui se verouille et se transforme en incinérateur !");
    Room couloirL = new Room("un couloir avec un angle et une chaise posée dans un coin");
    //Ennemi -->
    Room petitCouloir = new Room("un couloir avec, accroché au mur, des portraits");
    //Salle piégée non-mortelle
    Room couloirLPiege = new Room("une pièce avec un seqelette posé dans un coin, seul...");
    //Coffre avec une arme
    Room salleCoffreA = new Room("une petite pièce avec un coffre, mais que contient-il?\nSpoil: Rien");
    //Coffre avec une potion
    Room salleCoffreP = new Room("une petite pièce avec un coffre, mais que contient-il?\nSpoil: Rien");
    //Ennemi --> Armure Rouillée
    Room couloir = new Room("un couloir avec des armures rouillées et vides (normalement)");
    Room grandCouloir = new Room("un long couloir parsemer de preuve d'un passé plus glorieux");
    Room sasBossWest = new Room("un petite pièce a l'aura pesante avec en face de vous, une immense porte");
    Room sasBossEast = new Room("un petite pièce a l'aura pesante avec en face de vous, une immense porte");
    //Coffre avec le clé du boss
    Room salleCoffreKBoss = new Room("un petite pièce avec un coffre majestueux, vous êtes impatient de découvrir son contenu");
    //Boss Final -->
    Room salleBoss = new Room("une immense salle ressemblant à une arêne somptueuse, avec des pilliers gigantesques\nLes spectateurs semblent être là depuis toujours...\nLe maître des lieux se tient debout au centre, attendant l'heure de l'affrontement...");

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
    
    Healing potion = new Healing("une potion de soin", 30);
    Chest chestP = new Chest("un coffre blanc avec une croix rouge", potion);
    salleCoffreP.setChest(chestP);
    
    Weapon testSword = new Weapon("System.out.println(\"bonk\")", 10000);
    Chest chestA = new Chest("un coffre solide et robuste", testSword);
    salleCoffreA.setChest(chestA);
    
    Key bossKey = new Key("une clé en or");
    Chest chestBossKey = new Chest("un coffre en or avec des finitions en diamants et émeraudes", bossKey);
    salleCoffreKBoss.setChest(chestBossKey);
    
    Trap weakTrap = new Trap("des pics rétractables", 5, false);
    couloirLPiege.setTrap(weakTrap);
    
    Trap deathTrap = new Trap("des lances-flammes", 100, true);
    sallePiegee.setTrap(deathTrap);
    
    Enemy painting = new Enemy("une peinture fantomatique", 50, 3);
    petitCouloir.setMob(painting);
    
    Enemy brokenArmor = new Enemy("une Armure Rouillée", 60, 5);
    couloir.setMob(brokenArmor);
    
    Enemy Spider = new Enemy("une araignée",30,1);
    salleEnCroix.setMob(Spider);
    
    Enemy ghostKnight = new Enemy("un chevalier fantôme", 60, 5);
    grandCouloir.setMob(ghostKnight);
    
    Boss tyran = new Boss("le Tyran");
    
    startingRoom = salleCoffreP;
    bossRoom = salleBoss;
    salleBoss.setMob(tyran);
    salleBoss.setLock(true);

  }

  public Room getStartingRoom() {
    return startingRoom;
  }

  public Room getBossRoom(){
	  return bossRoom;
  }
  
}
