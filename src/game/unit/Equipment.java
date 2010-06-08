package game.unit;

import java.util.ArrayList;

import game.item.Item;

public class Equipment {
	
	private Item head;
	private Item legs;
	private Item armor;
	private Item feet;
	private Item leftHand;
	private Item rightHand;
	private Item ring1;
	private Item ring2;
	private Item neck;
	private Item gloves;
	private Item bracers;
	private ArrayList<Item> equipment;
	
	public Equipment(){
		head = null;
		legs = null;
		armor = null;
		feet = null;
		leftHand = null;
		rightHand = null;
		ring1 = null;
		ring2 = null;
		neck = null;
		gloves = null;
		bracers = null;
		equipment = new ArrayList<Item>();
		equipment.add(head);
		equipment.add(legs);
		equipment.add(armor);
		equipment.add(feet);
		equipment.add(leftHand);
		equipment.add(rightHand);
		equipment.add(ring1);
		equipment.add(ring2);
		equipment.add(neck);
		equipment.add(gloves);
		equipment.add(bracers);
	}
	
	public void equip(Item i, ArrayList<Item> inventory){
		
		if(i.getType() == "head"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(head != null){
				inventory.add(0,head);
				head = null;
			}
			head = i;
		}
		
		if(i.getType() == "legs"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(legs != null){
				inventory.add(0,legs);
				legs = null;
			}
			legs = i;
		}
		
		if(i.getType() == "armor"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(armor != null){
				inventory.add(0, armor);
				armor = null;
			}
			armor = i;
		}
		
		if(i.getType() == "feet"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(feet != null){
				inventory.add(0,feet);
				feet = null;
			}
			feet = i;
		}
		
		if(i.getType() == "leftHand"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(leftHand != null){
				inventory.add(0,leftHand);
				leftHand = null;
			}
			leftHand = i;
		}
		
		if(i.getType() == "rightHand"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(rightHand != null){
				inventory.add(0,rightHand);
				rightHand = null;
			}
			rightHand = i;
		}
		
		if(i.getType() == "neck"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(neck != null){
				inventory.add(0,neck);
				neck = null;
			}
			neck = i;
		}
		
		if(i.getType() == "gloves"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(gloves != null){
				inventory.add(0,gloves);
				gloves = null;
			}
			gloves = i;
		}
		
		if(i.getType() == "bracers"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(bracers != null){
				inventory.add(0,bracers);
				bracers = null;
			}
			bracers = i;
		}
		
		if(i.getType() == "ring"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(ring1 == null){
				ring1 = i;
			} else {
				if(ring2 != null){
					inventory.add(0,ring2);
					ring2 = null;
				}
				ring2 = i;
			}
		}
		
	}
	
	public void equip(Item i, ArrayList<Item> inventory, String type){
		
		if(type == "head"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(head != null){
				inventory.add(0,head);
				head = null;
			}
			head = i;
		}
		
		if(type == "legs"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(legs != null){
				inventory.add(0,legs);
				legs = null;
			}
			legs = i;
		}
		
		if(type == "armor"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(armor != null){
				inventory.add(0, armor);
				armor = null;
			}
			armor = i;
		}
		
		if(type == "feet"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(feet != null){
				inventory.add(0,feet);
				feet = null;
			}
			feet = i;
		}
		
		if(type == "leftHand"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(leftHand != null){
				inventory.add(0,leftHand);
				leftHand = null;
			}
			leftHand = i;
		}
		
		if(type == "rightHand"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(rightHand != null){
				inventory.add(0,rightHand);
				rightHand = null;
			}
			rightHand = i;
		}
		
		if(type == "neck"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(neck != null){
				inventory.add(0,neck);
				neck = null;
			}
			neck = i;
		}
		
		if(type == "gloves"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(gloves != null){
				inventory.add(0,gloves);
				gloves = null;
			}
			gloves = i;
		}
		
		if(type == "bracers"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(bracers != null){
				inventory.add(0,bracers);
				bracers = null;
			}
			bracers = i;
		}
		
		if(type == "ring1"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(ring1 != null){
				inventory.add(0,ring1);
				ring1 = null;
			}
			ring1 = i;
		}
		
		if(type == "ring2"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(ring2 != null){
				inventory.add(0,ring2);
				ring2 = null;
			}
			ring2 = i;
		}
		
	}

	public Item getHead() {
		return head;
	}

	public void setHead(Item head) {
		this.head = head;
	}

	public Item getLegs() {
		return legs;
	}

	public void setLegs(Item legs) {
		this.legs = legs;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getFeet() {
		return feet;
	}

	public void setFeet(Item feet) {
		this.feet = feet;
	}

	public Item getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(Item leftHand) {
		this.leftHand = leftHand;
	}

	public Item getRightHand() {
		return rightHand;
	}

	public void setRightHand(Item rightHand) {
		this.rightHand = rightHand;
	}

	public Item getRing1() {
		return ring1;
	}

	public void setRing1(Item ring1) {
		this.ring1 = ring1;
	}

	public Item getRing2() {
		return ring2;
	}

	public void setRing2(Item ring2) {
		this.ring2 = ring2;
	}

	public Item getNeck() {
		return neck;
	}

	public void setNeck(Item amulet) {
		this.neck = amulet;
	}

	public Item getGloves() {
		return gloves;
	}

	public void setGloves(Item gloves) {
		this.gloves = gloves;
	}

	public Item getBracers() {
		return bracers;
	}

	public void setBracers(Item bracers) {
		this.bracers = bracers;
	}

	public void setEquipment(ArrayList<Item> equipment) {
		this.equipment = equipment;
	}

	public ArrayList<Item> getEquipment() {
		return equipment;
	}

}
