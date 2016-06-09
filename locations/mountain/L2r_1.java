package locations.mountain;

import javax.swing.JOptionPane;

import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.Wolf;
import locations.Lolcation;

public class L2r_1 extends Lolcation {
	public L2r_1() {
		super(
				2,
				-1,
				0,
				"Mountain",
				"The path continues in all directions. There is a dungeon entrance to the South.",
				new Object[] { "North", "South", "West", "East" },
				new Fighter[] {}, new Talker[] {});
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
