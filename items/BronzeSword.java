package items;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import locations.Game;
import fight.attacks.Attack;
import fight.attacks.Impale;
import fight.attacks.Slice;

public class BronzeSword extends Item {

	public BronzeSword() {
		super(true, "weapon");
	}

	@Override
	public void equip() {
		String attack = "";
		Game.player.str += 5;
		Game.player.attacks.add(new Slice());
		if (Game.player.type.equals("Knight")) {
			Game.player.attacks.add(new Impale());
			attack = ", Impale";
		}
		if (Game.location.heal == false && Game.opening == false) {
			Game.player.attacks.get(Game.player.attacks.size() - 1).down += Game.player.attacks
					.get(Game.player.attacks.size() - 1).cool;
			if (Game.player.type.equals("Knight"))
				Game.player.attacks.get(Game.player.attacks.size() - 2).down += Game.player.attacks
						.get(Game.player.attacks.size() - 2).cool;

		}
		this.equipped = true;
		if (Game.opening == false)
			JOptionPane
					.showMessageDialog(null,
							"BronzeSword equipped!\nStr+5\nNew attacks: Slice"
									+ attack, "Equipped",
							JOptionPane.PLAIN_MESSAGE);

	}

	@Override
	public void unequip() {
		if (Game.opening == false)
			JOptionPane.showMessageDialog(null, "BronzeSword unequipped",
					"Unequipped", JOptionPane.PLAIN_MESSAGE);
		Game.player.str -= 5;
		this.equipped = false;
		ArrayList<Attack> stays = new ArrayList<Attack>();
		for (Attack attack : Game.player.attacks) {
			if (attack.getClass() != new Slice().getClass()
					&& attack.getClass() != new Impale().getClass()) {
				stays.add(attack);
			}
		}
		Game.player.attacks = stays;
	}
}
