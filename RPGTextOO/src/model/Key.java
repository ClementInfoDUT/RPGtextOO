package model;

public class Key {
	private String name;
	
	public Key(String name) {
		this.name = name;
	}
	
	public void open(Room room) {
		if (room.isLock) {
			room.setLock(False);
		}
	}
}
