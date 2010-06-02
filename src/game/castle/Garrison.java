package game.castle;

import game.unit.Unit;

import java.util.ArrayList;

public class Garrison {
	private ArrayList<Unit> units;
	private Castle owner;
	
	public Garrison(Castle owner) {
		units = new ArrayList<Unit>(8);
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
