package fight.attacks;

import javax.swing.JOptionPane;

import locations.Game;
import fight.classes.Fighter;

public class Attack {

	public int acc, str, prb, cool, down = 0;
	public String effect;

	public Attack(int acc, int str, int prb, int cool, String effect) {
		this.acc = acc;
		this.str = str;
		this.prb = prb;
		this.cool = cool;
		this.effect = effect;
	}

	public boolean dodge(Fighter attacker, Fighter defender) {
		if (Math.random() * (this.acc + attacker.acc) > (Math.random() * defender.spd) / 2)
			return false;
		else
			return true;

	}

	public void display(Fighter attacker, Fighter defender, int damage) {
		String name1 = attacker.name, name2 = defender.name;
		if (name1 == Game.player.name) {
			name1 = "You";
			name2 = "the " + defender.name;
		} else {
			name2 = "you";
			name1 = "The " + attacker.name;
		}
		JOptionPane.showMessageDialog(null, name1 + " " + effect + " " + name2
				+ "\n-" + damage, "Battle", JOptionPane.PLAIN_MESSAGE, null);
	}

	public void affect(Fighter attacker, Fighter defender) {
		int damage = (int) ((2 * attacker.str * str / defender.def) + Math
				.random() * str);
		defender.hp -= damage;
		display(attacker, defender, damage);

	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
