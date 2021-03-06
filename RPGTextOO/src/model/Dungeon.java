package model;

public class Dungeon {

  private Room startingRoom;
  private Room bossRoom;
  

  public Dungeon() {
    super();
    initRooms();
  }

  private void initRooms() {

    Room entry = new Room("une petite pi?ce banale avec un paillasson \"Bienvenue\"");
    //Ennemi -->
    Room salleEnCroix = new Room("une intersection avec de grandes colonnes et 4 portes");
    //Salle pi?g?e mortelle
    Room sallePiegee = new Room("une salle qui se verouille et se transforme en incin?rateur !");
    Room couloirL = new Room("un couloir avec un angle et une chaise pos?e dans un coin");
    //Ennemi -->
    Room petitCouloir = new Room("un couloir avec, accroch?s au mur, des portraits");
    //Salle pi?g?e non-mortelle
    Room couloirLPiege = new Room("une pi?ce avec un seqelette pos? dans un coin, seul...");
    //Coffre avec une arme
    Room salleCoffreA = new Room("une petite armurie avec un coffre, mais que contient-il?");
    //Coffre avec une potion
    Room salleCoffreP = new Room("une petite pi?ce li?e ? l'alchimie avec un coffre, mais que contient-il?");
    //Ennemi --> Armure Rouill?e
    Room couloir = new Room("un couloir avec des armures rouill?es et vides (normalement)");
    Room grandCouloir = new Room("un long couloir parsemer de preuve d'un pass? plus glorieux");
    Room sasBossWest = new Room("un petite pi?ce a l'aura pesante avec en face de vous, une immense porte");
    Room sasBossEast = new Room("un petite pi?ce a l'aura pesante avec en face de vous, une immense porte");
    //Coffre avec le cl? du boss
    Room salleCoffreKBoss = new Room("un petite pi?ce avec un coffre majestueux, vous ?tes impatient de d?couvrir son contenu");
    //Salle du Boss
    Room salleBoss = new Room("une immense salle ressemblant ? une ar?ne somptueuse, avec des pilliers gigantesques\nLes spectateurs semblent ?tre l? depuis toujours...\nLe ma?tre des lieux se tient debout au centre, attendant l'heure de l'affrontement...");

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
    
    Weapon testSword = new Weapon("System.out.println(\"bonk\")", 30);
    Chest chestA = new Chest("un coffre solide et robuste", testSword);
    salleCoffreA.setChest(chestA);
    
    Key bossKey = new Key("une cl? en or");
    Chest chestBossKey = new Chest("un coffre en or avec des finitions en diamants et ?meraudes", bossKey);
    salleCoffreKBoss.setChest(chestBossKey);
    
    Trap weakTrap = new Trap("des pics r?tractables", 5, false);
    couloirLPiege.setTrap(weakTrap);
    
    Trap deathTrap = new Trap("des lances-flammes", 100, true);
    sallePiegee.setTrap(deathTrap);
    
    Enemy painting = new Enemy("une peinture fantomatique", 50, 3);
    petitCouloir.setMob(painting);
    
    Enemy brokenArmor = new Enemy("une Armure Rouill?e", 60, 5);
    couloir.setMob(brokenArmor);
    
    Enemy Spider = new Enemy("une araign?e",30,1);
    salleEnCroix.setMob(Spider);
    
    Enemy ghostKnight = new Enemy("un chevalier fant?me", 60, 5);
    grandCouloir.setMob(ghostKnight);
    
    Boss tyran = new Boss("le Tyran");
    
    startingRoom = entry;
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
