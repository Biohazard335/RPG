package menu;

import fight.attacks.Attack;
import items.Back;
import items.Item;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import locations.Game;

public class Menu {
	public static Object[] menu = { "Character", "Equipment", "Game", "Save",
			"Quit" };

	public static void menu() {
		do {
			Object choice = JOptionPane.showInputDialog(null, "Menu", "Menu",
					JOptionPane.PLAIN_MESSAGE, null, menu, menu[2]);
			if (choice == "Equipment") {
				Object choice2;
				do {
					// determine which held items are "equippable"
					ArrayList<Item> equips = new ArrayList<Item>();
					for (Item item : Game.items) {
						if (item.has == true && item.equippable == true)
							equips.add(item);
					}
					// determine which armor is equipped (generate String)
					String message = "Armor: ";
					for (Item item : Game.items) {
						if (item.has == true && item.equipped == true
								&& item.type.equals("armor"))
							message += item.getClass().getSimpleName();
					}
					if (message.equals("Armor: "))
						message += "none";
					// determine which weapon is equipped (generate String)
					String message1 = "\nWeapon: ";
					for (Item item : Game.items) {
						if (item.has == true && item.equipped == true
								&& item.type.equals("weapon"))
							message1 += item.getClass().getSimpleName();
					}
					if (message1.equals("\nWeapon: "))
						message1 += "none";
					message += message1;
					// determine which unequippable items are held and generates
					// String
					String message2 = "\nItems: ";
					for (Item item : Game.items) {
						if (item.has == true && item.equippable == false
								&& item.type.equals("item"))
							message2 += item.getClass().getSimpleName() + ", ";
					}
					if (message2.equals("\nItems: "))
						message2 += "none";
					message += message2 + "\n\nEquip/Unequip:";

					// display message
					Item[] equipables = equips.toArray(new Item[equips.size()]);
					ArrayList<String> equipnames = new ArrayList<String>();
					for (Item item : equipables)
						equipnames.add(item.getClass().getSimpleName());
					String[] equipablesNames = equipnames
							.toArray(new String[equipnames.size()]);
					choice2 = (String) JOptionPane.showInputDialog(null,
							message, "Equipment", JOptionPane.PLAIN_MESSAGE,
							null, equipablesNames, equipablesNames[0]);
					// equip items
					Item i = new Back();
					for (Item item : Game.items) {
						if (item.getClass().getSimpleName().equals(choice2)) {
							i = item;
						}
					}
					if (i.equipped == true)
						i.unequip();
					else if (i == Game.items[4])
						break;
					else {
						for (Item item : Game.items) {
							if (item.equipped == true
									&& item.type.equals(i.type)) {
								item.unequip();
							}
						}
						i.equip();
					}
				} while (true);
			} else if (choice == "Save") {
				Save.save();
			} else if (choice == "Game") {
				break;
			} else if (choice == "Character") {
				String attacks = "\nAttacks:\n";
				for (Attack attack : Game.player.attacks) {
					attacks += attack.getClass().getSimpleName() + ", ";
				}
				JOptionPane.showMessageDialog(null,
						Game.player.name + ":\n" + Game.player.type
								+ "\nLevel: " + Game.player.level + ", XP: "
								+ Game.player.xp + "\n" + Game.player.stats()
								+ "\n" + attacks, "Character",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				Game.f = JOptionPane
						.showConfirmDialog(
								null,
								"Are you sure you want to quit? \n All unsaved progress will be lost.",
								"Menu", JOptionPane.YES_NO_OPTION,
								JOptionPane.PLAIN_MESSAGE, null);
				if (Game.f == 0)
					System.exit(0);
			}
		} while (true);

	}
}
