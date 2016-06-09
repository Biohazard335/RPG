package locations.field;

import locations.Lolcation;
import Talk.talkers.Talker;
import Talk.talkers.VillageBlackSmith;
import Talk.talkers.VillageChild;
import Talk.talkers.VillageWoman;
import fight.classes.Fighter;

public class L_1r_4 extends Lolcation {
	public L_1r_4() {
		super(
				-1,
				-4,
				0,
				"Village",
				"It is a small village filled with sad, depraved looking citizens."
						+ " Across the river, to the North, there is some sort of statue."
						+ " \nThe South is blocked by a large gate gaurded by"
						+ " Imperial Soldiers, the West is blocked by the mountains.",
				new Object[] { "East", "Talk" }, new Fighter[] {},
				new Talker[] { new VillageWoman(), new VillageBlackSmith(),
						new VillageChild() });
	}
}
