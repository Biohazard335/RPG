package locations.forest;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L1r1 extends Lolcation {
	public L1r1() {
		super(
				1,
				1,
				0,
				"Forest",
				"You find yourself in a dark forest. Any further North or East and you'll get lost.",
				new Object[] { "North", "South", "East", "West" },
				new Fighter[] {}, new Talker[] {});
	}
}
