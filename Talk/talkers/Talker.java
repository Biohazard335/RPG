package Talk.talkers;

import java.util.ArrayList;

import locations.Game;
import fight.Battle;

public class Talker {
	public ArrayList<String> prompts = new ArrayList<String>();
	public ArrayList<String> responses = new ArrayList<String>();
	public ArrayList<String> responseNumbers = new ArrayList<String>();
	public ArrayList<String> actionPrompts = new ArrayList<String>();
	public String name;

	public Talker(String name, String[] prompts, String[] responseNumbers,
			String[] responses, String[] actionPrompts) {
		this.name = name;
		for (String prompt : prompts)
			this.prompts.add(prompt);
		for (String response : responses)
			this.responses.add(response);
		for (String number : responseNumbers)
			this.responseNumbers.add(number);
		for (String actionp : actionPrompts)
			this.actionPrompts.add(actionp);
	}

	public void actions(int i, Talker speaker) {
		if (i == 0)
			allowFight();
		else if (i == 1)
			causeFight(speaker);

	}

	public void allowFight() {
		Game.location.addOptions("Fight!");
	}

	public void causeFight(Talker speaker) {
		for (int i = 0; i < Game.location.talkers.length; i++)
			if (Game.location.talkers[i].name == speaker.name)
				Battle.battle(Game.location.fighters[i], Game.location.heal,
						Game.location.flee);

	}
}
