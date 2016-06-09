package locations.field;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L_2r_3 extends Lolcation {
	public L_2r_3() {
		super(
				-2,
				-3,
				0,
				"Field",
				"At the end of the field, there is a mountain trail leading North."
						+ " The field continues to the East."
						+ " The West is blocked by the mountainside, the South is blocked by the river.",
				new Object[] { "North", "East" }, new Fighter[] {},
				new Talker[] {});
	}
}
