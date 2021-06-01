package model;

public class Key extends Item{
	private String name;
	
	public Key(String name) {
		super(name);
	}
	
	public void openRoom(Room room) {
		boolean lock = room.isLock();
		if (lock == true) {
			room.setLock(false);
		}
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
