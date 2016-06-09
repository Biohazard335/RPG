package fight;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import locations.Game;

import fight.attacks.Attack;
import fight.classes.Fighter;

public class Battle {
	static Attack attack;
	static int chosen = 0;

	public static void begin(boolean heal, boolean flee) {
		if (Game.location.fighters.length != 0) {
			if (Game.location.fighters.length == 1)
				Battle.battle(Game.location.fighters[0], heal, flee);
			else {
				Fighter fght = null;
				ArrayList<String> fighters = new ArrayList<String>();
				for (Fighter f : Game.location.fighters) {
					fighters.add(f.name);
				}
				String[] fight = fighters.toArray(new String[fighters.size()]);
				String tchoice = (String) JOptionPane.showInputDialog(null,
						"Fight who?", "Battle", JOptionPane.PLAIN_MESSAGE,
						null, fight, fight[0]);
				if (tchoice != null) {
					int i = 0;
					for (Fighter f : Game.location.fighters) {
						if (f.name.equals(tchoice)) {
							fght = f;
							chosen = i;
						}
						i++;
					}
					Battle.battle(fght, heal, flee);
				}
			}
		}

	}

	public static void battle(Fighter defender, boolean heal, boolean flee) {
		int x = 0;

		JOptionPane.showMessageDialog(null,
				"You have engaged in battle with a "
						+ defender.getClass().getSimpleName() + "!", "Battle",
				JOptionPane.PLAIN_MESSAGE, null);

		while (Game.player.hp > 0 && defender.hp > 0) {
			ArrayList<Attack> usable = new ArrayList<>();
			ArrayList<Attack> unusable = new ArrayList<>();

			// 1) Display hp and stats
			if (flee == true) {
				Object[] flee1 = { "Fight!", "Flee!" };
				x = JOptionPane.showOptionDialog(null, Game.player.name + ": "
						+ Game.player.hp + "\n" + Game.player.stats() + "\n"
						+ defender.getClass().getSimpleName() + ": "
						+ defender.hp + "\n" + defender.stats(), "Battle",
						JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null,
						flee1, flee1[0]);
				if (x != 0) {
					break;
				}
			} else
				JOptionPane.showMessageDialog(null, Game.player.name + ": "
						+ Game.player.hp + "\n" + Game.player.stats() + "\n"
						+ defender.getClass().getSimpleName() + ": "
						+ defender.hp + "\n" + defender.stats(), "Battle",
						JOptionPane.PLAIN_MESSAGE, null);
			// 2) Game.player Attack
			// a) Determine which attacks need to cool
			for (int i = 0; i < Game.player.attacks.size(); i++) {
				if (Game.player.attacks.get(i).down == 0)
					usable.add(Game.player.attacks.get(i));
				else
					unusable.add(Game.player.attacks.get(i));
			}

			for (int i = 0; i < Game.player.attacks.size(); i++) {
				if (Game.player.attacks.get(i).down > 0)
					Game.player.attacks.get(i).down -= 1;
			}
			// b) Create String of cooling
			Attack[] usables = usable.toArray(new Attack[usable.size()]);
			String cools = "";
			if (unusable.size() != 0) {
				cools = "\nCooling: turns\n";
				for (Attack attack : unusable)
					cools += attack.getClass().getSimpleName() + ": "
							+ (attack.down + 1) + "\n";
			}
			// c) Display cooling and choose from usable attacks
			if (usables.length != 0) {
				do {
					attack = (Attack) JOptionPane.showInputDialog(null,
							"Which attack?" + cools, "Battle",
							JOptionPane.PLAIN_MESSAGE, null, usables,
							usables[0]);
				} while (attack == null);
				// d) Determine hit/miss and effect
				if (attack.dodge(Game.player, defender) == false)
					attack.affect(Game.player, defender);
				else
					JOptionPane.showMessageDialog(null, "You missed!",
							"Battle", JOptionPane.PLAIN_MESSAGE, null);
				// e) Set used attack to cool
				for (int i = 0; i < Game.player.attacks.size(); i++)
					if (Game.player.attacks.get(i).getClass() == attack
							.getClass())
						Game.player.attacks.get(i).down += Game.player.attacks
								.get(i).cool;
			} else {
				JOptionPane.showMessageDialog(null, "You cannot attack!",
						"Battle", JOptionPane.PLAIN_MESSAGE, null);
			}
			if (defender.hp <= 0)
				break;

			// 3) Display Hp and Stats
			JOptionPane.showMessageDialog(null, Game.player.name + ": "
					+ Game.player.hp + "\n" + Game.player.stats() + "\n"
					+ defender.getClass().getSimpleName() + ": " + defender.hp
					+ "\n" + defender.stats(), "Battle",
					JOptionPane.PLAIN_MESSAGE, null);

			// 4) CPU Attack
			// a) Determine Which attacks must cool
			ArrayList<Attack> cusable = new ArrayList<>();

			for (int i = 0; i < defender.attacks.size(); i++) {
				if (defender.attacks.get(i).down == 0)
					cusable.add(defender.attacks.get(i));
			}

			for (int i = 0; i < defender.attacks.size(); i++) {
				if (defender.attacks.get(i).down > 0)
					defender.attacks.get(i).down -= 1;
			}
			// b) Choose attack, Hit/Miss and effect
			if (cusable.size() != 0) {
				attack = defender.chooseAttack(cusable);
				if (attack.dodge(defender, Game.player) == false)
					attack.affect(defender, Game.player);
				else {
					JOptionPane.showMessageDialog(null, "The " + defender.name
							+ " missed!", "Battle", JOptionPane.PLAIN_MESSAGE,
							null);
				}
				for (int i = 0; i < defender.attacks.size(); i++)
					if (defender.attacks.get(i).getClass() == attack.getClass())
						defender.attacks.get(i).down += defender.attacks.get(i).cool;
			} else {

				JOptionPane.showMessageDialog(null, "The "
						+ defender.getClass().getSimpleName()
						+ " cannot attack!", "Battle",
						JOptionPane.PLAIN_MESSAGE, null);
			}
		}
		// WIN
		if (Game.player.hp > 0 && defender.hp <= 0) {
			JOptionPane.showMessageDialog(null, "You have defeated the "
					+ defender.getClass().getSimpleName() + "!", "Victory",
					JOptionPane.PLAIN_MESSAGE, null);

			Game.player.xp += (defender.str + defender.def + defender.acc + defender.spd) / 2;
			if (Game.player.levelCalculator(Game.player.xp) > Game.player.level) {
				Game.player.level = Game.player.levelCalculator(Game.player.xp);
				Game.player.levelUp();
			}

			Game.player.level = Game.player.levelCalculator(Game.player.xp);

			if (heal == true) {
				Game.player.hp = 100;
				for (Attack attack : Game.player.attacks)
					attack.down = 0;
			} else
				JOptionPane.showMessageDialog(null,
						"You were unable to heal after the battle!", "Warning",
						JOptionPane.PLAIN_MESSAGE, null);
			Game.location.afterMath(chosen);
		}
		// LOSE
		else if (Game.player.hp <= 0) {
			defender.hp = 100;
			Game.player.hp = 100;
			for (Attack attack : Game.player.attacks)
				attack.down = 0;
			for (Attack attack : defender.attacks)
				attack.down = 0;
			JOptionPane
					.showMessageDialog(
							null,
							"You have been vanquished."
									+ "\nYou will now return to the last point at which you were not vanquished.",
							"Defeat", JOptionPane.PLAIN_MESSAGE, null);
		}
		// FLEE
		else {
			JOptionPane.showMessageDialog(null, "You bravely ran away.",
					"Escaped", JOptionPane.PLAIN_MESSAGE, null);
			if (heal == true) {
				defender.hp = 100;
				Game.player.hp = 100;
				for (Attack attack : Game.player.attacks)
					attack.down = 0;
				for (Attack attack : defender.attacks)
					attack.down = 0;
			} else
				JOptionPane.showMessageDialog(null,
						"You were unable to heal after the battle!", "Warning",
						JOptionPane.PLAIN_MESSAGE, null);
		}

	}
}
