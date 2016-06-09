package Talk.talkers;

public class T_1r_1 extends Talker {

	public T_1r_1() {
		super("Troll",
		// prompts
				new String[] { "What?", "Nothing. Scram.",
						"Heh, heh, you're funny kid. Get lost.",
						"Yeah, that's what I thought.",
						"Time for some fun then." },
				// number of answers for the corresponding prompt
				new String[] { "2", "0", "2", "0", "0" },
				// answers
				new String[] { "What are you guarding?", "Out of my way.",
						"Fine.", "No!" },
				// prompts that activate an action
				new String[] { "", "Time for some fun then." });
	}
}
