package Talk.talkers;

public class T2r_3 extends Talker {

	public T2r_3() {
		super(
				"Imperial Guard",
				// prompts
				new String[] {
						"You cannot pass through here.",
						"You're wearing rebel armor,\nI should kill you right now.",
						"That's not going to happen.", "Armory? Where?",
						"Just keep pushing me, kid.",
						"Thank you for your contributions to the Empire.",
						"Nice try, but no." },
				// number of answers for the corresponding prompt
				new String[] { "2", "2", "0", "1", "0", "1", "0" },
				// answers
				new String[] { "Why not?", "Get out of my way.",
						"No, wait! I took this from some armory!",
						"I'd like to see you try!",
						"It's in a cave just down the valley.",
						"Can I pass now?" },
				// prompts that activate an action
				new String[] { "Nice try, but no." });
	}
}
