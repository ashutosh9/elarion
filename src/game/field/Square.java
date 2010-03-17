package game.field;

import game.building.Event;

import java.awt.Image;
import java.awt.Toolkit;

public class Square {
	private int x;
	private int y;
	private boolean passable;
	private Image img;
	private Image buildingImg;
	private Event event;
	private boolean isWater;
	private boolean isOccupied;
	//private Type type;
	//private Tooltip tooltip;
	
	
	public Square(int x, int y){
		this.x = x;
		this.y = y;
		isOccupied = false;
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
	
	public Event getSquareEvent(){
		return event;
	}
	
	public void setOccupied(boolean b){
		isOccupied = b;
	}
	
	public boolean getOccupied(){
		return isOccupied;
	}
	
	//public Tooltip getTooltip(){
	//	return Tooltip;
	//}
	
	//public Type getType(){
	//	return type;
	//}
	
	public Image getBuildingImage(){
		return buildingImg;
	}
	
	public void setSquareEvent(Event e){
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
		buildingImg = img; 
		//Toolkit.getDefaultToolkit().getImage("");
		// different types for now
	}
	
	// set visibility for every player

}
