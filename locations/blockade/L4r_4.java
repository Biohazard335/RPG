package locations.blockade;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.ImperialGuard;

public class L4r_4 extends Lolcation {

	public L4r_4() {
		super(
				4,
				-4,
				0,
				"Blockade",
				"The number of Guards surrounding the area and bodies on the ground make it"
				+"clear that this area is not for pedestrians. You should continue with caution."
				+"\nThere is a sheer cliff to the East.",
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
