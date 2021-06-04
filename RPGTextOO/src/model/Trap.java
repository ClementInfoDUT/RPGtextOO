package model;

public class Trap {
	private int damage;
	private String name;
	private boolean mortal;
	
	public Trap(String name, int dmg, boolean mortal){
		this.setName(name);
		this.damage = dmg;
		this.setMortal(mortal);
	}
	
	
	public void attack(Entity target) {
	  	int targetHp;
	  	targetHp = target.getHp();
		targetHp = targetHp - damage;
		target.setHp(targetHp);
   }
	
	public void kill(Entity target){
		target.setHp(0);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isMortal() {
		return mortal;
	}


	public void setMortal(boolean mortal) {
		this.mortal = mortal;
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
