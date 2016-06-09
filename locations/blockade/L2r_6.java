package locations.blockade;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L2r_6 extends Lolcation {
	public L2r_6() {
		super(
				2,
				-6,
				0,
				"Mountain",
				"You've passed he blockade.\n"
				+"The Castle looms just to the West. The mountian blocks the south.",
				new Object[] {  "North", "East", "West" },
				new Fighter[] {}, new Talker[] {});
	}
}
