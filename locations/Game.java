package locations;

import items.ArmoryKey;
import items.Back;
import items.BronzeArmor;
import items.BronzeSword;
import items.DungeonKey;
import items.Item;
import items.LeatherArmor;
import items.RebelMap;
import items.RustyDagger;
import items.StatuePiece;
import items.SteelSword;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import locations.dungeon.*;
import locations.field.*;
import locations.field.mountainPath.*;
import locations.forest.*;
import locations.forest.valley.*;
import locations.forest.valley.cave.*;
import locations.mountain.*;
import locations.blockade.*;
import menu.AdminMaker;
import menu.Menu;
import menu.Open;
import menu.PlayerMaker;
import menu.map.RPGMap;
import Talk.conversation;
import fight.Battle;
import fight.attacks.Attack;
import fight.classes.ADMIN;
import fight.classes.Fighter;
import fight.classes.Player;

public class Game extends JApplet {
	public static int x = 0, y = -1, z = 0;
	public static Lolcation location;
	public static Object direction;
	public static Fighter player = new Player();
	public static Lolcation[] locations = { new Basic(), new L_1r_1(),
			new L_1r_2(), new L_1r_3(), new L_1r_4(), new L_1r0(), new L_1r1(),
			new L_1r2(), new L_2r_1(), new L_2r_2(), new L_2r_3(), new L_2r0(),
			new L_2r1(), new L0r_2(), new L0r_3(), new L0r_4(), new Castle(),
			new L0r2(), new L1r_3(), new L1r_4(), new L1r0(), new L1r1(),
			new L1r2(), new L2r_3(), new L2r_4(), new L2r1(), new Start(),
			new L_1r_1r_1(), new L_1r_2r_1(), new L_1r0r_1(), new L_2r_1r_1(),
			new L_2r0r_1(), new L0r_1r_1(), new L0r_2r_1(), new L0r_3r_1(),
			new L1r_2r_1(), new L1r_3r_1(), new L2r_2r_1(), new L2r_3r_1(),
			new L1r_1(), new L1r_2(), new L2r_1(),new L2r_2(),  new L2r0(),
			new L3r_1(), new L3r_2(), new L3r0(), new L4r_1(), new L4r_2(),
			new L4r0(), new L3r_3(), new L4r_3(), new L4r_4(), new L4r_5(),
			new L4r_6(), new L3r_4(), new L3r_5(), new L3r_6(), new L2r_5(),
			new L2r_6(), new CastleEntrance1(), new CastleEntrance2()  };
	public static Item[] items = { new ArmoryKey(), new LeatherArmor(),
			new BronzeSword(), new RebelMap(), new Back(), new SteelSword(),
			new BronzeArmor(), new RustyDagger(), new DungeonKey(), new StatuePiece() };
	public static int f = 1;
	public static boolean opening = false;
	public static Map<JApplet, JFrame> map = new HashMap<>();
	public static String description = "";

	public static Game game = new Game();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea t = new JTextArea("Welcome", 5, 30);

	private JComboBox<Object> c = new JComboBox<Object>();

	private JButton b = new JButton("Go");
	private JButton b0 = new JButton("Menu");
	private JButton b1 = new JButton("Map");

	public void init() {
		this.add(new RPGMap());
		for (Lolcation l : Game.locations) {
			if (l.x == Game.x && l.y == Game.y && l.z == Game.z) {
				Game.location = l;
				break;
			}
		}

		description = "";
		String[] words = ((String) location.description).split(" ");
		int numberOfChars = 0;

		for (String word : words) {
			if (word.length() >= 3 && word.substring(0, 1).equals("\n")) {
				description += word + " ";
				numberOfChars = 0;
			} else {
				numberOfChars += word.length();
				if (numberOfChars >= 44) {
					description += "\n" + word + " ";
					numberOfChars = 0;
				} else
					description += word + " ";
			}

		}

		t.setText((String) (location.area + ":\n" + description));
		for (Object item : location.options)
			c.addItem(item);
		t.setEditable(false);
		c.setEditable(false);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.menu();
			}
		});

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.map.get(Game.this).setEnabled(false);
				run(new RPGMap(), 500, 500);
			}
		});

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (direction == "North")
					y += 1;
				else if (direction == "South")
					y -= 1;
				else if (direction == "West")
					x -= 1;
				else if (direction == "East")
					x += 1;
				else if (direction == "Up")
					z += 1;
				else if (direction == "Down")
					z -= 1;
				else if (direction == "Fight!") {
					Battle.begin(location.heal, location.flee);
				} else if (direction == "Talk") {
					conversation.begin(location.heal);
				} else if (direction != null)
					location.after(opening);
				for (Lolcation l : locations) {
					if (l.x == x && l.y == y && l.z == z) {
						location = l;
						break;
					}
				}
				location.before();
				if (location.check == true) {
					if (location.heal == true) {
						player.hp = 100;
						for (Attack attack : Game.player.attacks)
							attack.down = 0;
					}
					location.explored = true;
					description = "";
					String[] words = ((String) location.description).split(" ");
					int numberOfChars = 0;

					for (String word : words) {
						if (word.length() >= 3
								&& word.substring(0, 1).equals("\n")) {
							description += word + " ";
							numberOfChars = 0;
						} else {
							numberOfChars += word.length();
							if (numberOfChars >= 44) {
								description += "\n" + word + " ";
								numberOfChars = 0;
							} else
								description += word + " ";
						}

					}

					if (player.name.equals("ADMIN")) {
						t.setText((String) (location.area + ": " + x + ", " + y
								+ "\n" + description));
					} else {
						t.setText((String) (location.area + ":\n" + description));
					}
					c.removeAllItems();
					for (Object o : location.options)
						c.addItem(o);
				} else {
					for (Lolcation l : locations) {
						if (l.x == x && l.y == y && l.z == z) {
							location = l;
							break;
						}
					}
					description = "";
					String[] words = ((String) location.description).split(" ");
					int numberOfChars = 0;

					for (String word : words) {
						if (word.length() >= 3
								&& word.substring(0, 1).equals("\n")) {
							description += word + " ";
							numberOfChars = 0;
						} else {
							numberOfChars += word.length();
							if (numberOfChars >= 44) {
								description += "\n" + word + " ";
								numberOfChars = 0;
							} else
								description += word + " ";
						}

					}

					if (player.name.equals("ADMIN")) {
						t.setText((String) (location.area + ": " + x + ", " + y
								+ "\n" + description));
					} else {
						t.setText((String) (location.area + ":\n" + description));
					}
					c.removeAllItems();
					for (Object o : location.options)
						c.addItem(o);

				}

			}
		});
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				direction = ((JComboBox<?>) e.getSource()).getSelectedItem();
			}
		});
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(t);
		cp.add(c);
		cp.add(b);
		cp.add(b0);
		cp.add(b1);
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"Welcome to Dethland. You will most likely not survive.",
				"Welcome", JOptionPane.PLAIN_MESSAGE);
		while (Game.player.name == null || Game.player.name.isEmpty()) {
			Game.player.name = JOptionPane.showInputDialog(null,
					"What is your name?", "Welcome", JOptionPane.PLAIN_MESSAGE);
			int i = JOptionPane.showConfirmDialog(null,
					"You said your name was " + Game.player.name + ", right?",
					"Welcome", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null);
			if (i != 0 || Game.player.name.isEmpty())
				Game.player.name = null;
			else if (!player.name.equals("ADMIN")) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(
							"./data/saveFiles.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						if (line.equals(Game.player.name)) {
							int y = JOptionPane.showConfirmDialog(null,
									"Continue saved game?", "Continue",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, null);
							if (y == 0) {
								Open.open();
								run(game, 350, 200);
								break;
							} else {
								run(new PlayerMaker(), 350, 200);
								break;
							}
						}
					}
					if (line == null)
						run(new PlayerMaker(), 350, 200);

					reader.close();
				} catch (Exception stupid) {
					stupid.printStackTrace();
				}
			} else {
				player = new ADMIN();
				AdminMaker.ADMiN();
				run(game, 350, 200);
			}
		}
	}

	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		frame.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width - frame
						.getWidth()) / 2, (Toolkit.getDefaultToolkit()
						.getScreenSize().height - frame.getHeight()) / 2);
		applet.init();
		applet.start();
		frame.setVisible(true);
		frame.setResizable(false);
		map.put(applet, frame);
	}
}
