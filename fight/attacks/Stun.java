package fight.attacks;

import javax.swing.JOptionPane;

import locations.Game;

import fight.classes.Fighter;

public class Stun extends Attack {
	public Stun() {
		super(0, 0, 0, 4, " stunned (for 2 turns) ");
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

		for (Attack attack : defender.attacks)
			attack.down += 2;
		JOptionPane.showMessageDialog(null, name1 + effect + name2, "Battle",
				JOptionPane.PLAIN_MESSAGE, null);
	}
}
