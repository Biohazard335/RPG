package Talk.talkers;

public class TWizard extends Talker {

	public TWizard() {
		super(
				"Wizard",
				// prompts
				new String[] {
						"Welcome.","Hah. You'll meet your end swiftly.","I am your end, \"Hero\"." },
				// number of answers for the corresponding prompt
				new String[] { "2" },
				// answers
				new String[] { "You've oppressed those poeple for too long!\nI'm going to end you!",
						"Who are you?" },
				// prompts that activate an action
				new String[] {"I am your end, \"Hero\".","Hah. You'll meet your end swiftly." });
	}
}
