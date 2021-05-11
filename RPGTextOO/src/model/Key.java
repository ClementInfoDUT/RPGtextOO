package model;

public class Key {
	private String name;
	
	public Key(String name) {
		this.name = name;
	}
	
	public void open(Room room) {
		boolean lock = room.isLock();
		if (lock == true) {
			room.setLock(false);
		}
	}
}
