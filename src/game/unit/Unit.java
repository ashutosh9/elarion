package game.unit;


public class Unit {
	
	private String type;
	private double level;
	private double experiance;
	
	// stats stuff effects spells level xp ranks hp mp skills etc
	// stand animation images for heading left
	// stand animation images for heading right


	public Unit(){
		
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
	
}
