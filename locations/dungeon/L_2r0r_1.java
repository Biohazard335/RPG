package locations.dungeon;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;

import Talk.talkers.Talker;

import fight.classes.Fighter;

public class L_2r0r_1 extends Lolcation {
	public L_2r0r_1() {
		super(
				-2,
				0,
				-1,
				"Dungeon",
				"A large dungeon expands to the East and South. The exit lies above."
						+ " \nCaution is advised, there may be monsters lurking.",
				new Object[] { "Up", "South", "East" }, new Fighter[] {},
				new Talker[] {});
	}

	@Override
	public void before() {
		if (Game.items[8].has == false) {
			JOptionPane.showMessageDialog(null, "The Dungeon is locked!",
					"Warning!", JOptionPane.PLAIN_MESSAGE);
			Game.z += 1;
			this.check = false;
		} else
			this.check = true;
	}
}
