package model;

public class Weapon extends Item {
	private int damage;

	public Weapon(String name, int damage) {
		super(name);
		this.setDamage(damage);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
