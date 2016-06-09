package fight.attacks;

import fight.classes.Fighter;

public class All extends Attack {

	public All() {
		super(0, 0, 0, 0, "");
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
