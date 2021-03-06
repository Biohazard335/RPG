package locations.dungeon;

import javax.swing.JOptionPane;

import locations.Lolcation;
import Talk.talkers.Talker;
import fight.Battle;
import fight.classes.CaveSpider;
import fight.classes.Fighter;

public class L_1r_2r_1 extends Lolcation {

	public L_1r_2r_1() {
		super(
				-1,
				-2,
				-1,
				"Dungeon",
				"The dungeon exit is out of sight. The South and West are blocked,"
						+ " it is too dark to see what lies to the North, but there is a faint light coming from the far East",
				new Object[] { "North", "East" }, new Fighter[] {},
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
