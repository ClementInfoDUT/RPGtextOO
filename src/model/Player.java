package model;

public class Player {

  private static final int STARTING_HP = 70;

  private Room currentLocation;
  private int hp;

  public Player() {
    super();
    hp = STARTING_HP;
  }

  public Room getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(Room currentLocation) {
    this.currentLocation = currentLocation;
  }

  public int getHp() {
    return hp;
  }

  public boolean isAlive() {
    return hp > 0;
  }

  public void goWest() {
    
  }

  public void goNorth() {
    
  }

  public void goEast() {
    
  }

  public void goSouth() {
    
  }

}
