package game.unit;

import java.awt.Toolkit;

import game.main.Animation;
import game.unit.Unit;

public class TestUnits {
	
	Unit warrior = new Unit();
	Unit archer = new Unit();
	Unit mage = new Unit();
	
	public TestUnits(){
		//Warrior Setup
		GraphicalData graphicalData = new GraphicalData();
//		warrior.getCombatStats().setHealth(100);
//		warrior.getCombatStats().setMana(0);
//		warrior.getCombatStats().setStrenght(30);
//		warrior.getCombatStats().setAgility(6);
//		warrior.getCombatStats().setIntelligence(2);
//		warrior.getCombatStats().setInitiative(8);
//		warrior.getCombatStats().setMovementpoints(5);
//		warrior.getCombatStats().setDefense(50);
		warrior.setType("Warrior");
		Animation a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/warrior3.png"), 250);
		warrior.setGraphicalData(graphicalData);
		warrior.getGraphicalData().setBattleFieldStandLeft(a);
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/warrior2.png"), 250);
		warrior.getGraphicalData().setBattleFieldStandRight(a);
		warrior.setIcon(Toolkit.getDefaultToolkit().getImage("Images/units/human/swordsman/swordsman_icon.jpg"));
		//Archer Setup
		graphicalData = new GraphicalData();
//		archer.getCombatStats().setHealth(50);
//		archer.getCombatStats().setMana(0);
//		archer.getCombatStats().setStrenght(6);
//		archer.getCombatStats().setAgility(27);
//		archer.getCombatStats().setIntelligence(3);
//		archer.getCombatStats().setInitiative(10);
//		archer.getCombatStats().setMovementpoints(4);
//		archer.getCombatStats().setDefense(25);
		archer.setType("Archer");
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/archer3.png"), 250);
		archer.setGraphicalData(graphicalData);
		archer.getGraphicalData().setBattleFieldStandLeft(a);
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/archer2.png"), 250);
		archer.getGraphicalData().setBattleFieldStandRight(a);
		archer.setIcon(Toolkit.getDefaultToolkit().getImage("Images/units/human/archer/archer_icon.jpg"));
		//Mage Setup
		graphicalData = new GraphicalData();
//		mage.getCombatStats().setHealth(40);
//		mage.getCombatStats().setMana(20);
//		mage.getCombatStats().setStrenght(3);
//		mage.getCombatStats().setAgility(3);
//		mage.getCombatStats().setIntelligence(30);
//		mage.getCombatStats().setInitiative(6);
//		mage.getCombatStats().setMovementpoints(4);
//		mage.getCombatStats().setDefense(10);
		mage.setType("Mage");
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/mage3.png"), 250);
		mage.setGraphicalData(graphicalData);
		mage.getGraphicalData().setBattleFieldStandLeft(a);
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/mage2.png"), 250);
		mage.getGraphicalData().setBattleFieldStandRight(a);
		mage.setIcon(Toolkit.getDefaultToolkit().getImage("Images/units/human/mage/mage_icon.jpg"));
	}
	
	public Unit getWarrior(){
		return warrior;
	}
	public Unit getArcher(){
		return archer;
	}
	public Unit getMage(){
		return mage;
	}
	
}

