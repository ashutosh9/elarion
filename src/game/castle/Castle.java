package game.castle;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Point;
import game.field.Field;
import game.field.Square;
import game.graphic.CastleView;
import game.player.Player;
import game.unit.Hero;
import game.unit.Unit;
import game.main.MainClass;

public class Castle {
	private ArrayList<CastleBuilding> buildings = new ArrayList<CastleBuilding>();
	private int x; 
	private int y; 
	private Player owner;
	private Square currentSquare;
	private Square garrisonSquare;
	private Square swapSquare;
	private Image currentSprite;
	private Image background;
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

	public Castle (int x, int y,Field f) {
		selected = false;
		garrison = new Garrison(this);
		//Builds the structure objects
		background = Toolkit.getDefaultToolkit().getImage("Images/castle/Background.png");
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
		setCurrentSquare(f.getSquare(x, y));
		setGarrisonSquare(f.getSquare(x, y-1));
		setSwapSquare(f.getSquare(x-1,y-1));
		f.getSquare(x, y).setCastle(this);
		f.getSquare(x-1, y).setPassable(false);
		f.getSquare( x-1,  y-1).setPassable(false);
		f.getSquare( x-1,  y-2).setPassable(false);
		f.getSquare( x,  y).setPassable(true);
		f.getSquare( x,  y-1).setPassable(false);
		f.getSquare( x,  y-2).setPassable(false);
		f.getSquare( x+1,  y).setPassable(false);
		f.getSquare( x+1,  y-1).setPassable(false);
		f.getSquare( x+1,  y-2).setPassable(false);
		this.x = x;
		this.y = y;
	}

	public ArrayList<CastleBuilding> getBuildings() {
		return buildings;
	}
	
	public CastleBuilding getBuilding(int i) {
		return buildings.get(i);
	}
	
	public Image getIcon() {
		return icon;
	}
	
	public void setIcon(Image icon) {
		this.icon = icon;
	}
	
	public Image getImage() {
		return currentSprite;
	}
	
	public void setImage(Image image) {
		this.currentSprite = image;
	}
	
	public Image getBackground() {
		return background;
	}
	
	public void setBackground(Image background) {
		this.background = background;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player p) {
		this.owner = p;
	}
	
	public Square getCurrentSquare() {
		return currentSquare;
	}

	public void setCurrentSquare(Square s) {
		currentSquare = s;
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

	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected (boolean selected) {
		this.selected = selected;
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
	
	public void build(int i) {
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
	
	public void destroy(int i) {
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
	
	public Garrison getGarrison() {
			return garrison;
	}
	
	public void swapUnitGarrisonToHero(int heroUnit, int garrisonUnit, Garrison garrison) {
		Unit temp;
		temp = garrison.getUnit(garrisonUnit);
		garrison.getUnits().set(garrisonUnit,currentSquare.getHero().getUnits().get(heroUnit));
		currentSquare.getHero().getUnits().set(heroUnit, temp);
	}
	
	public void swapUnitGarrisonToSelf(int Unit1, int Unit2, Garrison garrison) {
		Unit temp;
		temp = garrison.getUnit(Unit1);
		garrison.getUnits().set(Unit1,currentSquare.getHero().getUnits().get(Unit2));
		currentSquare.getHero().getUnits().set(Unit2, temp);
	}
	
	public void mousePressed (MouseEvent mouseInput, CastleView castleView, MainClass mc) {
		boolean clicked = false;
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		//checks whether to move units between the garrison/garrisoned hero and the visiting hero.
		Hero clickedUnitHero = null;
		for (int i=0;i<8;i++) {
			for (int j=0;j<2;j++) {	
				topLeft.setLocation(943 + (40*i),13+(40*j));
				bottomRight.setLocation(958 + (40*i),48+(40*j));
				if (mc.isWithinBounds(mc.getMousePos(),topLeft,bottomRight)) {
					if (castleView.getSelected() != 0) { //in this case we swap units around
						if (garrisonSquare.getHero() != null) {
							switch (j) {
								case 0: clickedUnitHero = garrisonSquare.getHero(); break;
								case 1: clickedUnitHero = currentSquare.getHero(); break;
							}
							if (castleView.getSelected() < 9) {
								swapUnitGarrisonToSelf(castleView.getSelected(), i, garrison);
							} else {
								swapUnitGarrisonToHero(i, (castleView.getSelected()-8), garrison);
							}
						} else {
							if (castleView.getSelected() < 9) {
								garrisonSquare.getHero().swapUnit(clickedUnitHero, castleView.getSelected(), i);
							} else {
								currentSquare.getHero().swapUnit(clickedUnitHero, castleView.getSelected(), i);
							}
						}
					} else { //in this case we mark a new selected unit
						castleView.setSelected((1+i)*(j+1));
					}
					clicked = true;
				}
			}	
		}
		if (!clicked) {
			for (CastleBuilding current : buildings) {
				topLeft.setLocation(current.getX(),current.getY());
				bottomRight.setLocation(current.getX()+current.getW(),current.getY()+current.getH());
				if (mc.isWithinBounds(mc.getMousePos(),topLeft,bottomRight)) {
					castleView.setMenuBuilding(current.getIndex());
					clicked = true;
				}
			}
		}
		if (!clicked) {
			topLeft.setLocation(1241, 14);
			bottomRight.setLocation(1275, 110);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				swapGarrison();
				clicked = true;
			}
		}
		if (!clicked) {
			topLeft.setLocation(660, 20);
			bottomRight.setLocation(760, 100);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				castleView.setInCastle(false);
				clicked = true;
			}
		}

	}
}
