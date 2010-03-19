package game.field;

import game.building.Building;
import game.building.BuildingEvent;
import game.unit.Hero;

import java.awt.Image;
import java.awt.Toolkit;

public class Square {
	private int x;
	private int y;
	private boolean passable;
	private Image img;
	private BuildingEvent event;
	private boolean isWater;
	private boolean containsCollectible;
	private Building building;
	private Hero hero;
	//private Tooltip tooltip;
	
	
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
	
	public boolean getPassable(){
		return passable;
	}
	
	public Image getImage(){
		return img;
	}
	
	public void setIsWater(boolean b){
		isWater = b;
	}
	
	public boolean isWater(){
		return isWater;
	}
	
	public BuildingEvent getSquareEvent(){
		return event;
	}
	
	//public Tooltip getTooltip(){
	//	return Tooltip;
	//}
	
	public Image getBuildingImage(){
		return building.getImage();
	}
	
	public void setSquareEvent(BuildingEvent e){
		event = e;
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
	
	public void setTerrainImage(){
		img = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg");
		// different images for different types
	}
	
	public void setBuildingImage(Image img){
		building.setImage(img); 
		//Toolkit.getDefaultToolkit().getImage("");
		// different types for now
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Hero getHero() {
		return hero;
	}
	
	// set visibility for every player

}
