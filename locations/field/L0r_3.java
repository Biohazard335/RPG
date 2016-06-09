package locations.field;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L0r_3 extends Lolcation {
	public L0r_3() {
		super(
				0,
				-3,
				0,
				"Field",
				"You are in the middle of clearing. There is a valley to the North."
						+ " The South is blocked by a river."
						+ " There is a large statue to the West, there appears to be a bridge far to the East."
						, new Object[] {
						"North", "West", "East" }, new Fighter[] {},
				new Talker[] {});
	}
}
