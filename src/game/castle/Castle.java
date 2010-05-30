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
	private Square garrisonSquare;
	private Square swapSquare;
	private Sprite currentSprite;
	private Sprite background;
	private boolean selected;
	private Image icon;
	private Field field;
	private static Keep keep;
	private static TownHall townhall;
	private static Barracks barracks;
	private static Archery archery;
	private static MageTower magetower;
	private static Market market;
	private static Tavern tavern;
	private Garrison garrison;
	

	public Castle () {
		x = 1;
		y = 1;
		selected = false;
		garrison = new Garrison(this);
		//Builds the structure objects
		keep = new Keep(this);
		townhall = new TownHall(this);
		barracks = new Barracks(this);
		archery = new Archery(this);
		magetower = new MageTower(this);
		market = new Market(this);
		tavern = new Tavern(this);
		//adds them to the container
		buildings.add(keep);
		buildings.add(townhall);
		buildings.add(barracks);
		buildings.add(archery);
		buildings.add(magetower);
		buildings.add(market);
		buildings.add(tavern);
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
		garrisonSquare.setX(s.getX());
		garrisonSquare.setY(s.getY()-1);
	}

	public Square getGarrisonSquare() {
			return garrisonSquare;
	}
	
	public void setGarrisonSquare(Square s) {
		garrisonSquare = s;
	}
	
	public Square getSwapSquare() {
		return swapSquare;
	}

	public void setSwapSquare(Square s) {
		swapSquare = s;
	}
	
	public void setCastleLocation(int x, int y,Field f){
		if(this==f.getSquare(this.x, this.y).getCastle()){
			f.getSquare(this.x, this.y).setCastle(null);
			f.getSquare(this.x-1, this.y).setPassable(true);
			f.getSquare(this.x-1, this.y-1).setPassable(true);
			f.getSquare(this.x-1, this.y-2).setPassable(true);
			f.getSquare(this.x, this.y).setPassable(true);
			f.getSquare(this.x, this.y-1).setPassable(true);
			f.getSquare(this.x, this.y-2).setPassable(true);
			f.getSquare(this.x+1, this.y).setPassable(true);
			f.getSquare(this.x+1, this.y-1).setPassable(true);
			f.getSquare(this.x+1, this.y-2).setPassable(true);
		}
		setCurrentSquare(f.getSquare(x, y));
		setGarrisonSquare(f.getSquare(x, y-1));
		setSwapSquare(f.getSquare(x-1,y-1));
		f.getSquare(x, y).setCastle(this);
		f.getSquare(this.x-1, this.y).setPassable(false);
		f.getSquare(this.x-1, this.y-1).setPassable(false);
		f.getSquare(this.x-1, this.y-2).setPassable(false);
		f.getSquare(this.x, this.y).setPassable(true);
		f.getSquare(this.x, this.y-1).setPassable(false);
		f.getSquare(this.x, this.y-2).setPassable(false);
		f.getSquare(this.x+1, this.y).setPassable(false);
		f.getSquare(this.x+1, this.y-1).setPassable(false);
		f.getSquare(this.x+1, this.y-2).setPassable(false);
	}

	public void turnUpdate() {
		int i = 0;
		while (i < buildings.size()) {
			if (buildings.get(i)!= null) {
					buildings.get(i).update();
			}
		i++;
		}
	}
	
	public void Build(int i) {
		if (buildings.get(i) != null
			&&
			buildings.get(i).getwood() >= owner.getWood().getAmount()
			&&
			buildings.get(i).getstone() >= owner.getStone().getAmount()
			&&
			buildings.get(i).getgold() >= owner.getGold().getAmount()
			&&
			!buildings.get(i).isBuilt()) {
			buildings.get(i).modBuilt(true);
		}
	}
	
	public void Destroy(int i) {
		if (buildings.get(i) != null && buildings.get(i).isBuilt()) {
			buildings.get(i).modBuilt(false);
		}
	}

	public void swapGarrison() {
		if (!((garrisonSquare.getHero() == null) && (currentSquare.getHero() == null))) {
			if ((garrisonSquare.getHero() == null) && (currentSquare.getHero() != null)) {
				if(garrison.getSize()<=(8-currentSquare.getHero().getUnitSize())) {
					for (int i=0;i<8;i++) {
						if (garrison.getUnit(i) != null) {
							currentSquare.getHero().addUnit(garrison.getUnit(i));
						}
					}
					currentSquare.getHero().setHeroLocation(garrisonSquare.getX(), garrisonSquare.getY(), this.field);
				}
				currentSquare.getHero().setHeroLocation(swapSquare.getX(), swapSquare.getY(), this.field);
				garrisonSquare.getHero().setHeroLocation(currentSquare.getX(), currentSquare.getY(), this.field);
				swapSquare.getHero().setHeroLocation(garrisonSquare.getX(), garrisonSquare.getY(), this.field);
				
			}
		}
	}
}
