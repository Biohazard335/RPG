package locations.forest;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;

import Talk.talkers.T1r0;
import Talk.talkers.Talker;
import fight.classes.Fighter;
import fight.classes.SwordMan;

public class L1r0 extends Lolcation {
	public L1r0() {
		super(
				1,
				0,
				0,
				"Forest",
				"You find yourself in a dark forest. The South and East are blocked by the mountain side."
						+ " \nThere is a Man with a sword resting against the rocks.",
				new Object[] { "North", "West", "Talk" },
				new Fighter[] { new SwordMan(3) }, new Talker[] { new T1r0() });

	}

	@Override
	public void afterMath(int chosen) {
		this.description = "You find yourself in a dark forest. The South and East are blocked by a mountainside."
				+ " \nThere is a sword resting againt the rocks";
		this.options = new Object[] { "North", "West", "Take sword" };
		this.fighters = new Fighter[] {};
		this.talkers = new Talker[] {};
		this.afterMath = chosen;

	}

	@Override
	public void after(boolean opening) {
		if (opening == false) {
			JOptionPane.showMessageDialog(null, "You took the sword.", "Items",
					JOptionPane.PLAIN_MESSAGE);
		}
		Game.items[2].has = true;
		this.description = "You find yourself in a dark forest. The South and East are blocked by a mountainside";
		this.options = new Object[] { "North", "West" };
		this.done = true;
	}
}
