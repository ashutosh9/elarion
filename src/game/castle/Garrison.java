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
	public int getAmount() {
		int amount = 0;
		for (int i=0; i<8; i++) {
			if (units.get(i) != null) {
				amount++;
			}
		}
		return amount;
	}
	
	public ArrayList<Unit> getUnits(){
		return units;
	}
	
	public void clear() {
		for (int i=0;i<8;i++) {
			units.set(i,null);
		}
	}
	
	public boolean isEmpty() {
		return units.isEmpty();
	}
}
