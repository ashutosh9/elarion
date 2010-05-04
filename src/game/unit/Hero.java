package game.unit;

import java.util.ArrayList;

import game.field.Field;
import game.field.Square;
import game.item.Item;
import game.main.Animation;
import game.main.Sprite;
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
	private ArrayList<Unit> units = new ArrayList<Unit>(8);
	private int x; //upper left coordinate ON SCREEN
	private int y; //upper left coordinate ON SCREEN
	private Player owner;
	private Square currentSquare;
	private Race race;
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
	// to include combat stats and graphical data as different classes
	
	public Hero(){
		x = 1;
		y = 1;
		heading = 1;
		graphicalData = new GraphicalData();
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
		}
		setCurrentSquare(f.getSquare(x, y));
		f.getSquare(x, y).setHero(this); //Occupied(true);
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

	public void setRace(Race race) {
		this.race = race;
	}

	public Race getRace() {
		return race;
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
		if(moving==false && checkIfPassable(heading,f)==true){
			
			
			moving=true;
			
			int toMoveX = 0;
			int toMoveY = 0;
			
			this.heading = heading;
			
			if(heading==1){
				setCurrentAnimation(graphicalData.getWorldMapMovementUp());		
				toMoveY=-40;
				//this.setHeroLocation((currentSquare.getX()), (currentSquare.getY()-1), f);
			}
			if(heading==2){
				setCurrentAnimation(graphicalData.getWorldMapMovementDown());
				toMoveY=40;
				//this.setHeroLocation((currentSquare.getX()), (currentSquare.getY()+1), f);
			}
			if(heading==3){
				setCurrentAnimation(graphicalData.getWorldMapMovementRight());
				toMoveX=-40;
				//this.setHeroLocation((currentSquare.getX()-1), (currentSquare.getY()), f);
			}
			if(heading==4){
				setCurrentAnimation(graphicalData.getWorldMapMovementLeft());
				toMoveX=40;
				//this.setHeroLocation((currentSquare.getX()+1), (currentSquare.getY()), f);
			}
			if(heading==13){
				setCurrentAnimation(graphicalData.getWorldMapMovementUpRight());
				toMoveY=-40;
				toMoveX=-40;
				//this.setHeroLocation((currentSquare.getX()-1), (currentSquare.getY()-1), f);
				
			}
			if(heading==14){
				setCurrentAnimation(graphicalData.getWorldMapMovementUpLeft());
				toMoveY=-40;
				toMoveX=40;
				//this.setHeroLocation((currentSquare.getX()+1), (currentSquare.getY()-1), f);
			}
			if(heading==23){
				setCurrentAnimation(graphicalData.getWorldMapMovementDownLeft());
				toMoveY=40;
				toMoveX=-40;
				//this.setHeroLocation((currentSquare.getX()-1), (currentSquare.getY()+1), f);
			}
			if(heading==24){
				setCurrentAnimation(graphicalData.getWorldMapMovementDownRight());
				toMoveY=40;
				toMoveX=40;
				//this.setHeroLocation((currentSquare.getX()+1), (currentSquare.getY()+1), f);
			}
			
			currentSprite = new Sprite(currentAnimation);
			if(toMoveX < 0){
				currentSprite.setVelocityOfX(-0.3f);
				toMoveX = Math.abs(toMoveX);
			} else {
			currentSprite.setVelocityOfX(0.3f);
			}
			if(toMoveY < 0){
				currentSprite.setVelocityOfY(-0.3f);
				toMoveY = Math.abs(toMoveY);
			} else {
			currentSprite.setVelocityOfY(0.3f);
			}
			currentSprite.setToMoveX(toMoveX);
			currentSprite.setToMoveY(toMoveY);
			currentSprite.setX(0);
			currentSprite.setY(0);
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
		
		//remove movement points
		
		//execution of events that are on the new hero location
		
	}
	
	
//	public getAnimations(){
//		return race.getHeroAnimations;
//	}

	
}
