package model;

public class Room {
	private String desc;
	private Room nRoom;
	private Room oRoom;
	private Room eRoom;
	private Room sRoom;
	private Enemy mob;

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

}
