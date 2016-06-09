package locations.blockade;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.Fighter;
import fight.classes.ImperialGuard;

public class L4r_6 extends Lolcation {

	public L4r_6() {
		super(
				4,
				-6,
				0,
				"Mountain",
				"To the West, the mountain acsends upwards, to a snow covered peak,"
				+"crowned by a giant castle. The South and East are blocked by the mountain."
					+"\nThere is an odd piece of carved stone on the ground, it appears as though it broke off from something.",
				new Object[] { "North", "West", "Take Statue Piece" },
				new Fighter[] {}, new Talker[] {});
	}

	@Override
	public void before() {
		int d = 1 + (int) (Math.random() * 3);
		if (d == 3) {
			JOptionPane.showMessageDialog(null,
					"Imperial Guard:\"Hey! You're not supposed to be here!\"\nYou are attacked by an Imperial Guard.", "Battle",
					JOptionPane.PLAIN_MESSAGE, null);
			Battle.battle(new ImperialGuard(6), true, false);
		}
	}
	@Override
	public void after(boolean opening) {
		if (opening == false)
			JOptionPane.showMessageDialog(null, "You took the statue piece", "Items",
					JOptionPane.PLAIN_MESSAGE);
		Game.items[9].has = true;
		this.description = 
				"To the West, the mountain acsends upwards, to a snow covered peak,"
				+"crowned by a giant castle. The South and East are blocked by the mountain.";
		this.options = new Object[] { "North", "West", };
		this.done = true;
	}
}
