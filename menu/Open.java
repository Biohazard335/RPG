package menu;

import fight.attacks.Attack;
import items.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import locations.Game;
import locations.Lolcation;

public class Open {
	public static void open() throws IOException {
		Game.opening = true;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./data/"
					+ Game.player.name + ".txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				// splits line into different strings at every " ", puts them
				// into array
				String[] components = line.split(" ");
				if (components[0].equals("type")) {
					Game.player.type = components[1];
					typeAffect tA = new typeAffect();
					for (Method object : typeAffect.class.getDeclaredMethods()) {
						if (object.getName().equals(components[1]))
							try {
								object.invoke(tA);
							} catch (IllegalAccessException e1) {
								e1.printStackTrace();
							} catch (IllegalArgumentException e1) {
								e1.printStackTrace();
							} catch (InvocationTargetException e1) {
								e1.printStackTrace();
							}
					}
				} else if (components[0].equals("x")) {
					Game.x = Integer.parseInt(components[1]);
				} else if (components[0].equals("y")) {
					Game.y = Integer.parseInt(components[1]);
				} else if (components[0].equals("z")) {
					Game.z = Integer.parseInt(components[1]);
					for (Lolcation l : Game.locations) {
						if (l.x == Game.x && l.y == Game.y && l.z == Game.z) {
							Game.location = l;
							break;
						}
					}
				} else if (components[0].equals("str")) {
					Game.player.str = Integer.parseInt(components[1]);
				} else if (components[0].equals("def")) {
					Game.player.def = Integer.parseInt(components[1]);
				} else if (components[0].equals("spd")) {
					Game.player.spd = Integer.parseInt(components[1]);
				} else if (components[0].equals("acc")) {
					Game.player.acc = Integer.parseInt(components[1]);
				} else if (components[0].equals("level")) {
					Game.player.level = Integer.parseInt(components[1]);
				} else if (components[0].equals("xp")) {
					Game.player.xp = Double.parseDouble(components[1]);
				} else if (components[0].equals("hp")) {
					Game.player.hp = Integer.parseInt(components[1]);
				} else if (components[0].equals("armor")) {
					for (Item item : Game.items)
						if (item.getClass().getSimpleName()
								.equals(components[1])) {
							item.equip();
							break;
						}
				} else if (components[0].equals("weapon")) {
					for (Item item : Game.items)
						if (item.getClass().getSimpleName()
								.equals(components[1])) {
							item.equip();
							break;
						}
				} else if (components[0].equals("attack")) {
					for (Attack attack : Game.player.attacks)
						if (attack.getClass().getSimpleName()
								.equals(components[1])) {
							attack.down = Integer.parseInt(components[2]);
							break;
						}
				}
				for (Item item : Game.items)
					if (components[0].equals(item.getClass().getSimpleName())) {
						item.has = true;
					}
				for (Lolcation location : Game.locations) {
					if (components[0].equals(location.getClass()
							.getSimpleName())) {
						location.explored = true;
						if (components.length != 1
								&& !components[1].equals("a"))
							location.afterMath(Integer.parseInt(components[1]));
						if (components.length != 1 && components[1].equals("a"))
							location.after(true);
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Game.opening = false;
	}
}
