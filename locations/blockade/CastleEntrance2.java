package locations.blockade;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class CastleEntrance2 extends Lolcation {
	public CastleEntrance2() {
		super(
				1,
				-5,
				0,
				"Castle Entrance",
				"The Wizard's castle stands before you.",
				new Object[] {  "South", "East", "Enter Castle" },
				new Fighter[] {}, new Talker[] {});
	}
	@Override
	public void after(boolean opening) {
		if (opening == false){
			Game.x=100;
			Game.y=100;
		}
			
	}
}
