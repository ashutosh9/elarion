package game.battle;

import game.field.Terrain;
import game.unit.Unit;

public class BattleTile {

	private int x;
	private int y;
	private boolean passable;
	private Unit unit;
	private Terrain terrain;
	
	BattleTile(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public void setPassable(boolean passable) {
		this.passable = passable;
	}
	public boolean isPassable() {
		return passable;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Unit getUnit() {
		return unit;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}


	public Terrain getTerrain() {
		return terrain;
	}
	
}
