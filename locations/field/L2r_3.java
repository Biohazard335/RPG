package locations.field;

import locations.Lolcation;
import Talk.talkers.T2r_3;
import Talk.talkers.Talker;
import fight.classes.Fighter;
import fight.classes.ImperialGuard;

public class L2r_3 extends Lolcation {
	public L2r_3() {
		super(
				2,
				-3,
				0,
				"Field",
				"The Bridge to the South is blocked by an Imperial Guard with a Scimitar and sheild."
						+ " \nThe mountain blocks the North and East, to the West the field continues.",
				new Object[] { "West", "Talk" },
				new Fighter[] { new ImperialGuard(3) },
				new Talker[] { new T2r_3() });
	}

	@Override
	public void afterMath(int chosen) {
		this.description = "There is a bridge across the river to the south."
				+ " \nThe mountain blocks the North and East, to the West the field continues.";
		this.options = new Object[] { "South", "West" };
		this.fighters = new Fighter[] {};
		this.talkers = new Talker[] {};
		this.afterMath = chosen;
	}
}
