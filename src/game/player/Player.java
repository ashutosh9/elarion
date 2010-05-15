package game.player;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;

import game.castle.Castle;
import game.field.Field;
import game.field.Square;
import game.race.Race;
import game.resource.Resource;
import game.unit.Hero;

public class Player {
	
	private String name;
	private Hero mainHero;
	private Hero selectedHero;
	private ArrayList<Hero> heroes = new ArrayList<Hero>(20);
	private ArrayList<Hero> deadHeroes = new ArrayList<Hero>(30);
	private Color color;
	private Castle mainCastle; // castle functions identical to the hero ones
	@SuppressWarnings("unused")
	private ArrayList<Castle> castles = new ArrayList<Castle>(20);
	private Resource gold = new Resource("gold",0,0,Toolkit.getDefaultToolkit().getImage("game\\images\\resource\\gold.png"));
	private Resource stone = new Resource("stone",0,0,Toolkit.getDefaultToolkit().getImage("game\\images\\resource\\stone.png"));
	private Resource wood = new Resource("wood",0,0,Toolkit.getDefaultToolkit().getImage("game\\images\\resource\\wood.png"));
	private Square currentView;
	private int currentViewAbsX; 
	private int currentViewAbsY;
	private boolean humanPlayer;
	private Race race;
	private boolean currentPlayer;
	
	public Player(String s, Race race){
		name = s;
		this.race = race;
		gold.setAmount(0);
		stone.setAmount(0);
		wood.setAmount(0);
	}
	
	public Player(){
		
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
	
	public void setMainHero(Hero h){
		mainHero = h;
		if(!heroes.contains(h)) {
			heroes.add(h);
		}
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
	
	public void setColor(Color c){
		this.color = c;
	}
	
	
	
	public Color getColor(){
		return color;
	}
	
	public Hero getMainHero(){
		return mainHero;
	}
	
	public ArrayList<Hero> getHeroes(){
		return heroes;
	}
	
	public boolean isAI(){
		return !humanPlayer;
	}
	
	public void setHuman(boolean b){
		humanPlayer = b;
	}


	public void setCurrentView(Square s) {
		currentView = s;
	}

	public Square getCurrentView() {
		return currentView;
	}

	public void setMainCastle(Castle mainCastle) {
		this.mainCastle = mainCastle;
	}

	public Castle getMainCastle() {
		return mainCastle;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Race getRace() {
		return race;
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

	public void selectHero(Hero selectedHero) {
		this.selectedHero = selectedHero;
	}

	public Hero getSelectedHero() {
		return selectedHero;
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

}
