package game.unit;


public class Unit {
	
	private String type;
	private double level;
	private double experiance;
	private CombatStats combatStats;
	private GraphicalData graphicalData;
	private int combatHeading;
	//1 == right
	//2 == left
	private boolean inTurn;
	private double currIn;
	private double direction;
	// 1 = right 2 = left 3 = up 4 = down 5 = right up 6 right down 7 left up 8 left down
	
	// stats stuff effects spells level xp ranks hp mp skills etc
	// stand animation images for heading left
	// stand animation images for heading right


	public Unit(){
		combatStats = new CombatStats();
		setExperiance(0);
		setLevel(1);
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

	public void setLevel(double level) {
		this.level = level;
	}

	public double getLevel() {
		return level;
	}

	public void setExperiance(double experiance) {
		this.experiance = experiance;
	}

	public double getExperiance() {
		return experiance;
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
			sprite=graphicalData.getbFArcherMoveRight()
		}
	}
}
