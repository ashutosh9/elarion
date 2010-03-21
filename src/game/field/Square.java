package game.field;

import game.Interface.Tooltip;
import game.building.Building;
import game.building.BuildingEvent;
import game.item.Item;
import game.unit.Hero;

import java.awt.Image;
import java.awt.Toolkit;

public class Square {
	private int x;
	private int y;
	private boolean passable;
	private Building building;
	private Hero hero;
	private Terrain terrain;
	private Tooltip tooltip;
	private Item collectibleItem;
	
	
	public Square(int x, int y){
		this.x = x;
		this.y = y;
		setHero(null);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean isPassable(){
		return passable;
	}
	
	public Tooltip getTooltip(){
		return tooltip;
	}
	
	public void setTooltip(String s){
		tooltip.setTooltip(s);
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setPassable(boolean passable){
		this.passable = passable;
	}
	
	public void setTerrain(Terrain t){
		terrain = t;
	}

	public Terrain getTerrain(){
		return terrain;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Hero getHero() {
		return hero;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Building getBuilding() {
		return building;
	}
	
	public Image getImage(){
		return terrain.getImg();
	}
	
	public Image getBuildingImage(){
		return building.getImage();
	}

	public void setCollectibleItem(Item collectibleItem) {
		this.collectibleItem = collectibleItem;
	}

	public Item getCollectibleItem() {
		return collectibleItem;
	}

}
