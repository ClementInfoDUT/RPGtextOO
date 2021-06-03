package model;

public class Healing extends Item{
	private int heal;
	private boolean used = false;

	public Healing(String name, int heal) {
		super(name);
		this.setHeal(heal);
		
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
