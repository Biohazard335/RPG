package locations;

import Talk.talkers.Talker;
import fight.classes.Fighter;
import locations.Lolcation;

public class Basic extends Lolcation {
	public Basic() {
		super(
				0,
				0,
				0,
				"Forest",
				"You are in the middle of a dark forest. There is a valley to the south.",
				new Object[] { "North", "South", "West", "East" },
				new Fighter[] {}, new Talker[] {});
	}
}
