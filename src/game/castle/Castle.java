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
	private Hero garrisonHero;
	private MainClass mc;
	private int buildLimit;
	
	public Castle (int x, int y,Field f, MainClass mc) {
		this.mc = mc;
		buildLimit = 1;
		field = f;
		selected = false;
		garrisonHero = new Hero(mc);
		garrisonHero.clearUnits();
		//Builds the structure objects
		background = Toolkit.getDefaultToolkit().getImage("Images/castle/Background.png");
		currentSprite = Toolkit.getDefaultToolkit().getImage("Images/castle/castle.png");
		keep = new Keep(this,mc);
		townhall = new TownHall(this,mc);
		barracks = new Barracks(this,mc);
		archery = new Archery(this,mc);
		magetower = new MageTower(this,mc);
		market = new Market(this,mc);
		tavern = new Tavern(this,mc);
		//adds them to the container
		buildings.add(keep);
		buildings.add(townhall);
		buildings.add(barracks);
		buildings.add(archery);
		buildings.add(magetower);
		buildings.add(market);
		buildings.add(tavern);
		setCurrentSquare(f.getSquare(x, y+1));
		setGarrisonSquare(f.getSquare(x, y));
		setSwapSquare(f.getSquare(x-1,y));
		f.getSquare(x, y+1).setCastle(this);
		f.getSquare(x-1, y+1).setPassable(false);
		f.getSquare( x-1,  y).setPassable(false);
		f.getSquare( x-1,  y-1).setPassable(false);
		f.getSquare( x,  y+1).setPassable(true);
		f.getSquare( x,  y).setPassable(false);
		f.getSquare( x,  y-1).setPassable(false);
		f.getSquare( x+1,  y+1).setPassable(false);
		f.getSquare( x+1,  y).setPassable(false);
		f.getSquare( x+1,  y-1).setPassable(false);
		this.x = x;
		this.y = y;
	}

	public ArrayList<CastleBuilding> getBuildings() {
		return buildings;
	}
	
	public CastleBuilding getBuilding(int i) {
		return buildings.get(i);
	}
	
	public int getBuildLimit() {
		return buildLimit;
	}
	
	public void setBuildLimit(int i) {
		buildLimit = i;
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
	
	public Field getField() {
		return field;
	}
	
	public void setField(Field f) {
		field = f;
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
		for (int i=0;i<7;i++) {
			buildings.get(i).update();
		}
		buildLimit = 1;
	}

	public void destroyBuildings(int i) {
		if (buildings.get(i) != null && buildings.get(i).isBuilt()) {
			buildings.get(i).setBuilt(false);
			buildings.get(i).setUpgraded(false);
		}
	}

	public void swapGarrison() {
		if (currentSquare.getHero() == null) {
			if (garrisonSquare.getHero() != null) {
				garrisonSquare.getHero().setHeroLocation(currentSquare.getX(), currentSquare.getY(), field);
			}
		} else if ((currentSquare.getHero() != null)) {
			if (garrisonSquare.getHero() != null) {
				garrisonSquare.getHero().setHeroLocation(swapSquare.getX(), swapSquare.getY(), field);
				currentSquare.getHero().setHeroLocation(garrisonSquare.getX(), garrisonSquare.getY(), field);
				swapSquare.getHero().setHeroLocation(currentSquare.getX(),currentSquare.getY(),field);
			} else {
				if (8-currentSquare.getHero().getUnitsAmmount() > garrisonHero.getUnitsAmmount()) {
					for (int i=0;i<8;i++) {
						if (garrisonHero.getUnits().get(i) != null) {
							currentSquare.getHero().addUnit(garrisonHero.getUnits().get(i));
						}
					}
					garrisonHero.clearUnits();
					currentSquare.getHero().setHeroLocation(garrisonSquare.getX(), garrisonSquare.getY(), field);
				}
			}
		}
		swapSquare.setPassable(false);
		garrisonSquare.setPassable(false);
	}
	
	public Hero getGarrison() {
			return garrisonHero;
	}

//	public void swapUnitGarrisonToHero(int heroUnit, int garrisonUnit, Garrison garrison) {
//		Unit temp;
//		temp = garrison.getUnit(garrisonUnit);
//		garrison.getUnits().set(garrisonUnit,currentSquare.getHero().getUnits().get(heroUnit));
//		currentSquare.getHero().getUnits().set(heroUnit, temp);
//	}
//	
//	public void swapUnitGarrisonToSelf(int Unit1, int Unit2, Garrison garrison) {
//		Unit temp;
//		temp = garrison.getUnit(Unit1);
//		garrison.getUnits().set(Unit1,currentSquare.getHero().getUnits().get(Unit2));
//		currentSquare.getHero().getUnits().set(Unit2, temp);
//	}
	
	public void mousePressed (MouseEvent mouseInput, CastleView castleView) {
		boolean clicked = false;
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		//checks whether to move units between the garrison/garrisoned hero and the visiting hero.
		for (int i=0;i<8;i++) {
			for (int j=0;j<2;j++) {
				topLeft.setLocation(904 + (42*i),14+(60*j));
				bottomRight.setLocation(939 + (42*i),49+(60*j));
				if (mc.isWithinBounds(mc.getMousePos(),topLeft,bottomRight)) {
					if (castleView.getSelected() != 0) { //in this case we swap units around
						Hero clickedUnitHero = null;
						if (j == 0) {
							if (garrisonSquare.getHero() != null) {
								clickedUnitHero = garrisonSquare.getHero();
							} else {
								clickedUnitHero = garrisonHero;
							}
						} else {
							clickedUnitHero = currentSquare.getHero();
						}
						Hero selectedUnitHero = null;
						if (castleView.getSelected() < 9) {
							if (garrisonSquare.getHero() != null) {
								selectedUnitHero = garrisonSquare.getHero();
							} else {
								selectedUnitHero = garrisonHero;
							}	
						} else {
							selectedUnitHero = currentSquare.getHero();
						}
						if (castleView.getSelected() < 9) {
							selectedUnitHero.swapUnit(clickedUnitHero, i, castleView.getSelected()-1);
						} else {
							selectedUnitHero.swapUnit(clickedUnitHero, i, castleView.getSelected()-9);
						}

						castleView.setSelected(0);
					} else { //in this case we mark a new selected unit. Forgetting breaks is fun ^_^
						switch (j) {
						case 0: if (garrisonSquare.getHero() != null) {
									if (garrisonSquare.getHero().getUnits().get(i) != null) {
										castleView.setSelected((1+i));
									}
								} else if (garrisonHero.getUnits().get(i) != null) {
									castleView.setSelected((1+i));
								}; break;
						case 1: 
								if (currentSquare.getHero() != null) {
									if (currentSquare.getHero().getUnits().get(i) != null) {
										castleView.setSelected((1+i)+8); break;
									}
								} break;
						}
					}
					clicked = true;
				}
			}	
		}
		//checks for buildings clicked
		if (!clicked) {
			for (CastleBuilding current : buildings) {
				if (current.isBuilt()) {
					topLeft.setLocation(current.getX(),current.getY());
					bottomRight.setLocation(current.getX()+current.getW(),current.getY()+current.getH());
					if (mc.isWithinBounds(mc.getMousePos(),topLeft,bottomRight)) {
						castleView.setMenuBuilding(current.getIndex());
						clicked = true;
					}
				}
			}
		}
		//checks for swap button clicked
		if (!clicked) {
			topLeft.setLocation(1241, 14);
			bottomRight.setLocation(1275, 110);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				swapGarrison();
				clicked = true;
			}
		}
		//checks for exit button clicked
		if (!clicked) {
			topLeft.setLocation(660, 20);
			bottomRight.setLocation(760, 100);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				mc.setInCastle(false);
				clicked = true;
			}
		}
		//de-selects if clicked on nothing
		if (!clicked) {
			castleView.setSelected(0);
		}

	}
}
