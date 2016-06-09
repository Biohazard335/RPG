package menu;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import locations.Game;
import locations.Lolcation;

public class PlayerMaker extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea t = new JTextArea(
			"Welcome\nSelect a class to see it's stats & attacks.", 5, 30);

	private JComboBox<Object> c = new JComboBox<Object>();

	private JButton b = new JButton("Choose");

	public static String choice, attacks = "";

	private static String[] choices = { "Knight", "Assassin", "Slayer" };

	public void init() {
		t.setEditable(false);
		if (Game.player.name.equals("ADMIN")) {
			AdminMaker.ADMiN();
			for (Lolcation l : Game.locations) {
				if (l.x == Game.x && l.y == Game.y && l.z == Game.z) {
					Game.location = l;
					break;
				}
			}
		} else {
			for (Lolcation l : Game.locations) {
				if (l.x == Game.x && l.y == Game.y && l.z == Game.z) {
					Game.location = l;
					break;
				}
			}
			for (String string : choices)
				c.addItem(string);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Game.map.get(PlayerMaker.this).dispose();
					Game.run(Game.game, 350, 200);
				}
			});
			c.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choice = (String) ((JComboBox<?>) e.getSource())
							.getSelectedItem();
					typeAffect tA = new typeAffect();
					for (Method object : typeAffect.class.getDeclaredMethods()) {
						if (object.getName().equals(choice))
							try {
								object.invoke(tA);
							} catch (IllegalAccessException
									| IllegalArgumentException
									| InvocationTargetException e1) {
								e1.printStackTrace();
							}
					}

					t.setText(Game.player.type + ":\n{" + "Str: "
							+ Game.player.str + ", Def: " + Game.player.def
							+ ", Spd: " + Game.player.spd + ", Acc: "
							+ Game.player.acc + "}\nAttacks:\n" + attacks);
					attacks = "";
				}
			});

			Container cp = getContentPane();
			cp.setLayout(new FlowLayout());
			cp.add(t);
			cp.add(c);
			cp.add(b);

		}
	}

}
