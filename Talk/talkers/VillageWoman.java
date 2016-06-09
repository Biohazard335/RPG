package Talk.talkers;

public class VillageWoman extends Talker {

	public VillageWoman() {
		super(
				"Woman",
				// prompts
				new String[] { "You can't be here!",
						"The Emperor's Wizard will surely smite us all!",
						"You are a brave one. The brave ones don't last here.",
						"You must leave!",
						"The Wizard will kill you,\nlike he does all of the other rebels." },
				// number of answers for the corresponding prompt
				new String[] { "2", "1", "1", "0", "0" },
				// answers
				new String[] { "Why not?", "I can be wherever I want.",
						"Wizard?", "Wait, what?" },
				// prompts that activate an action
				new String[] {});
	}
}
