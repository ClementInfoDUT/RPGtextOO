package model;

public class Key extends Item{
	private boolean used = false;
	
	public Key(String name) {
		super(name);
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	

	
}
