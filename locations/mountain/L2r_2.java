package locations.mountain;

import Talk.talkers.Talker;
import fight.classes.Fighter;
import locations.Lolcation;

public class L2r_2 extends Lolcation {

	public L2r_2() {
		super(
				2,
				-2,
				0,
				"Mountain",
				"High on the mountain side, the path extends in all directions but South. There is an entrance to the dungeon leading down.",
				new Object[] { "North", "West", "East", "Down" },
				new Fighter[] {}, new Talker[] {});
	}

}
