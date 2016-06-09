package fight.classes;

import fight.attacks.Attack;
import fight.attacks.Kick;
import fight.attacks.Punch;
import fight.attacks.ShieldSlam;
import fight.attacks.Slice;

public class ImperialGuard extends Fighter {

	public ImperialGuard(int lvl) {
		super(6, 5, 2, 4, new Attack[] { new Punch(), new Kick(), new Slice(),
				new ShieldSlam() }, "Imperial Guard");
		cpuLevel(lvl);
	}

}
