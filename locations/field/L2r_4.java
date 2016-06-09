package locations.field;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L2r_4 extends Lolcation {
	public L2r_4() {
		super(
				2,
				-4,
				0,
				"Field",
				"The South and East are blocked by the mountains."
						+ " To the North, there is a bridge, to the far West a small Village.",
				new Object[] { "North", "West" }, new Fighter[] {},
				new Talker[] {});
	}
}
