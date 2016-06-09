package fight.classes;

import fight.attacks.Attack;
import fight.attacks.Bite;
import fight.attacks.Lunge;

public class CaveSpider extends Fighter {

	public CaveSpider(int lvl) {
		super(2, 2, 3, 4, new Attack[] { new Bite(), new Lunge() },
				"Cave Spider");
		cpuLevel(lvl);
	}
}
