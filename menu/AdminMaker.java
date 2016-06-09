package menu;

import javax.swing.JOptionPane;

import locations.Game;
import fight.attacks.*;
import fight.classes.ADMIN;

public class AdminMaker {
	public static void ADMiN() {
		Object[] functions = { "Playthrough", "Jump", "Edit", "Quit" };
		Object[] edit = { "Check", "Stats", "Attacks", "Reset", "Back" };
		do {
			Object choice = JOptionPane.showInputDialog(null, "Function:",
					"ADMIN", JOptionPane.PLAIN_MESSAGE, null, functions,
					functions[0]);
			if (choice == "Edit") {
				do {
					Object choice1 = JOptionPane.showInputDialog(null,
							"Function:", "ADMIN", JOptionPane.PLAIN_MESSAGE,
							null, edit, edit[0]);
					if (choice1 == "Stats") {
						Game.player.str = Integer.parseInt(JOptionPane
								.showInputDialog(null, "Enter Str", "ADMIN",
										JOptionPane.PLAIN_MESSAGE));
						Game.player.def = Integer.parseInt(JOptionPane
								.showInputDialog(null, "Enter Def", "ADMIN",
										JOptionPane.PLAIN_MESSAGE));
						Game.player.acc = Integer.parseInt(JOptionPane
								.showInputDialog(null, "Enter Acc", "ADMIN",
										JOptionPane.PLAIN_MESSAGE));
						Game.player.spd = Integer.parseInt(JOptionPane
								.showInputDialog(null, "Enter Spd", "ADMIN",
										JOptionPane.PLAIN_MESSAGE));
					} else if (choice1 == "Attacks") {
						Attack[] attacks = { new Bash(), new Bite(),
								new Impale(), new Kick(), new Lunge(),
								new Masticate(), new Punch(), new ShieldSlam(),
								new Slice(), new Stab(), new Strike(),
								new Stun(), new All() };
						Object choice2 = JOptionPane.showInputDialog(null,
								"Function:", "ADMIN",
								JOptionPane.PLAIN_MESSAGE, null, attacks,
								attacks[0]);
						if (choice2 == attacks[attacks.length - 1]) {
							for (Attack attack : attacks)
								if (attack != attacks[attacks.length - 1])
									Game.player.attacks.add(attack);
						} else
							for (Attack attack : attacks) {
								if (choice2 == attack)
									Game.player.attacks.add(attack);
							}
					} else if (choice1 == "Reset") {
						Game.player = new ADMIN();
					}

					else if (choice1 == "Check") {
						String attacks = "\nAttacks:\n";
						for (Attack attack : Game.player.attacks) {
							attacks += attack.getClass().getSimpleName() + ", ";
						}
						JOptionPane.showMessageDialog(null,
								Game.player.name + ": " + Game.player.hp + "\n"
										+ Game.player.stats() + attacks,
								"ADMIN", JOptionPane.PLAIN_MESSAGE, null);

					} else if (choice1 == "Back")
						break;
				} while (true);
			} else if (choice == "Playthrough") {
				break;
			} else if (choice == "Jump") {
				Game.x = Integer.parseInt(JOptionPane.showInputDialog(null,
						"x", "ADMIN", JOptionPane.PLAIN_MESSAGE));
				Game.y = Integer.parseInt(JOptionPane.showInputDialog(null,
						"y", "ADMIN", JOptionPane.PLAIN_MESSAGE));
				Game.z = Integer.parseInt(JOptionPane.showInputDialog(null,
						"z", "ADMIN", JOptionPane.PLAIN_MESSAGE));
				break;
			} else if (choice == "Quit")
				System.exit(0);

		} while (true);

	}
}
