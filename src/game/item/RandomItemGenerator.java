package game.item;

import game.main.MainClass;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

public class RandomItemGenerator {
	private Item randomItem;
	private MainClass mc;

	public RandomItemGenerator(MainClass mc) {
		this.mc = mc;
		randomItem = new Item(null, null);
		Random random = new Random();
		ArrayList<String> bonuses = new ArrayList<String>();
		
		
		for(int j=0;j<2;j++){
			int i = random.nextInt(6);
			
			switch (i){
			
			case 0 : bonuses.add("strenght"); break;
			case 1 : bonuses.add("constitution"); break;
			case 2 : bonuses.add("dexterity"); break;
			case 3 : bonuses.add("intelligence"); break;
			case 4 : bonuses.add("wisdom"); break;
			case 5 : bonuses.add("charisma"); break;
			default : bonuses.add("strenght"); break;
		
			}
		}
		
		int i = random.nextInt(10);
		int j = random.nextInt(2);
		
		String name1 = "";
		
		switch (i){
		
		case 0 : randomItem.setType("head"); name1 = "Helm"; break;
		case 1 : randomItem.setType("legs"); name1 = "Leggings"; break;
		case 2 : randomItem.setType("feet"); name1 = "Boots"; break;
		case 3 : randomItem.setType("leftHand"); name1 = "Shield"; break;
		case 4 : randomItem.setType("rightHand"); name1 = "Sword"; break;
		case 5 : randomItem.setType("neck"); name1 = "Necklace"; break;
		case 6 : randomItem.setType("gloves"); name1 = "Gloves"; break;
		case 7 : randomItem.setType("bracers"); name1 = "Bracers"; break;
		case 8 : randomItem.setType("ring"); name1 = "Ring"; break;
		case 9 : randomItem.setType("armor"); name1 = "Armor"; break;
		default : randomItem.setType("head"); name1 = "Helm"; break;

		}
		
		randomItem.setImage(Toolkit.getDefaultToolkit().getImage("Images/items/" + randomItem.getType()+"_"+j+".jpg"));
		
		i = random.nextInt(4);
		
		switch (i){
		case 0 : randomItem.setCost(2000);
		case 1 : randomItem.setCost(3000);
		case 2 : randomItem.setCost(2500);
		case 3 : randomItem.setCost(1750);
		}
		
		String name2 = "";
		
		i = random.nextInt(10);
		
		switch(i){
		
		case 0 : name2 = "Air"; break;
		case 1 : name2 = "Wind"; break;
		case 2 : name2 = "Sun"; break;
		case 3 : name2 = "Rain"; break;
		case 4 : name2 = "Storm"; break;
		case 5 : name2 = "Thunder"; break;
		case 6 : name2 = "Darkness"; break;
		case 7 : name2 = "Light"; break;
		case 8 : name2 = "Masters"; break;
		case 9 : name2 = "Warding"; break;
		
		
		}
		
		String name = name1 + " of " + name2;
		
		randomItem.setName(name);
		randomItem.setBonuses(bonuses);
		
	}
	
	public Item getItem(){
		return randomItem;
	}

	public Item getRandomItem() {
		Item i = new RandomItemGenerator(mc).getItem();
		return i;
	}
}
