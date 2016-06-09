package items;

import javax.swing.JOptionPane;

import locations.Game;

public class BronzeArmor extends Item {

	public BronzeArmor() {
		super(true, "armor");
	}

	@Override
	public void equip() {
		Game.player.def += 10;
		this.equipped = true;
		if (Game.opening == false) {
			JOptionPane.showMessageDialog(null, "BronzeArmor equipped!\nDef+5",
					"Equipped", JOptionPane.PLAIN_MESSAGE);
		}
	}

	@Override
	public void unequip() {
		if (Game.opening == false) {
			JOptionPane.showMessageDialog(null, "BronzeArmor unequipped",
					"Unequipped", JOptionPane.PLAIN_MESSAGE);
		}
		Game.player.def -= 5;
		this.equipped = false;

	}

}
