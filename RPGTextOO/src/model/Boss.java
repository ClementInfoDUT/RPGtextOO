package model;

public class Boss extends Enemy implements Entity{
	private static final int STARTING_HP = 100;
	private static final int STARTING_DMG = 10;
	
	public Boss(String name){
		super(name, STARTING_HP, STARTING_DMG);
	}

}
