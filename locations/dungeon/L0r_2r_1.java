package locations.dungeon;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.CaveSpider;
import fight.classes.Fighter;

public class L0r_2r_1 extends Lolcation {

	public L0r_2r_1() {
		super(
				0,
				-2,
				-1,
				"Dungeon",
				"The dungeon exit is out of sight. It is too dark to see what lies to the North, South,"
						+ " or West, but there is a stange light emanating from a large rock the East.",
				new Object[] { "North", "South", "West", "East" },
				new Fighter[] {}, new Talker[] {});
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
