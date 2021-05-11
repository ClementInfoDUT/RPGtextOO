package model;

public interface Entity {
	
	public int getHp();

	public boolean isAlive();
	
	public Room getCurrentLocation();

	public void setCurrentLocation(Room currentLocation);
	
	public int getDamage();
	
	public void attack(Entity target);

}
