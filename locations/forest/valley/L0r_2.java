package locations.forest.valley;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.classes.Fighter;

public class L0r_2 extends Lolcation {
	public L0r_2() {
		super(
				0,
				-2,
				0,
				"Valley",
				"In the distance, there is a forest to the North. To the South, the valley opens up to a field.",
				new Object[] { "North", "South" }, new Fighter[] {},
				new Talker[] {});
	}

	@Override
	public void before() {
		if (Game.items[1].equipped == false) {
			JOptionPane.showMessageDialog(null, "You need armor to pass!",
					"Warning!", JOptionPane.PLAIN_MESSAGE);
			Game.y += 1;
			this.check = false;
		} else
			this.check = true;
	}
}
