package locations.forest;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L2r1 extends Lolcation {
	public L2r1() {
		super(
				2,
				1,
				0,
				"Forest",
				"You are in the middle of a dense forest. The South is blocked by the mountainside.",
				new Object[] { "North", "South", "West", "East" },
				new Fighter[] {}, new Talker[] {});
	}

	@Override
	public void before() {
		if (Game.items[3].has == false) {
			JOptionPane.showMessageDialog(null,
					"Any further East and you'll get lost!", "Warning!",
					JOptionPane.PLAIN_MESSAGE);
			Game.x -= 1;
			this.check = false;
		}
	}
}
