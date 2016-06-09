package menu;

import java.util.ArrayList;

import locations.Game;
import fight.attacks.Attack;
import fight.attacks.Kick;
import fight.attacks.Punch;
import fight.attacks.Strike;
import fight.attacks.Stun;

public class typeAffect {
	public void Knight() {
		Game.player.attacks = new ArrayList<Attack>();
		Game.player.attacks.add(new Punch());
		Game.player.attacks.add(new Kick());
		Game.player.str = 5;
		Game.player.def = 5;
		Game.player.spd = 2;
		Game.player.acc = 3;
		Game.player.type = "Knight";
		for (Attack attack : Game.player.attacks)
			PlayerMaker.attacks += attack.getClass().getSimpleName() + ", ";
		PlayerMaker.attacks += "\nWith sword: Impale";
	}

	public void Assassin() {
		Game.player.attacks = new ArrayList<Attack>();
		Game.player.attacks.add(new Punch());
		Game.player.attacks.add(new Kick());
		Game.player.str = 3;
		Game.player.def = 3;
		Game.player.spd = 5;
		Game.player.acc = 5;
		Game.player.type = "Assassin";
		Game.player.attacks.add(new Strike());
		Game.player.attacks.add(new Stun());
		for (Attack attack : Game.player.attacks)
			PlayerMaker.attacks += attack.getClass().getSimpleName() + ", ";

	}

	public void Slayer() {
		Game.player.attacks = new ArrayList<Attack>();
		Game.player.attacks.add(new Punch());
		Game.player.attacks.add(new Kick());
		Game.player.str = 7;
		Game.player.def = 3;
		Game.player.spd = 3;
		Game.player.acc = 3;
		Game.player.type = "Slayer";
		for (Attack attack : Game.player.attacks)
			PlayerMaker.attacks += attack.getClass().getSimpleName() + ", ";

	}

}
