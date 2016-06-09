package locations.forest;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L0r1 extends Lolcation {
	public L0r1() {
		super(
				100,
				100,
				0,
				"Castle",
				"The Wizard is waiting for you in the main chamber, having predicted your arrival.",
				new Object[] { "Talk" },
				new Fighter[] {}, new Talker[] {});
	}
}
