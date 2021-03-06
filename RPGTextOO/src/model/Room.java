package model;

public class Room {
	private String desc;
	private Room nRoom;
	private Room oRoom;
	private Room eRoom;
	private Room sRoom;
	private Enemy mob;
	private Chest chest;
	private Trap trap;
	private boolean lock = false;

	public Room(String desc) {
		super();
		this.desc=desc;
	}

	public void setNorthRoom(Room room) {
		nRoom = room;		
	}

	public void setWestRoom(Room room) {
		oRoom = room;
		
	}

	public void setSouthRoom(Room room) {
		sRoom = room;
		
	}

	public void setEastRoom(Room room) {
		eRoom = room;
		
	}
	
	public void setMob(Enemy mob){
		this.mob = mob;
	}

	public Room getWestRoom() {
		return oRoom;
	}

	public Room getNorthRoom() {
		return nRoom;
	}

	public Room getEastRoom() {
		return eRoom;
	}

	public Room getSouthRoom() {
		return sRoom;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public Enemy getMob(){
		return mob;
	}
	
	public Chest getChest() {
		return chest;
	}

	public void setChest(Chest chest) {
		this.chest = chest;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public Trap getTrap() {
		return trap;
	}

	public void setTrap(Trap trap) {
		this.trap = trap;
	}

}
