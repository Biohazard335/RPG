package locations.mountain;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.Wolf;

public class L1r_2 extends Lolcation {
	public L1r_2() {
		super(
				1,
				-2,
				0,
				"Mountain",
				"From far above, you can see a valley below you to the West."
						+ " There is a dungeon to the east, and the path continues to the North."
						+"\nTo the distant south, across a feild, the mountain on the other side has a large castle sitting atop it. ",
				new Object[] { "North", "East" }, new Fighter[] {},
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
