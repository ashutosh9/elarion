package game.battle;

import java.awt.Graphics;
import java.awt.Toolkit;

import game.player.Player;
import game.unit.Hero;
import game.unit.Unit;

public class Combat {
	
	public Hero attacker;
	public Hero defender;

	public Combat(Hero attacker , Hero defender,Player attacking,Player defending){
		
		for(Unit u : attacker.getUnits()){
			if(u.getType() == "Warrior"){
				u.getCombatStats().setcP(u.getCombatStats().getHealth().getX() +    
										 u.getCombatStats().getMana().getX() + 
										 u.getCombatStats().getStrenght() +  
										 u.getCombatStats().getDexterity()*1.5 +     
										 u.getCombatStats().getIntelligence()*2 +
										 u.getCombatStats().getInitiative()*10 +
										 u.getCombatStats().getCharisma());
			}else if(u.getType() == "Archer"){
				u.getCombatStats().setcP(u.getCombatStats().getHealth().getX() +    
						 				 u.getCombatStats().getMana().getY() + 
						 				 u.getCombatStats().getStrenght() +  
						 				 u.getCombatStats().getDexterity()*1.5 +     
						 				 u.getCombatStats().getIntelligence()*2 +
						 				 u.getCombatStats().getInitiative()*10 +
						 				 u.getCombatStats().getMovementpoints()*3 +
						 				 u.getCombatStats().getCharisma() + 50);
			}else if(u.getType() == "Mage"){
				u.getCombatStats().setcP(u.getCombatStats().getHealth().getX() +    
						 				 u.getCombatStats().getMana().getX() + 
						 				 u.getCombatStats().getStrenght() +  
						 				 u.getCombatStats().getDexterity()*1.5 +     
						 				 u.getCombatStats().getIntelligence()*2 +
						 				 u.getCombatStats().getInitiative()*10 +
						 				 u.getCombatStats().getMovementpoints()*3 +
						 				 u.getCombatStats().getCharisma() + 100);	
			}
			attacker.sethPower(attacker.gethPower()+u.getCombatStats().getcP());
		}
		for(Unit u : defender.getUnits()){
			if(u.getType() == "Warrior"){
				u.getCombatStats().setcP(u.getCombatStats().getHealth().getX() +    
										 u.getCombatStats().getMana().getX() + 
										 u.getCombatStats().getStrenght() +  
										 u.getCombatStats().getDexterity()*1.5 +     
										 u.getCombatStats().getIntelligence()*2 +
										 u.getCombatStats().getInitiative()*10 +
										 u.getCombatStats().getMovementpoints()*3 +
										 u.getCombatStats().getCharisma());
			}else if(u.getType() == "Archer"){
				u.getCombatStats().setcP(u.getCombatStats().getHealth().getX() +    
						 				 u.getCombatStats().getMana().getY() + 
						 				 u.getCombatStats().getStrenght() +  
						 				 u.getCombatStats().getDexterity()*1.5 +     
						 				 u.getCombatStats().getIntelligence()*2 +
						 				 u.getCombatStats().getInitiative()*10 +
						 				 u.getCombatStats().getMovementpoints()*3 +
						 				 u.getCombatStats().getCharisma() + 50);
			}else if(u.getType() == "Mage"){
				u.getCombatStats().setcP(u.getCombatStats().getHealth().getX() +    
						 				 u.getCombatStats().getMana().getX() + 
						 				 u.getCombatStats().getStrenght() +  
						 				 u.getCombatStats().getDexterity()*1.5 +     
						 				 u.getCombatStats().getIntelligence()*2 +
						 				 u.getCombatStats().getInitiative()*10 +
						 				 u.getCombatStats().getMovementpoints()*3 +
						 				 u.getCombatStats().getCharisma() + 100);
			}
			defender.sethPower(defender.gethPower()+u.getCombatStats().getcP());
		}
		
		if(attacker.gethPower() > defender.gethPower()){
			for(Unit u : defender.getUnits() ){
				defender.removeUnit(u);
				defending.removeHero(defender);
			}
		}
		if(defender.gethPower() > attacker.gethPower()){
			for(Unit u : attacker.getUnits() ){
				attacker.removeUnit(u);
				attacking.removeHero(attacker);
			}
		}
	
	}
	
	public void draw(Graphics g){
		if(attacker.gethPower() > defender.gethPower()){
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/Combat/AttackerWin.png"),500,300,null);
		}else{
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Image/Combat/DefenderWin.png"),500,300,null);
		}
	}
}
