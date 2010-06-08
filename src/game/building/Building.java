package game.building;

import java.awt.Image;

import game.field.Field;
import game.field.Square;
import game.main.MainClass;
import game.player.Player;

@SuppressWarnings("unused")
public class Building {
	private int x; 
	private int y; 
	private Player owner;
	private Square currentSquare;
	private Image icon;
	private Image currentSprite;
	private MainClass mc;
	private Field field;
	
	public Building(int x, int y,Field f, MainClass mc) {
		this.mc = mc;
		this.x = x;
		this.y = y;
		this.field = field;
		currentSquare = field.getSquare(x, y);
		field.getSquare(x,y).setBuilding(this);
		field.getSquare(x+1,y).setBuilding(this);
		field.getSquare(x,y-1).setBuilding(this);
		field.getSquare(x+1,y-1).setBuilding(this);
		field.getSquare(x+1,y).setPassable(false);
		field.getSquare(x,y-1).setPassable(false);
		field.getSquare(x+1,y-1).setPassable(false);
	}

	public Image getIcon() {
		return icon;
	}
	
	public void setIcon(Image img){
		icon = img;
	}
	
	public Image getImage() {
		return currentSprite;
	}
	
	public void setImage(Image img) {
		currentSprite = img;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player p) {
		owner = p;
	}
	
	public void turnUpdate(int turn) {
		
	}
	/*
	public BuildingEvent getEvent() {
		return null;
	}

	public Gather getGather() {

		return null;
	}

	public Square[] getOccupiedSquares() {

		return null;
	}

	public boolean getPassable() {

		return false;
	}

	public BuildingType getType() {

		return null;
	}

	public int getX() {

		return 0;
	}

	public int getY() {

		return 0;
	}

	public void removeEvent() {

		
	}

	public void removeGather() {

		
	}

	public void setEvent(BuildingEvent e) {

		
	}

	public void setGather(Gather g) {

		
	}

	public void setPassable(boolean b) {

		
	}

	public void setType(BuildingType t) {

		
	}

	public void setX(int x) {

		
	}

	public void setY(int y) {

		
	}

	public void setupSquares() {

		
	}

	*/
}
