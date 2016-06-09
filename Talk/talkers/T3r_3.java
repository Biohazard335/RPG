package Talk.talkers;

public class T3r_3 extends Talker {

	public T3r_3() {
		super("Guard",
		// prompts
				new String[] { "You shouldn't be here... leave or I'll have to make you." },
				// number of answers for the corresponding prompt
				new String[] { "0" },
				// answers
				new String[] { },
				// prompts that activate an action
				new String[] { });
	}
}
