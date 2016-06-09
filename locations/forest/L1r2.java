package locations.forest;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L1r2 extends Lolcation {
	public L1r2() {
		super(1, 2, 0, "Forest", "You are in the middle of a dark forest.",
				new Object[] { "North", "South", "West", "East" },
				new Fighter[] {}, new Talker[] {});
	}

	@Override
	public void before() {
		if (Game.items[3].has == false) {
			JOptionPane.showMessageDialog(null,
					"Any further North and you'll get lost!", "Warning!",
					JOptionPane.PLAIN_MESSAGE);
			Game.y -= 1;
			this.check = false;
		}
	}
}
