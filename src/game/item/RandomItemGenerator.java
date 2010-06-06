package game.item;

public class RandomItemGenerator {
	private Item randomItem;

	public RandomItemGenerator() {
		randomItem = new Item("ring",null);
	}

	public Item getRandomItem() {
		return randomItem;
	}
}
