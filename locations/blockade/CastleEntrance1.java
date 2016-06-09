package locations.blockade;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class CastleEntrance1 extends Lolcation {
	public CastleEntrance1() {
		super(
				1,
				-6,
				0,
				"Castle Entrance",
				"The Wizard's castle stands before you.",
				new Object[] {  "North", "East", "Enter Castle" },
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
