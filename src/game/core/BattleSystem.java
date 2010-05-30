package game.core;

import game.unit.Hero;
import game.unit.Unit;

import java.util.ArrayList;


public class BattleSystem{
	
	ArrayList<Unit> units = new ArrayList<Unit>();
	
	public BattleSystem(Hero attacker , Hero defender){
		for(Unit u : attacker.getUnits()){
			units.add(u);
		}
		for(Unit u : defender.getUnits()){
			units.add(u);
		}
		
		int i = 1;
		
		for(Unit u : units){
			u.setInTurn(false);
			if(u.getCurrIn() > units.get(i).getCurrIn()){
			 i = units.indexOf(u);
			}
			
		}
		units.get(i).setInTurn(true);	
		
				
		}
		
	public ArrayList<Unit> getUnits(){
		return units;
	}
}
	

