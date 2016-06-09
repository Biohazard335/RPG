package items;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import locations.Game;
import fight.attacks.Attack;
import fight.attacks.Stab;

public class RustyDagger extends Item {

	public RustyDagger() {
		super(true, "weapon");
	}

	@Override
	public void equip() {
		Game.player.str += 2;
		Game.player.attacks.add(new Stab());
		if (Game.location.heal == false && Game.opening == false) {
			Game.player.attacks.get(Game.player.attacks.size() - 1).down += Game.player.attacks
					.get(Game.player.attacks.size() - 1).cool;
		}
		this.equipped = true;
		if (Game.opening == false)
			JOptionPane.showMessageDialog(null,
					"RustyDagger equipped!\nStr+2\nNew attack: Stab",
					"Equipped", JOptionPane.PLAIN_MESSAGE);

	}

	@Override
	public void unequip() {
		if (Game.opening == false)
			JOptionPane.showMessageDialog(null, "RustyDagger unequipped",
					"Unequipped", JOptionPane.PLAIN_MESSAGE);
		Game.player.str -= 2;
		this.equipped = false;
		ArrayList<Attack> stays = new ArrayList<Attack>();
		for (Attack attack : Game.player.attacks) {
			if (attack.getClass() != new Stab().getClass()) {
				stays.add(attack);
			}
		}
		Game.player.attacks = stays;
	}

}
