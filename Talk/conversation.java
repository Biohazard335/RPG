package Talk;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import locations.Game;
import Talk.talkers.Talker;

public class conversation {

	public static void begin(boolean heal) {
		if (Game.location.talkers.length != 0)
			if (Game.location.talkers.length == 1)
				conversation.go(Game.location.talkers[0], heal);
			else {
				Talker tlk = null;
				ArrayList<String> talkers = new ArrayList<String>();
				for (Talker t : Game.location.talkers) {
					talkers.add(t.name);
				}
				String[] talk = talkers.toArray(new String[talkers.size()]);
				String tchoice = (String) JOptionPane.showInputDialog(null,
						"Talk to who?", "Talk", JOptionPane.PLAIN_MESSAGE,
						null, talk, talk[0]);
				if (tchoice != null) {
					for (Talker t : Game.location.talkers)
						if (t.name.equals(tchoice))
							tlk = t;
					conversation.go(tlk, heal);
				}
			}

	}

	public static void go(Talker speaker, boolean heal) {
		// convert ArrayLists to Arrays
		String[] prompts = speaker.prompts.toArray(new String[speaker.prompts
				.size()]);
		String[] allResponses = speaker.responses
				.toArray(new String[speaker.responses.size()]);
		String[] numberOfResponses = speaker.responseNumbers
				.toArray(new String[speaker.responseNumbers.size()]);
		String[] actionPrompts = speaker.actionPrompts
				.toArray(new String[speaker.actionPrompts.size()]);

		// Which prompt we are on
		int x = 0;

		// How many prompts we need to skip next time.
		int w = 0;

		// Which response we start on
		int k = 0;

		// Which response is chosen
		Object choice = null;

		// The literal prompt
		String prompt = "";
		do {
			prompt = prompts[x];
			// Create and populate new ArrayList of responses
			ArrayList<String> availibleResponses = new ArrayList<String>();
			for (int i = 0; i < Integer.parseInt(numberOfResponses[x]); i++) {
				availibleResponses.add(allResponses[k + i]);
			}

			// convert new ArrayList to Array
			Object[] availibleResponses1 = availibleResponses
					.toArray(new Object[availibleResponses.size()]);

			// Check to see if there are responses
			if (availibleResponses1.length == 0) {

				// no responses = message & break
				JOptionPane.showMessageDialog(null, speaker.name + ": \""
						+ prompt + "\"", "Talk", JOptionPane.PLAIN_MESSAGE);
				break;
			} else {

				// responses = drop down box
				choice = JOptionPane.showInputDialog(null, speaker.name
						+ ": \"" + prompt + "\"", "Talk",
						JOptionPane.PLAIN_MESSAGE, null, availibleResponses1,
						availibleResponses1[0]);

				// set new response to start on
				for (int z = 0; z < availibleResponses1.length; z++) {
					if (choice == availibleResponses1[z])
						break;
					else {
						k += Integer.parseInt(numberOfResponses[x + z + 1 + w]);
					}
				}
				k += Integer.parseInt(numberOfResponses[x]);

				// set new prompt
				w = 0;
				for (int p = 0; p < availibleResponses1.length; p++) {
					if (choice == availibleResponses1[p])
						break;
					else
						w += Integer.parseInt(numberOfResponses[x + p + 1 + w]);
				}
				for (int i = 0; i < allResponses.length; i++) {
					if (choice == allResponses[i])
						x = i + 1;
				}
			}
		} while (true);
		for (int i = 0; i < actionPrompts.length; i++)
			if (prompt.equals(actionPrompts[i]))
				speaker.actions(i, speaker);
	}
}
