package items;

public class Item {
	public boolean has = false;
	public boolean equipped = false;
	public boolean equippable = false;
	public String type = "item";

	public Item(boolean equippable, String type) {
		this.equippable = equippable;
		this.type = type;
	}

	public void equip() {

	}

	public void unequip() {

	}
}
