package locations.blockade;

import locations.Lolcation;
import Talk.talkers.T3r_3;
import Talk.talkers.Talker;
import fight.classes.Fighter;
import fight.classes.ImperialGuard;

public class L3r_3 extends Lolcation {
	public L3r_3() {
		super(
				3,
				-3,
				0,
				"Blockade",
				"An Imperial Guard stands at the front of the blockade, the steep cliff protecting from the West. He looks at you with suspicion.",
				new Object[] { "North", "East", "Talk", "Fight!" },
				new Fighter[] { new ImperialGuard(6) },
				new Talker[] { new T3r_3() });
	}

	@Override
	public void afterMath(int chosen) {
		this.description = "The blockade is empty in this area.";
		this.options = new Object[] { "North","South", "East" };
		this.fighters = new Fighter[] {};
		this.talkers = new Talker[] {};
		this.afterMath = chosen;
	}
}
