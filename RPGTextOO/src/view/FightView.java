package view;

import model.Enemy;
import model.Player;

public class FightView {
	public static String PlayerAttack(Player player, Enemy mob){
		String fightText = "Vous infligez " + player.getDamage() + " de dégâts sur " + mob.getName();
		return fightText;
	}

	public static String EnemyAttack(Enemy mob, Player player) {
		String fightText = mob.getName() + " vous inflige " + mob.getDamage() + " de dégâts";
		return fightText;
		
	}
	
	public static String CurrentHealth(Player player){
		String currentHealth = "Vous avez " + player.getHp();
		return currentHealth;
	}
}
