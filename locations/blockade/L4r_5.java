package locations.blockade;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.ImperialGuard;

public class L4r_5 extends Lolcation {

	public L4r_5() {
		super(
				4,
				-5,
				0,
				"Mountain",
				"To the West, the mountain acsends upwards, to a snow covered peak,"
				+"crowned by a giant castle. There appears to be something on the ground to the South",
				new Object[] { "North", "South", "West" },
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
