package fight.classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import locations.Game;

import fight.attacks.Attack;

public class Fighter {
	public int hp = 100, str, def, spd, acc;
	public String name, type = "";
	public ArrayList<Attack> attacks = new ArrayList<Attack>();
	public double xp = 0;
	public int level = 1;
	public boolean flee = true;

	public Fighter(int str, int def, int spd, int acc, Attack[] attacks,
			String name) {
		this.str = str;
		this.def = def;
		this.spd = spd;
		this.acc = acc;
		this.name = name;
		for (Attack attack : attacks)
			this.attacks.add(attack);
	}

	public Attack chooseAttack(ArrayList<Attack> attacks) {
		int choice, var = 0, var1 = 0;
		Attack atk = null;
		for (int x = 0; x < attacks.size(); x += 1) {
			if (attacks.get(x).down == 0) {
				var += attacks.get(x).prb;
			}
		}
		choice = (int) (Math.random() * var);
		for (int x = 0; x < attacks.size(); x += 1) {
			if (attacks.get(x).down == 0) {
				if (choice >= var1 && choice < var1 + attacks.get(x).prb) {
					atk = attacks.get(x);
					break;
				}
				var1 += attacks.get(x).prb;
			}
		}
		return atk;
	}

	public String stats() {
		return "{Str: " + this.str + ", Def: " + this.def + ", Acc " + this.acc
				+ ", Spd: " + this.spd + "}";
	}

	public int levelCalculator(double xp) {
		return (int) Math.sqrt((xp / 20)) + 1;
	}

	public void levelUp() {
		Object[] stats = { "Str", "Def", "Spd", "Acc" };
		Game.player.str += 1;
		Game.player.def += 1;
		Game.player.spd += 1;
		Game.player.acc += 1;
		String stat;
		do
			stat = (String) JOptionPane.showInputDialog(null,
					"You are now Level " + Game.player.level + "\nStr + 1 :"
							+ Game.player.str + "\nDef + 1 :" + Game.player.def
							+ "\nSpd + 1 :" + Game.player.spd + "\nAcc + 1 :"
							+ Game.player.acc + "\n\nChoose 1 to increase:"
							+ levelUnlock(Game.player.level), "Level Up",
					JOptionPane.PLAIN_MESSAGE, null, stats, stats[0]);
		while (stat == null);
		if (stat.equals("Str"))
			Game.player.str += 1;
		else if (stat.equals("Def"))
			Game.player.def += 1;
		else if (stat.equals("Spd"))
			Game.player.spd += 1;
		else if (stat.equals("Acc"))
			Game.player.acc += 1;
	}

	public String levelUnlock(int level) {
		String retrn = "";
		return retrn;
	}

	public void cpuLevel(int x) {
		this.str += x - 1;
		this.def += x - 1;
		this.spd += x - 1;
		this.acc += x - 1;
		for (int i = 0; i < x; i++) {
			int p = (int) (Math.random() * 4) + 1;
			if (p == 1)
				this.str++;
			else if (p == 2)
				this.def++;
			else if (p == 3)
				this.spd++;
			else if (p == 4)
				this.acc++;
		}
	}
}
