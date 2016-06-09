package fight.attacks;

import fight.classes.Fighter;

public class DECIMATE extends Attack {

	public DECIMATE() {
		super(0, 0, 0, 0, "decimated");
	}

	@Override
	public boolean dodge(Fighter attacker, Fighter defender) {
		return false;
	}

	@Override
	public void affect(Fighter attacker, Fighter defender) {
		defender.hp = 0;
	}

}
