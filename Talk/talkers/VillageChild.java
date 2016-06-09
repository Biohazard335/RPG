package Talk.talkers;

import locations.Game;

public class VillageChild extends Talker {

	public VillageChild() {
		super(
				"Child",
				// prompts
				new String[] {
						"Have you come to save us?",
						"The evil Wizard.",
						"He hurts us if we don't do what the Emperor tells us to.",
						"So you'll stop him?",
						"He lives up on the mountian. The only way to\nget to him is through the dungeon.",
						"That's okay, I'm sure we'll be fine...",
						"They say it's on the Mountain trail, to\nthe North, just West of the statue.",
						"Here, I stole the key. Good luck." },
				// number of answers for the corresponding prompt
				new String[] { "1", "1", "1", "2", "1", "0", "1", "0" },
				// answers
				new String[] { "Save you from what?", "Who is this Wizard?",
						"How horrible!", "Consider it done. Where is he?",
						"No.", "Where is this dungeon?", "How do I get in?" },
				// prompts that activate an action
				new String[] { "Here, I stole the key. Good luck." });
	}

	@Override
	public void actions(int i, Talker speaker) {
		Game.items[8].has = true;
	}
}
