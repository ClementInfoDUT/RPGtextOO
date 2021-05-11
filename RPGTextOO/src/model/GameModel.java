package model;

public class GameModel {

  private Dungeon theDungeon;
  private Player thePlayer;
  private Boss theBoss;

  public GameModel() {
    theDungeon = new Dungeon();
    thePlayer = new Player();
    theBoss = new Boss("Le Tyran");
    
    thePlayer.setCurrentLocation(theDungeon.getStartingRoom());
    theBoss.setCurrentLocation(theDungeon.getBossRoom());
  }

  public Player getPlayer() {
    return thePlayer;
  }
  
  public Boss getBoss(){
	  return theBoss;
  }
  

}
