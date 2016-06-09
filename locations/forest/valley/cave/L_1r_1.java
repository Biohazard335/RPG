package locations.forest.valley.cave;

import locations.Lolcation;
import Talk.talkers.T_1r_1;
import Talk.talkers.Talker;
import fight.classes.Fighter;
import fight.classes.Troll;

public class L_1r_1 extends Lolcation {
	public L_1r_1() {
		super(
				-1,
				-1,
				0,
				"Cave",
				"In the dark cave, there is a powerful Troll guarding"
						+ " some sort of fortress to the South. \nChallenging the Troll without a weapon is not advised."
						+ " \nThe only other exit is to the East.",
				new Object[] { "East", "Talk", "Fight!" },
				new Fighter[] { new Troll(3) }, new Talker[] { new T_1r_1() });
	}

	@Override
	public void afterMath(int chosen) {
		this.description = "In the dark cave, there is some sort of fortress to the South. The only other exit is to the East.";
		this.options = new Object[] { "South", "East" };
		this.fighters = new Fighter[] {};
		this.talkers = new Talker[] {};
		this.afterMath = chosen;
	}
}
