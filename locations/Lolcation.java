package locations;

import java.util.ArrayList;
import java.util.List;

import Talk.talkers.Talker;
import fight.classes.Fighter;

public class Lolcation {
	public int x = 0, y = 0, z = 0, afterMath = -1;
	public boolean check = true, done = false, heal = true, flee = true,
			explored = false;
	public Object area = "forest",
			description = "You are in the middle of a dark forest";
	public List<Object> optionAdd = new ArrayList<>();
	public Object[] options = { "north", "south", "east", "west" };
	public Talker[] talkers = {};
	public Fighter[] fighters = {};

	public Lolcation(int x, int y, int z, String area, String description,
			Object[] options, Fighter[] fighters, Talker[] talkers) {
		this.area = area;
		this.description = description;
		this.options = options;
		this.x = x;
		this.y = y;
		this.z = z;
		this.fighters = fighters;
		this.talkers = talkers;
	}

	public void afterMath(int chosen) {
	}

	public void after(boolean open) {
	}

	public void before() {
	}

	public void addOptions(Object obj) {
		optionAdd = new ArrayList<Object>();
		for (Object object : options)
			if (object != obj)
				optionAdd.add(object);
		optionAdd.add(obj);
		options = optionAdd.toArray(new Object[optionAdd.size()]);

	}
}
