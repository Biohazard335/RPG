package locations.field;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L1r_3 extends Lolcation {
	public L1r_3() {
		super(
				1,
				-3,
				0,
				"Field",
				"In the wide feild, the North is blocked by the mountainside, and the South is blocked by the river."
						+ " \nTo the West is an open field, to the SouthEast is a bridge.",
				new Object[] { "West", "East" }, new Fighter[] {},
				new Talker[] {});
	}
}
