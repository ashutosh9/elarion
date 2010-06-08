package game.unit;

import java.awt.Toolkit;
import java.util.Random;

import game.main.MainClass;

public class RandomUnitGenerator {
	private Unit randomUnit;
	private MainClass mc;
	
	public RandomUnitGenerator(MainClass mc) {
		this.mc = mc;
		randomUnit = new Unit();
		
		String name = "";
		
		Random random = new Random();
		
		int i = random.nextInt(5);
		
		if(i == 0 ){
			name = new String("Unit1");
		}
		if(i == 1 ){
			name = new String("Unit2");
		}
		if(i == 2 ){
			name = new String("Unit3");
		}
		if(i == 3 ){
			name = new String("Unit3");
		}
		if(i == 4 ){
			name = new String("Unit4");
		}
		
		randomUnit.setName(name);
		
		i = random.nextInt(3);
		
		if(i == 0 ){
			randomUnit.getCombatStats().setStrenght(16);
			randomUnit.getCombatStats().setConstitution(14);
			randomUnit.getCombatStats().setDexterity(12);
			randomUnit.setType("warrior");
			randomUnit.setIcon(Toolkit.getDefaultToolkit().getImage("Images/units/human/swordsman/swordsman_icon.jpg"));
		}
		if(i == 1 ){
			randomUnit.getCombatStats().setDexterity(16);
			randomUnit.getCombatStats().setIntelligence(14);
			randomUnit.getCombatStats().setConstitution(12);
			randomUnit.setType("archer");
			randomUnit.setIcon(Toolkit.getDefaultToolkit().getImage("Images/units/human/archer/archer_icon"));
		}
		if(i == 2 ){
			randomUnit.getCombatStats().setIntelligence(16);
			randomUnit.getCombatStats().setWisdom(14);
			randomUnit.getCombatStats().setDexterity(12);
			randomUnit.setType("mage");
			randomUnit.setIcon(Toolkit.getDefaultToolkit().getImage("Images/units/human/mage/mage_icon"));
		}
	}
	
}
