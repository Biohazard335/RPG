package locations.blockade;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.ImperialGuard;

public class L3r_6 extends Lolcation {

	public L3r_6() {
		super(
				3,
				-6,
				0,
				"Mountain",
				"Near the top of the mountain, you can see the world below you, "
				+"but what catches your attention is the only thing above you, "
				+"a massive castle on the crest of the mountain to the West.\n"
				+"There appears to be something on the ground to the East.",
				new Object[] { "North", "East", "West" },
				new Fighter[] {}, new Talker[] {});
	}

	@Override
	public void before() {
		int d = 1 + (int) (Math.random() * 3);
		if (d == 3) {
			JOptionPane.showMessageDialog(null,
					"Imperial Guard:\"Hey! You're not supposed to be here!\"\nYou are attacked by an Imperial Guard.", "Battle",
					JOptionPane.PLAIN_MESSAGE, null);
			Battle.battle(new ImperialGuard(6), true, false);
		}
	}
}
