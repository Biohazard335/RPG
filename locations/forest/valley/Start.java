package locations.forest.valley;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;

import Talk.talkers.Talker;
import fight.classes.Fighter;

public class Start extends Lolcation {
	public Start() {
		super(
				0,
				-1,
				0,
				"Valley",
				"You find yourself in a valley, to the West is an ominous cave."
						+ " To the North is a forest, to the East is a sheer wall of rock."
						+ " Down the valley, to the south, rocks are falling from the ledge, you'd need armor to pass."
						+ " \nThere is a rusty dagger on the ground",
				new Object[] { "North", "South", "West", "Take Dagger" },
				new Fighter[] {}, new Talker[] {});
		this.explored = true;
	}

	@Override
	public void after(boolean opening) {
		if (opening == false) {
			JOptionPane
					.showMessageDialog(
							null,
							"You took the Dagger!\nEquip items from the menu\n(press \"Menu\" from the main screen)",
							"Items", JOptionPane.PLAIN_MESSAGE);
		}
		Game.items[7].has = true;
		this.description = "You find yourself in a valley, to the West is an ominous cave."
				+ " To the North is a forest, to the East is a sheer wall of rock."
				+ " Down the valley, to the south, rocks are falling from the ledge, you'd need armor to pass.";
		this.options = new Object[] { "North", "South", "West" };
		this.done = true;
	}
}
