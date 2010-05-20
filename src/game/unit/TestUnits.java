package game.unit;

import java.awt.Toolkit;

import game.main.Animation;
import game.unit.Unit;

public class TestUnits {
	
	Unit warrior = new Unit();
	Unit archer = new Unit();
	Unit mage = new Unit();
	
	public TestUnits(){
		GraphicalData graphicalData = new GraphicalData();
		warrior.getCombatStats().setHealth(100);
		warrior.getCombatStats().setStrenght(10);
		warrior.getCombatStats().setInitiative(8);
		warrior.getCombatStats().setMovementpoints(5);
		warrior.setType("Warrior");
		Animation a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/warrior2.png"), 250);
		warrior.setGraphicalData(graphicalData);
		warrior.getGraphicalData().setBattleFieldStandLeft(a);
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/warrior3.png"), 250);
		warrior.getGraphicalData().setBattleFieldStandRight(a);
		graphicalData = new GraphicalData();
		archer.getCombatStats().setHealth(50);
		archer.getCombatStats().setStrenght(2);
		archer.getCombatStats().setInitiative(10);
		archer.getCombatStats().setMovementpoints(4);
		archer.setType("Archer");
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/archer2.png"), 250);
		archer.setGraphicalData(graphicalData);
		archer.getGraphicalData().setBattleFieldStandLeft(a);
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/archer3.png"), 250);
		archer.getGraphicalData().setBattleFieldStandRight(a);
		graphicalData = new GraphicalData();
		mage.getCombatStats().setHealth(40);
		mage.getCombatStats().setStrenght(1);
		mage.getCombatStats().setInitiative(6);
		mage.getCombatStats().setMovementpoints(4);
		mage.setType("Mage");
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/mage2.png"), 250);
		mage.setGraphicalData(graphicalData);
		mage.getGraphicalData().setBattleFieldStandLeft(a);
		a = new Animation();
		a.addScene(Toolkit.getDefaultToolkit().getImage("Images/battlefield/mage3.png"), 250);
		mage.getGraphicalData().setBattleFieldStandRight(a);
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

