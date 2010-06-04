package game.castle;

import game.unit.Unit;

import java.util.ArrayList;

public class Garrison {
	static ArrayList<Unit> units;
	private Castle owner;
	
	public Garrison(Castle owner) {
//<<<<<<< local
//		units = new ArrayList<Unit>();
//		for(int i=0;i<8;i++){
//=======
		units = new ArrayList<Unit>(8);
		for (int i=0;i<8;i++) {
//>>>>>>> other
			units.add(i,null);
		}
		this.owner = owner;
	}
	
	public void removeUnit(int i) {
			units.remove(i);
	}
	public void addUnit(Unit u) {
		units.add(u);
	}
	public Unit getUnit(int i) {
		return units.get(i);
	}
	public int getSize() {
		return units.size();
	}
	
	public ArrayList<Unit> getUnits(){
		return units;
	}
	
	public boolean isEmpty() {
		return units.isEmpty();
	}
}
