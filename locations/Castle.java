package locations;

import Talk.talkers.TWizard;
import Talk.talkers.Talker;
import locations.Lolcation;
import fight.classes.Fighter;
import fight.classes.Wizard;

public class Castle extends Lolcation {
	public Castle() {
		super(
				100,
				100,
				0,
				"Castle",
				"You find yourself face to face with a powerful Wizard.\nHe knew you were coming.",
				new Object[] { "Talk" },
				new Fighter[] {new Wizard()}, new Talker[] {new TWizard()});
	}
}
