package game.player;

import java.awt.Toolkit;
import java.util.ArrayList;
import game.castle.Castle;
import game.field.Field;
import game.field.Square;
import game.resource.Resource;
import game.unit.Hero;

public class Player {
	
	private String name;
	private ArrayList<Hero> heroes = new ArrayList<Hero>();
	private ArrayList<Hero> deadHeroes = new ArrayList<Hero>();
	private ArrayList<Castle> castles = new ArrayList<Castle>();
	private Resource gold = new Resource("gold",0,0,Toolkit.getDefaultToolkit().getImage("game\\images\\resource\\gold.png"));
	private Resource stone = new Resource("stone",0,0,Toolkit.getDefaultToolkit().getImage("game\\images\\resource\\stone.png"));
	private Resource wood = new Resource("wood",0,0,Toolkit.getDefaultToolkit().getImage("game\\images\\resource\\wood.png"));
	private Square currentView;
	private int currentViewAbsX; 
	private int currentViewAbsY;
	private boolean currentPlayer;
	
	public Player(){
		gold.setAmount(0);
		stone.setAmount(0);
		wood.setAmount(0);
		currentPlayer = false;
	}
	
	public Player(String s){
		name = s;
		gold.setAmount(0);
		stone.setAmount(0);
		wood.setAmount(0);
		currentPlayer = false;
	}
	
	public void newCastle(Castle c,int x,int y,Field field) {
		castles.add(c);
		c.setOwner(this);
		c.setCastleLocation(x, y, field);
	}
	
	public Castle getCastle(Castle c) {
		if(castles.contains(c)){
			int i = castles.indexOf(c);
			return castles.get(i);
		}
		return null;
	}
	
	public void removeCastle(Castle c){
		if(castles.contains(c)){
			castles.remove(c);
		}
	}
	
	public void newHero(Hero h,int x,int y,Field field) {
		heroes.add(h);
		h.setOwner(this);
		h.setHeroLocation(x, y, field);
	}
	
	public Hero getHero(Hero h) {
		if(heroes.contains(h)){
			int i = heroes.indexOf(h);
			return heroes.get(i);		
		}
		return null;
	}
	
	public void removeHero(Hero h){
		if(heroes.contains(h)){
			heroes.remove(h);
			deadHeroes.add(h);
		}
	}
	
	public void reviveHero(Hero h) {
		if(deadHeroes.contains(h)){
			deadHeroes.remove(h);
			heroes.add(h);
		}
	}
	
	public ArrayList<Hero> getHeroes(){
		return heroes;
	}

	public void setCurrentView(Square s) {
		currentView = s;
	}

	public Square getCurrentView() {
		return currentView;
	}

	public void setCurrentViewAbsX(int currentViewAbsX) {
		this.currentViewAbsX = currentViewAbsX;
	}

	public int getCurrentViewAbsX() {
		return currentViewAbsX;
	}

	public void setCurrentViewAbsY(int currentViewAbsY) {
		this.currentViewAbsY = currentViewAbsY;
	}

	public int getCurrentViewAbsY() {
		return currentViewAbsY;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Resource getGold() {
		return gold;
	}

	public Resource getStone() {
		return stone;
	}

	public Resource getWood() {
		return wood;
	}

	public void setCurrentPlayer(boolean currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public boolean isCurrentPlayer() {
		return currentPlayer;
	}
	
	public Hero getSelectedHero(){
		int i = 0;
		boolean selected = false;
		for(Hero h : heroes){
			if(h.isSelected()){
				i = heroes.indexOf(h);
				selected = true;
			}
		}
		if(selected){
			return heroes.get(i);
		} 
		return null;
	}
	
	public void selectHero(Hero h){
		for(Hero hero : heroes){
			if((hero.getHeroX() == h.getHeroX()) && (hero.getHeroY() == h.getHeroY())){
				hero.setSelected(true);
			} else {
				hero.setSelected(false);
				hero.setPath(null);
			}
		}
	}

}
