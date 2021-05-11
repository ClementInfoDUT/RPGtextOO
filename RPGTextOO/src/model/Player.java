package model;

public class Player implements Entity{

  private static final int STARTING_HP = 70;
  private static final int STARTING_DMG = 5;

  private Room currentLocation;
  private int hp;
  private int damage;

  public Player() {
    super();
    hp = STARTING_HP;
    damage = STARTING_DMG;
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
	  currentLocation = currentLocation.getWestRoom();
  }

  public void goNorth() {
	  currentLocation = currentLocation.getNorthRoom();
  }

  public void goEast() {
	  currentLocation = currentLocation.getEastRoom();
  }

  public void goSouth() {
	  currentLocation = currentLocation.getSouthRoom();
  }

  @Override
  public void attack(Entity target) {
	  	int targetHp;
	  	targetHp = target.getHp();
		targetHp = targetHp - damage;	
  }

  @Override
  public int getDamage() {
	  return damage;
  }

}
