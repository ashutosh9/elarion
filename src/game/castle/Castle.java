package game.castle;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import game.field.Field;
import game.field.Square;
import game.main.Sprite;
import game.player.Player;
import game.unit.Hero;

public class Castle {
	private ArrayList<CastleBuilding> buildings = new ArrayList<CastleBuilding>();
	private int x; 
	private int y; 
	private Player owner;
	private Square currentSquare;
	private Sprite currentSprite;
	private boolean selected;
	private Image icon;
	private Field field;
	
	public Castle () {
		x = 1;
		y = 1;
		selected = false;
		
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player p) {
		owner = p;
	}
	
	public Square getCurrentSquare() {
		return currentSquare;
	}

	public void setCurrentSquare(Square s) {
		currentSquare = s;
	}

	public void setCastleLocation(int x, int y,Field f){
		if(this==f.getSquare(this.x, this.y).getCastle()){
			f.getSquare(this.x, this.y).setCastle(null);
			f.getSquare(this.x, this.y).setPassable(true);
		}
		setCurrentSquare(f.getSquare(x, y));
		f.getSquare(x, y).setCastle(this);
		f.getSquare(x, y).setPassable(false);
	}

}
