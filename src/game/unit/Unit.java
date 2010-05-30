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
	
	// stats stuff effects spells level xp ranks hp mp skills etc
	// stand animation images for heading left
	// stand animation images for heading right


	public Unit(){
		combatStats = new CombatStats();
		setExperiance(0);
		setLevel(1);
		setType("");
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
	
}
