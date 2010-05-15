package game.field;

import game.Interface.Tooltip;
import game.building.Building;
import game.item.Item;
import game.resource.Resource;
import game.unit.Hero;

import java.awt.Image;

public class Square {
	private int x;
	private int y;
	private boolean passable;
	private Building building;
	private Hero hero;
	private Terrain terrain;
	private Tooltip tooltip;
	private Item item;
	private Resource resource;
	
	
	public Square(int x, int y){
		//set tooltip to terrain tooltip
		this.x = x;
		this.y = y;
		setResource(null);
		setHero(null);
		setItem(null);
		tooltip = new Tooltip("");
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
		//set tooltip to building tooltip
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

	public void setItem(Item collectibleItem) {
		//set tooltip to collectible tooltip 
		this.item = collectibleItem;
	}

	public Item getItem() {
		return item;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Resource getResource() {
		return resource;
	}

}
