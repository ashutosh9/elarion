package game.unit;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import game.core.Path;
import game.field.Field;
import game.field.Square;
import game.item.Item;
import game.main.Animation;
import game.main.Sprite;
import game.player.Player;
import game.spells.Talent;

public class Hero extends Unit {

	@SuppressWarnings("unused")
	private ArrayList<Talent> taletTree = new ArrayList<Talent>(100);
	private ArrayList<Item> inventory = new ArrayList<Item>(100);
	private ArrayList<Unit> units = new ArrayList<Unit>(8);
	private int x; 
	private int y; 
	private Player owner;
	private Square currentSquare;
	private int heading;
	// for heading 
	// 1 = up
	// 2 = down
	// 3 = left
	// 4 = right
	// 13 = upLeft
	// 14 = upRight
	// 23 = downLeft
	// 24 = downRight
	private boolean moving;
	private Sprite currentSprite;
	private GraphicalData graphicalData;
	private Animation currentAnimation;
	private Image icon;
	private boolean selected;
	private Path path;
	private int movementPoints;
	// to include combat stats and graphical data as different classes
	private double hPower;
	
	public Hero(){
		x = 1;
		y = 1;
		heading = 1;
		currentAnimation = new Animation();
		currentSprite = new Sprite(currentAnimation);
		graphicalData = new GraphicalData();
		moving = false;
		icon = Toolkit.getDefaultToolkit().getImage("Images/heroes/human/human_hero.jpg");
		selected = false;
		moving = false;
		path = null;
		movementPoints = 100;
	}
	
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
		if(this==f.getSquare(this.x, this.y).getHero()){
			f.getSquare(this.x, this.y).setHero(null); //Occupied(false);
			f.getSquare(this.x, this.y).setPassable(true);
		}
		setCurrentSquare(f.getSquare(x, y));
		f.getSquare(x, y).setHero(this); //Occupied(true);
		f.getSquare(x, y).setPassable(false);
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getOwner() {
		return owner;
	}

	private void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
		this.x = currentSquare.getX();
		this.y = currentSquare.getY();
	}

	public Square getCurrentSquare() {
		return currentSquare;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;
	}

	public Animation getCurrentAnimation() {
		return currentAnimation;
	}

	public int getHeading() {
		return heading;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setCurrentMovingSprite(Sprite currentMovingSprite) {
		this.currentSprite = currentMovingSprite;
	}

	public Sprite getCurrentSprite() {

		return currentSprite;
	}

	public void setGraphicalData(GraphicalData graphicalData) {
		this.graphicalData = graphicalData;
	}

	public GraphicalData getGraphicalData() {
		return graphicalData;
	}
	
	public Animation getStandAnimation(){
		if(heading==1){
			return graphicalData.getwMMUpStand();
		}
		if(heading==2){
			return graphicalData.getwMMDownStand();
		}
		if(heading==3){
			return graphicalData.getwMMRightStand();
		}
		if(heading==4){
			return graphicalData.getwMMLeftStand();
		}
		if(heading==13){
			return graphicalData.getwMMUpRightStand();
		}
		if(heading==14){
			return graphicalData.getwMMUpLeftStand();
		}
		if(heading==23){
			return graphicalData.getwMMDownLeftStand();
		}
		if(heading==24){
			return graphicalData.getwMMDownRightStand();
		}
		return null;
	}
	
	public void moveOneSquare(int heading, Field f) {
		
		//check if movement points are enough for moving 
		
		if(movementPoints >= 10) {
	
			if(moving==false && checkIfPassable(heading,f)==true){
				
				
				moving=true;
				
				int toMoveX = 0;
				int toMoveY = 0;
				
				this.heading = heading;
				
				if(heading==1){
					setCurrentAnimation(graphicalData.getWorldMapMovementUp());		
					toMoveY=-40;
				}
				if(heading==2){
					setCurrentAnimation(graphicalData.getWorldMapMovementDown());
					toMoveY=40;
				}
				if(heading==3){
					setCurrentAnimation(graphicalData.getWorldMapMovementRight());
					toMoveX=-40;
				}
				if(heading==4){
					setCurrentAnimation(graphicalData.getWorldMapMovementLeft());
					toMoveX=40;
				}
				if(heading==13){
					setCurrentAnimation(graphicalData.getWorldMapMovementUpRight());
					toMoveY=-40;
					toMoveX=-40;
					
				}
				if(heading==14){
					setCurrentAnimation(graphicalData.getWorldMapMovementUpLeft());
					toMoveY=-40;
					toMoveX=40;
				}
				if(heading==23){
					setCurrentAnimation(graphicalData.getWorldMapMovementDownLeft());
					toMoveY=40;
					toMoveX=-40;
				}
				if(heading==24){
					setCurrentAnimation(graphicalData.getWorldMapMovementDownRight());
					toMoveY=40;
					toMoveX=40;
				}
				
				currentSprite = new Sprite(currentAnimation);
				
				if(toMoveX < 0){
					currentSprite.setVelocityOfX(-0.2f);
					toMoveX = Math.abs(toMoveX);
				} else {
					currentSprite.setVelocityOfX(0.2f);
				}
				if(toMoveY < 0){
					currentSprite.setVelocityOfY(-0.2f);
					toMoveY = Math.abs(toMoveY);
				} else {
					currentSprite.setVelocityOfY(0.2f);
				}
				currentSprite.setToMoveX(toMoveX);
				currentSprite.setToMoveY(toMoveY);
				currentSprite.setX(0);
				currentSprite.setY(0);
			}
		}
	}
	
	private boolean checkIfPassable(int heading,Field f) {
		
		Square nextSquare = new Square((currentSquare.getX()), (currentSquare.getY()));
		
		if(heading==1){
			nextSquare = f.getSquare((currentSquare.getX()), (currentSquare.getY()-1));
		}
		if(heading==2){
			nextSquare = f.getSquare((currentSquare.getX()), (currentSquare.getY()+1));
		}
		if(heading==3){
			nextSquare = f.getSquare((currentSquare.getX()-1), (currentSquare.getY()));
		}
		if(heading==4){
			nextSquare = f.getSquare((currentSquare.getX()+1), (currentSquare.getY()));
		}
		if(heading==13){
			nextSquare = f.getSquare((currentSquare.getX()-1), (currentSquare.getY()-1));
		}
		if(heading==14){
			nextSquare = f.getSquare((currentSquare.getX()+1), (currentSquare.getY()-1));
		}
		if(heading==23){
			nextSquare = f.getSquare((currentSquare.getX()-1), (currentSquare.getY()+1));
		}
		if(heading==24){
			nextSquare = f.getSquare((currentSquare.getX()+1), (currentSquare.getY()+1));
		}
		
		if(!nextSquare.isPassable()) {
			return false;
		} else {
			return true;
		}
		
	}

	public void movedOneSquare(Field f){
		
		moving = false;
		
		if(heading==1){
			this.setHeroLocation((currentSquare.getX()), (currentSquare.getY()-1), f);
		}
		if(heading==2){
			this.setHeroLocation((currentSquare.getX()), (currentSquare.getY()+1), f);
		}
		if(heading==3){
			this.setHeroLocation((currentSquare.getX()-1), (currentSquare.getY()), f);
		}
		if(heading==4){
			this.setHeroLocation((currentSquare.getX()+1), (currentSquare.getY()), f);
		}
		if(heading==13){
			this.setHeroLocation((currentSquare.getX()-1), (currentSquare.getY()-1), f);
		}
		if(heading==14){
			this.setHeroLocation((currentSquare.getX()+1), (currentSquare.getY()-1), f);
		}
		if(heading==23){
			this.setHeroLocation((currentSquare.getX()-1), (currentSquare.getY()+1), f);
		}
		if(heading==24){
			this.setHeroLocation((currentSquare.getX()+1), (currentSquare.getY()+1), f);
		}
		
		//execution of events that are on the new hero location
		getCurrentSquare().setPath(false);
		f.getEvents().pickUp(getCurrentSquare(), this);
		f.getEvents().pickUpResource(getCurrentSquare(), getOwner());
		//remove movement points
		movementPoints -= 10;
		

		
	}
	
	public void addItem(Item i){
		inventory.add(i);
	}
	
	public void removeItem(Item i){
		if (inventory.contains(i)) {
			inventory.remove(i);
		}
	}
	
	public Item getItem(Item i){
		if (inventory.contains(i)) {
			return inventory.get(inventory.indexOf(i));
		} 
		return null;
	}
	
	public void addUnit(Unit u){
		units.add(u);
	}

	public void removeUnit(Unit u){
		if (units.contains(u)) {
			units.remove(u);
		}
	}	
	
	public Unit getUnit(Unit u){
		if (units.contains(u)) {
			return units.get(units.indexOf(u));
			}
		return null;
	}

	public int getUnitSize() {
		return units.size();
	}
	
	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public Image getIcon() {
		return icon;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}
	
	public ArrayList<Unit> getUnits(){
		return units;
	}
	
	public void setPath(Path path) {
		this.path = path;
	}
	
	public Path getPath() {
		return path;
	}

	public void setMovementPoints(int movementPoints) {
		this.movementPoints = movementPoints;
	}

	public int getMovementPoints() {
		return movementPoints;
	}

	public void sethPower(double hPower) {
		this.hPower = hPower;
	}

	public double gethPower() {
		return hPower;
	}
	
	
//	public getAnimations(){
//		return race.getHeroAnimations;
//	}

	
}
