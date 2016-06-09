package menu;

import fight.attacks.Attack;
import items.Back;
import items.Item;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import locations.Game;
import locations.Lolcation;

public class Save {
	static Item armor = new Back(), weapon = new Back();

	public static void save() {
		Game.opening = true;
		for (Item item : Game.items) {
			if (item.equipped == true) {
				if (item.type.equals("armor")) {
					armor = item;
				} else if (item.type.equals("weapon")) {
					weapon = item;
				}
				item.unequip();
			}
		}
		BufferedWriter writer;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"./data/saveFiles.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(Game.player.name)) {
					break;
				}
			}
			if (line == null) {
				writer = new BufferedWriter(new FileWriter(
						"./data/saveFiles.txt", true));
				writer.write(Game.player.name);
				writer.newLine();
				writer.flush();
				writer.close();
			}
			reader.close();

			FileOutputStream writer1 = new FileOutputStream("./data/"
					+ Game.player.name + ".txt");
			writer1.write((new String()).getBytes());
			writer1.close();

			writer = new BufferedWriter(new FileWriter("./data/"
					+ Game.player.name + ".txt", true));
			writer.write("x " + Game.x + "\n");
			writer.write("y " + Game.y + "\n");
			writer.write("z " + Game.z + "\n");
			writer.write("type " + Game.player.type + "\n");
			writer.write("str " + Game.player.str + "\n");
			writer.write("def " + Game.player.def + "\n");
			writer.write("spd " + Game.player.spd + "\n");
			writer.write("acc " + Game.player.acc + "\n");
			writer.write("level " + Game.player.level + "\n");
			writer.write("xp " + Game.player.xp + "\n");
			writer.write("hp " + Game.player.hp + "\n");
			writer.write("armor " + armor.getClass().getSimpleName() + "\n");
			writer.write("weapon " + weapon.getClass().getSimpleName() + "\n");
			for (Attack attack : Game.player.attacks) {
				if (attack.down != 0)
					writer.write("attack " + attack.getClass().getSimpleName()
							+ " " + attack.down + "\n");
			}
			for (Item item : Game.items) {
				if (item.has == true && item.equipped == false)
					writer.write(item.getClass().getSimpleName() + "\n");

			}
			for (Lolcation location : Game.locations) {
				if (location.explored == true)
					writer.write(location.getClass().getSimpleName() + "\n");
				if (location.afterMath != -1)
					writer.write(location.getClass().getSimpleName() + " "
							+ location.afterMath + "\n");
				if (location.done == true)
					writer.write(location.getClass().getSimpleName() + " a\n");

			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		armor.equip();
		weapon.equip();
		Game.opening = false;
		JOptionPane.showMessageDialog(null, "Your game has been saved!",
				"Success!", JOptionPane.PLAIN_MESSAGE);
	}
}
