package fight.classes;

import locations.Game;
import fight.attacks.Attack;

public class Wizard extends Fighter {

	public Wizard() {
		super(8, 4, 6, 4, new Attack[] {  }, "Wizard");
		cpuLevel(Game.player.level);
	}
}
