package fight.classes;

import fight.attacks.Attack;
import fight.attacks.Kick;
import fight.attacks.Punch;

public class Player extends Fighter {

	public Player() {
		super(3, 3, 4, 4, new Attack[] { new Punch(), new Kick() }, "");
	}
}
