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
	private Item amulet;
	private Item gloves;
	private Item bracers;
	
	public Equipment(){
		head = null;
		legs = null;
		armor = null;
		feet = null;
		leftHand = null;
		rightHand = null;
		ring1 = null;
		ring2 = null;
		amulet = null;
		gloves = null;
		bracers = null;
	}
	
	public void equip(Item i, ArrayList<Item> inventory){
		
		if(i.getType() == "head"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(head != null){
				inventory.add(head);
				head = null;
			}
			head = i;
		}
		
		if(i.getType() == "legs"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(legs != null){
				inventory.add(legs);
				legs = null;
			}
			legs = i;
		}
		
		if(i.getType() == "armor"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(armor != null){
				inventory.add(armor);
				armor = null;
			}
			armor = i;
		}
		
		if(i.getType() == "feet"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(feet != null){
				inventory.add(feet);
				feet = null;
			}
			feet = i;
		}
		
		if(i.getType() == "leftHand"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(leftHand != null){
				inventory.add(leftHand);
				leftHand = null;
			}
			leftHand = i;
		}
		
		if(i.getType() == "rightHand"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(rightHand != null){
				inventory.add(rightHand);
				rightHand = null;
			}
			rightHand = i;
		}
		
		if(i.getType() == "amulet"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(amulet != null){
				inventory.add(amulet);
				amulet = null;
			}
			amulet = i;
		}
		
		if(i.getType() == "gloves"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(gloves != null){
				inventory.add(gloves);
				gloves = null;
			}
			gloves = i;
		}
		
		if(i.getType() == "bracers"){
			if(inventory.contains(i)){
				inventory.remove(inventory.indexOf(i));
			}
			if(bracers != null){
				inventory.add(bracers);
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
					inventory.add(ring2);
					ring2 = null;
				}
				ring2 = i;
			}
		}
		
	}

}
