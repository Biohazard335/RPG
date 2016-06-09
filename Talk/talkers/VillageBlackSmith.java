package Talk.talkers;

public class VillageBlackSmith extends Talker {

	public VillageBlackSmith() {
		super("Black Smith",
		// prompts
				new String[] { "Sorry, shop's closed." },
				// number of answers for the corresponding prompt
				new String[] { "0" },
				// answers
				new String[] {},
				// prompts that activate an action
				new String[] {});
	}
}
