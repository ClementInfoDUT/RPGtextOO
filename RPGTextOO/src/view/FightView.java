package view;

import model.Enemy;
import model.Player;

public class FightView {
	
	
	public static String PlayerAttack(Player player, Enemy mob){
		String fightText = "Vous infligez " + player.getDamage() + " de d?g?ts sur " + mob.getName();
		return fightText;
	}

	public static String EnemyAttack(Enemy mob, Player player) {
		String fightText = mob.getName() + " vous inflige " + mob.getDamage() + " de d?g?ts";
		return fightText;
		
	}
	
	public static String CurrentHealthPlayer(Player player){
		String currentHealth = "Vous avez " + player.getHp() + " HP";
		return currentHealth;
	}

	public static String CurrentHealthMob(Enemy mob) {
		String currentHealth = "Votre adversaire a " + mob.getHp() + " HP";
		return currentHealth;
	}
}
