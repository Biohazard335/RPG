package locations.dungeon;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.CaveSpider;
import fight.classes.Fighter;

public class L2r_3r_1 extends Lolcation {

	public L2r_3r_1() {
		super(
				2,
				-3,
				-1,
				"Dungeon",
				"The dungeon exit is out of sight, but there is a new exit to the North. The South and East are blocked,"
						+ " it is too dark to see what lies to the West.",
				new Object[] { "North", "West" }, new Fighter[] {},
				new Talker[] {});
		this.heal = false;
		this.flee = false;
	}

	@Override
	public void before() {
		int d = 1 + (int) (Math.random() * 3);
		if (d == 3) {
			JOptionPane.showMessageDialog(null,
					"You have been attacked by a Cave spider!", "Battle",
					JOptionPane.PLAIN_MESSAGE, null);
			Battle.battle(new CaveSpider(3), false, false);
		}
	}
}
