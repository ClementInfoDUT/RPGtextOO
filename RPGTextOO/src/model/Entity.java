package model;

public interface Entity {
	
	public int getHp();
	
	public void setHp(int hp);

	public boolean isAlive();
	
	public Room getCurrentLocation();

	public void setCurrentLocation(Room currentLocation);
	
	public int getDamage();
	
	public void attack(Entity target);

}
