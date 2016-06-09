package fight.classes;

import fight.attacks.Attack;
import fight.attacks.DECIMATE;
import fight.attacks.IDLE;
import fight.attacks.RESTORE;

public class ADMIN extends Fighter {

	public ADMIN() {
		super(3, 3, 4, 4, new Attack[] { new DECIMATE(), new IDLE(),
				new RESTORE() }, "ADMIN");
	}

}
