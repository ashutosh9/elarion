package game.unit;

import java.awt.Point;

public class CombatStats {
	
	
	private Point combatPos = new Point();
	private double cP;

	private double movementpoints;	
	private int initiative;
	
	private Point health;
	private Point mana;
	
	private int strenght;
	private int constitution;
	
	private int dexterity;
	private int intelligence;
	
	private int wisdom;
	private int charisma;

	public CombatStats(){
		health = new Point(100,100);
		mana = new Point(100,100);
		
		strenght = 10;
		constitution = 10;
		dexterity = 10;
		intelligence = 10;
		wisdom = 10;
		charisma = 10;
	}
	
	public void setCurrentHealth(int i){
		health.x = i;
	}
	
	public void setMaximumHealth(int i){
		health.y = i;
	}
	
	public int getMaximumHealth(){
		return health.y;
	}
	
	public int getCurrentHealth(){
		return health.x;
	}
	
	public void setCurrentMana(int i){
		mana.x = i;
	}
	
	public void setMaximumMana(int i){
		mana.y = i;
	}
	
	public int getCurrentMana(){
		return mana.x;
	}
	
	public int getMaximumMana(){
		return mana.y;
	}

	public void setMovementpoints(double movementpoints) {
		this.movementpoints = movementpoints;
	}

	public double getMovementpoints() {
		return movementpoints;
	}

	public void setCombatPos(Point combatPos) {
		this.combatPos = combatPos;
	}

	public Point getCombatPos() {
		return combatPos;
	}

	public void setcP(double cP) {
		this.cP = cP;
	}

	public double getcP() {
		return cP;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public Point getHealth() {
		return health;
	}

	public void setHealth(Point health) {
		this.health = health;
	}

	public Point getMana() {
		return mana;
	}

	public void setMana(Point mana) {
		this.mana = mana;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	
}
