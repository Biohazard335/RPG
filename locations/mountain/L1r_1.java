package locations.mountain;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.Wolf;

public class L1r_1 extends Lolcation {
	public L1r_1() {
		super(1, -1, 0, "Mountain",
				"The edge of the mountain prevents you from going any futher North or West, "
						+ "The path continues to the South and East.",
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
