package game.building;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import game.field.Field;
import game.field.Square;
import game.main.MainClass;
import game.player.Player;

public class Building {
	protected int x; 
	protected int y; 
	protected Player owner;
	protected Square currentSquare;
	protected Image currentSprite;
	protected MainClass mc;
	protected Field field;
	protected boolean inBuilding;
	protected Color white = new Color (255,255,255);
	protected Color black = new Color(0,0,0);
	protected Color gold = new Color(250,210,10);
	
	public Building(int x, int y,Field f, MainClass mc) {
		owner = null;
		this.mc = mc;
		this.x = x;
		this.y = y;
		this.field = f;
		currentSquare = field.getSquare(x, y);
		field.getSquare(x,y).setBuilding(this);
		field.getSquare(x+1,y).setPassable(false);
		field.getSquare(x,y-1).setPassable(false);
		field.getSquare(x+1,y-1).setPassable(false);
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
	
	public void draw(Graphics g) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public boolean isInBuilding() {
		return inBuilding;
	}
	
	public void setInBuilding(boolean b) {
		inBuilding = b;
	}
}
