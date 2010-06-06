package game.unit;

import game.main.MainClass;

import java.awt.Image;
import java.awt.Point;


public class Unit {
	
	protected Image icon;
	private String type;
	private CombatStats combatStats;
	private GraphicalData graphicalData;
	private int combatHeading;
	//1 == right
	//2 == left
	private boolean inTurn;
	private double currIn;
	private double direction;
	// 1 = right 2 = left 3 = up 4 = down 5 = right up 6 right down 7 left up 8 left down
	private double currHp;
	private Point experience;
	private int level;
	private String name;
	
	// stats stuff effects spells level xp ranks hp mp skills etc
	// stand animation images for heading left
	// stand animation images for heading right


	public Unit(){
		level = 1;
		combatStats = new CombatStats();
		experience = new Point();
		experience.x = 0;
		experience.y = 1000;
		setType("");
		setInTurn(false);
		combatStats.getCombatPos().setLocation(16, 8);
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setCombatStats(CombatStats combatStats) {
		this.combatStats = combatStats;
	}

	public CombatStats getCombatStats() {
		return combatStats;
	}

	public void setGraphicalData(GraphicalData graphicalData) {
		this.graphicalData = graphicalData;
	}

	public GraphicalData getGraphicalData() {
		return graphicalData;
	}

	public void setCombatHeading(int combatHeading) {
		this.combatHeading = combatHeading;
	}

	public int getCombatHeading() {
		return combatHeading;
	}

	public void setInTurn(boolean inTurn) {
		this.inTurn = inTurn;
	}

	public boolean isInTurn() {
		return inTurn;
	}

	public void setCurrIn(double currIn) {
		this.currIn = currIn;
	}

	public double getCurrIn() {
		return currIn;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getDirection() {
		return direction;
	}
	
	public void moveOneTile(){
		if(direction == 1){
			
		}
	}

	public void setCurrHp(double currHp) {
		this.currHp = currHp;
	}

	public double getCurrHp() {
		return currHp;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public Image getIcon() {
		return icon;
	}
	
	public void setExperience(Point experience) {
		this.experience = experience;
	}

	public Point getExperience() {
		return experience;
	}
	
	public void addExperience(int xp,MainClass mc){
		experience.x += xp;
		if(experience.x > experience.y ){
			levelUp(mc);
		}
	}

	public void levelUp(MainClass mc) {
		level++;
		if(experience.x < experience.y){
			experience.x = experience.y;
		}
		experience.y *= 1.5;
		experience.y += level*100;
		experience.y -= experience.y % 10;
		
		LevelPopupWindow popup = new LevelPopupWindow(mc, this);
		
		mc.setPopupWindow(popup);
		
	}

	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
