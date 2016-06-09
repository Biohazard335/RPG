package locations.blockade;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.ImperialGuard;

public class L3r_5 extends Lolcation {

	public L3r_5() {
		super(
				3,
				-5,
				0,
				"Mountain",
				"To the West, the mountain acsends upwards, to a snow covered peak,"
				+"At the top there is a giant castle.",
				new Object[] { "North", "South", "East", "West" },
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
