package model;

public class Enemy implements Entity{
	
	private static final int STARTING_HP = 50;
	private static final int STARTING_DMG = 3;
	
	private int hp;
	private int damage;
	private Room currentLocation;
	private String name;
	
	public Enemy(String name){
		super();
		hp = STARTING_HP;
		damage = STARTING_DMG;
		this.name = name;
	}
	
	public Enemy(String name, int hp, int dmg){
		this(name);
		this.hp = hp;
		this.damage = dmg;
	}
	
	@Override
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp){
		this.hp = hp;
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
	
	@Override
	public int getDamage(){
		return damage;
	}

	@Override
	public void attack(Entity target) {
		int targetHp;
		targetHp = target.getHp();
		targetHp = targetHp - damage;
		target.setHp(targetHp);
	}
	
	public String getName(){
		return name;
	}
	

}
