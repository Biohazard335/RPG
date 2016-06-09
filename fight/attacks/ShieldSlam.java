package fight.attacks;

import javax.swing.JOptionPane;

import locations.Game;

import fight.classes.Fighter;

public class ShieldSlam extends Attack {

	public ShieldSlam() {
		super(5, 5, 6, 4, " used a sheild to stun ");
	}

	@Override
	public void affect(Fighter attacker, Fighter defender) {
		String name1 = attacker.name, name2 = defender.name;
		if (name1 == Game.player.name) {
			name1 = "You";
			name2 = "the " + defender.name;
		} else {
			name2 = "you";
			name1 = "The " + attacker.name;
		}

		int damage = (int) ((3 * attacker.str * str / defender.def) + Math
				.random() * (2 * str));
		defender.hp -= damage;
		for (Attack attack : defender.attacks)
			attack.down += 1;
		JOptionPane.showMessageDialog(null, name1 + effect + name2 + "\n-"
				+ damage, "Battle", JOptionPane.PLAIN_MESSAGE, null);

	}

}
