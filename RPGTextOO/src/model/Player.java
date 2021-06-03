package model;

import java.util.ArrayList;


public class Player implements Entity{

  private static final int STARTING_HP = 70;
  private static final int STARTING_DMG = 500; //D�g�t normaux = 5

  private Room currentLocation;
  private int hp;
  private int damage;
  private ArrayList<Item> inventory = new ArrayList<Item>();
  private Weapon currentWeapon = new Weapon("Ep�e en acier", 10);

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
  
  public void setHp(int hp){
	  this.hp = hp;
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
		target.setHp(targetHp);
  }

  @Override
  public int getDamage() {
	  return damage+currentWeapon.getDamage();
  }
  
  public void addInInventory(Item item){
	  this.inventory.add(item);
	  
  }

  public ArrayList<Item> getInventory() {
	return inventory;
  }

public Weapon getCurrentWeapon() {
	return currentWeapon;
}

public void setCurrentWeapon(Weapon currentWeapon) {
	this.currentWeapon = currentWeapon;
}

public boolean hasHealingItem() {
	ArrayList<Item> inventory = new ArrayList<Item>();
	inventory = this.getInventory();
	for (Item items: inventory){
		if(items.getClass() == Healing.class){
			if (((Healing) items).isUsed() == false){
				return true;
			}	
		}
	}
	return false;
}
  
  
}
