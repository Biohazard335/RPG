package locations.forest.valley.cave;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L_1r_2 extends Lolcation {
	public L_1r_2() {
		super(
				-1,
				-2,
				0,
				"Cave",
				"It appears to be an armory. The place seems to be abandoned. \nThere is a suit of armor on the wall.",
				new Object[] { "North", "Take armor" }, new Fighter[] {},
				new Talker[] {});
	}

	@Override
	public void before() {
		if (Game.items[0].has == false) {
			JOptionPane.showMessageDialog(null, "The Fortress is locked!",
					"Warning!", JOptionPane.PLAIN_MESSAGE);
			this.check = false;
			Game.y = -1;
		} else {
			this.check = true;
		}
	}

	@Override
	public void after(boolean opening) {
		if (opening == false)
			JOptionPane.showMessageDialog(null, "You took the armor.", "Items",
					JOptionPane.PLAIN_MESSAGE);
		this.check = true;
		this.options = new Object[] { "North" };
		this.description = "It appears to be an armory. The place seems to be abandoned";
		Game.items[1].has = true;
		this.done = true;
	}
}
