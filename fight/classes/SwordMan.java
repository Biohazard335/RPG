package fight.classes;

import fight.attacks.Attack;
import fight.attacks.Kick;
import fight.attacks.Punch;
import fight.attacks.Slice;

public class SwordMan extends Fighter {

	public SwordMan(int lvl) {
		super(3, 2, 2, 3,
				new Attack[] { new Punch(), new Kick(), new Slice() }, "Man");
		cpuLevel(lvl);
	}

}
