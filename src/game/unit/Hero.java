package game.unit;

import java.util.ArrayList;

import game.field.Field;
import game.field.Square;
import game.item.Item;
import game.player.Player;
import game.race.Race;
import game.spells.Talent;

public class Hero extends Unit {

	//combat - left/right move,stand,attack,cast,die
	/*	private Sprite leftHeadingSprite;
	private Animation leftHeadingAnimation;
	private Sprite rightHeadingSprite;
	private Animation rightHeadingAnimation;*/
	@SuppressWarnings("unused")
	private ArrayList<Talent> taletTree = new ArrayList<Talent>(100);
	@SuppressWarnings("unused")
	private ArrayList<Item> inventory = new ArrayList<Item>(100);
	private int x; //upper left coordinate ON SCREEN
	private int y; //upper left coordinate ON SCREEN
	private Player owner;
	private Square currentSquare;
	private Race race;
	// to include combat stats and graphical data as different classes
	
	
	public int getHeroX(){
		return x;
	}
	
	public int getHeroY(){
		return y;
	}

	public void setHeroX(int x){
		this.x = x;
	}
	
	public void setHeroY(int y) {
		this.y = y;
	}
	
	public void setHeroLocation(int x, int y,Field f){
		if(this.x != 0 && this.y != 0){
			f.getSquare(this.x, this.y).setHero(null); //Occupied(false);
		}
		this.x = x;
		this.y = y;
		f.getSquare(x, y).setHero(this); //Occupied(true);
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getOwner() {
		return owner;
	}

	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}

	public Square getCurrentSquare() {
		return currentSquare;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Race getRace() {
		return race;
	}
	
//	public getAnimations(){
//		return race.getHeroAnimations;
//	}

	
}
