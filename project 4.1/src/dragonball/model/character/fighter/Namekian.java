package dragonball.model.character.fighter;

import java.util.ArrayList;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;

public class Namekian extends PlayableFighter {

	public Namekian(String name) {
		super(name, 1350, 50, 50, 3, 5);
	}

	public Namekian(String name, int level, int xp, int targetXp,
			int maxHealthPoints, int blastDamage, int physicalDamage,
			int abilityPoints, int maxKi, int maxStamina,
			ArrayList<SuperAttack> superAttacks,
			ArrayList<UltimateAttack> ultimateAttacks) {
		super(name, level, xp, targetXp, maxHealthPoints, blastDamage,
				physicalDamage, abilityPoints, maxKi, maxStamina, superAttacks,
				ultimateAttacks);
	}

	public void onAttackerTurn() {
		this.setStamina(this.getStamina() + 1);
		this.setHealthPoints(this.getHealthPoints() + 50);
	}

	public void onDefenderTurn() {
		this.setStamina(this.getStamina() + 1);
		this.setHealthPoints(this.getHealthPoints() + 50);
	}
}
