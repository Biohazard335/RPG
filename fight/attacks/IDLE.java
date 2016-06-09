package fight.attacks;

import fight.classes.Fighter;

public class IDLE extends Attack {

	public IDLE() {
		super(0, 0, 0, 0, "did nothing to");
	}

	@Override
	public boolean dodge(Fighter attacker, Fighter defender) {
		return false;

	}

	@Override
	public void affect(Fighter attacker, Fighter defender) {
		;
	}

}
