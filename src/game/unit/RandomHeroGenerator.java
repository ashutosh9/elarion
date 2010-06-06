package game.unit;

import java.awt.Toolkit;

import game.main.MainClass;

public class RandomHeroGenerator {
	private Hero qkoRandom;

	public RandomHeroGenerator(MainClass mc) {
		qkoRandom = new Hero(mc);
		qkoRandom.setName("Normal Guy");
		qkoRandom.setDescription("A regular everyday normal guy");
		qkoRandom.setIcon(Toolkit.getDefaultToolkit().getImage("Images/heroes/human/RENG.jpg"));
	}
	
	public Hero getRandomHero() {
		return qkoRandom;
	}
}
