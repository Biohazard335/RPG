package locations.dungeon;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;
import Talk.talkers.Talker;
import fight.attacks.Attack;
import fight.classes.Fighter;

public class L1r_2r_1 extends Lolcation {

	public L1r_2r_1() {
		super(
				1,
				-2,
				-1,
				"Dungeon",
				"The dungeon exit is out of sight. The North, South, and East are blocked."
						+ " In the center of the room there is a large glowing rock, at"
						+ " it's based it is inscribed: \n\"Healing Rock\"",
				new Object[] { "West", "Heal" }, new Fighter[] {},
				new Talker[] {});
		this.heal = false;
		this.flee = false;
	}

	@Override
	public void after(boolean opening) {
		if (opening == false) {
			JOptionPane.showMessageDialog(null,
					"The rock has healed you and cooled your attacks",
					"Healed", JOptionPane.PLAIN_MESSAGE);
			Game.player.hp = 100;
			for (Attack attack : Game.player.attacks)
				attack.down = 0;
		}
	}
}
