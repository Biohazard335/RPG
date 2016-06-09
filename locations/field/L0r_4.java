package locations.field;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L0r_4 extends Lolcation {
	public L0r_4() {
		super(
				0,
				-4,
				0,
				"Field",
				"In the wide field, the North is blocked by the river, and the South is blocked by the mountains."
						+ " High on the mountain you can see some sort of castle."
						+ " \nTo the far East there is a bridge, to the West a small Village.",
				new Object[] { "West", "East" }, new Fighter[] {},
				new Talker[] {});
	}
}
