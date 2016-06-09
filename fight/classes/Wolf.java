package fight.classes;

import fight.attacks.*;

public class Wolf extends Fighter {

	public Wolf(int lvl) {
		super(7, 7, 8, 7, new Attack[] { new Bite(), new Lunge(),
				new Masticate() }, "Wolf");
		cpuLevel(lvl);
	}

}
