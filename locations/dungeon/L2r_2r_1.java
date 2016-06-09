package locations.dungeon;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L2r_2r_1 extends Lolcation {
	public L2r_2r_1() {
		super(
				2,
				-2,
				-1,
				"Dungeon",
				"A large dungeon expands to the South. The exit lies above."
						+ " \nCaution is advised, there may be monsters lurking.",
				new Object[] { "Up", "South" }, new Fighter[] {},
				new Talker[] {});
	}
}
