package game.unit;

import game.unit.Hero;
import game.unit.Unit;

public class TestUnits {
	
	Unit warrior = new Unit();
	Unit archer = new Unit();
	Unit mage = new Unit();
	
	public TestUnits(){
		warrior.getCombatStats().setHealth(100);
		warrior.getCombatStats().setStrenght(10);
		warrior.setType("Warrior");
		archer.getCombatStats().setHealth(50);
		archer.getCombatStats().setStrenght(2);
		archer.setType("Archer");
		mage.getCombatStats().setHealth(40);
		mage.getCombatStats().setStrenght(1);
		mage.setType("Mage");
	}
	
}




	//Unit testUnit = new Unit();
	//testUnit.getCombatStats().setHealth(40);