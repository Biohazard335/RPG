package fight.classes;

import fight.attacks.Attack;
import fight.attacks.Bash;
import fight.attacks.Kick;
import fight.attacks.Punch;

public class Troll extends Fighter {

	public Troll(int lvl) {
		super(6, 4, 1, 3, new Attack[] { new Punch(), new Kick(), new Bash() },
				"Troll");
		cpuLevel(lvl);
	}

}
