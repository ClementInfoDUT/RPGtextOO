package model;

public class Boss extends Enemy implements Entity{
	private static final int STARTING_HP = 100;
	private static final int STARTING_DMG = 10;
	
	private Room currentLocation;
	private int hp;
	private int damage;
	private String name;
	
	public Boss(String name){
		super(name);
		hp = STARTING_HP;
		damage = STARTING_DMG;
	}

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public boolean isAlive() {
		return hp>0;
	}

	@Override
	public Room getCurrentLocation() {
	    return currentLocation;
	}

	@Override
	public void setCurrentLocation(Room currentLocation) {
	    this.currentLocation = currentLocation;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public String getName(){
		return name;
	}
}
