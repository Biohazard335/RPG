package locations.forest;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;

import Talk.talkers.Talker;

import fight.classes.Fighter;

public class L_1r1 extends Lolcation {
	public L_1r1() {
		super(
				-1,
				1,
				0,
				"Forest",
				"You are in the middle of a dense forest. You'd need a map to go any further North or West."
						+ " \nThere is a key lying on the ground",
				new Object[] { "North", "South", "West", "East", "Take Key" },
				new Fighter[] {}, new Talker[] {});
	}

	@Override
	public void after(boolean opening) {
		if (opening == false)
			JOptionPane.showMessageDialog(null, "You took the key", "Items",
					JOptionPane.PLAIN_MESSAGE);
		Game.items[0].has = true;
		this.description = "You are in the middle of a dense forest. \nYou'd need a map to go any further North or West.";
		this.options = new Object[] { "North", "South", "West", "East" };
		this.done = true;
	}
}
