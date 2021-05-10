package model;

public class GameModel {

  private Dungeon theDungeon;
  private Player thePlayer;

  public GameModel() {
    theDungeon = new Dungeon();
    thePlayer = new Player();
    thePlayer.setCurrentLocation(theDungeon.getStartingRoom());
  }

  public Player getPlayer() {
    return thePlayer;
  }

}
