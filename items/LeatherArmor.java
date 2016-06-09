package items;

import javax.swing.JOptionPane;

import locations.Game;

public class LeatherArmor extends Item {
	public LeatherArmor() {
		super(true, "armor");
	}

	@Override
	public void equip() {
		Game.player.def += 5;
		this.equipped = true;
		if (Game.opening == false)
			JOptionPane.showMessageDialog(null,
					"LeatherArmor equipped!\nDef+5", "Equipped",
					JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void unequip() {
		if (Game.opening == false)
			JOptionPane.showMessageDialog(null, "LeatherArmor unequipped",
					"Unequipped", JOptionPane.PLAIN_MESSAGE);
		Game.player.def -= 5;
		this.equipped = false;

	}

}
