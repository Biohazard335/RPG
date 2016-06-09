package Talk.talkers;

public class T1r0 extends Talker {

	public T1r0() {
		super(
				"Man",
				// prompts
				new String[] {
						"Who are you?"/* 1 */,
						"What do you want?"/* 2 */,
						"That was rude."/* 3 */,
						"I'm just a simple soldier."/* 4 */,
						"My sword? Sorry, but I need it more."/* 5 */,
						"No, go away."/* 6 */,
						"Don't you know? The Imperial Guard are hunting all us rebels."/* 7 */,
						"No, go away."/* 8 */,
						"Ever since the revolution, they've been trying to \"keep order\""/* 9 */,
						"Ugh, what an idiot. Why don't you go bother\nsomone else, I'm waiting for somone."/* 10 */},
				// number of answers for the corresponding prompt
				new String[] { "2", "2", "1", "0", "2", "0", "1", "0", "1", "0" },
				// answers
				new String[] { "I am a traveler.",/* 1a-2 */
				"None of your business"/* 1b-3 */,
						"I want to know who you are.",/* 2a -4 */
						"I need your sword."/* 2b-5 */,
						"I don't care, give me your sword."/* 3a-7 */,
						"Why is that?"/* 5a-7 */,
						"Give it to me anyway!"/* 5b-8 */,
						"Hunting you? But why?"/* 7-9 */, "Revolution?"/* 9-10 */},
				// prompts that activate an action
				new String[] { "Ugh, what an idiot. Why don't you go bother\nsomone else, I'm waiting for somone." });
	}
}
