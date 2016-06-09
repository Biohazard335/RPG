package locations.mountain;

import javax.swing.JOptionPane;

import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.Wolf;
import locations.Lolcation;

public class L2r0 extends Lolcation {
	public L2r0() {
		super(
				2,
				0,
				0,
				"Mountain",
				"You've reached the edge of the mountain. To the North and West are steep cliffs with a forest far below.",
				new Object[] { "South", "East" }, new Fighter[] {},
				new Talker[] {});
	}

	@Override
	public void before() {
		int d = 1 + (int) (Math.random() * 5);
		if (d == 5) {
			JOptionPane.showMessageDialog(null,
					"You have been attacked by a Wolf!", "Battle",
					JOptionPane.PLAIN_MESSAGE, null);
			Battle.battle(new Wolf(3), true, false);
		}
	}
}
