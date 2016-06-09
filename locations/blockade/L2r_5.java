package locations.blockade;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L2r_5 extends Lolcation {
	public L2r_5() {
		super(
				2,
				-5,
				0,
				"Mountain",
				"You've passed he blockade.\n"
				+"The Castle looms just to the West. To the north you can see a tiny bridge way down at the mountain's base.",
				new Object[] {  "South", "East", "West" },
				new Fighter[] {}, new Talker[] {});
	}
}
