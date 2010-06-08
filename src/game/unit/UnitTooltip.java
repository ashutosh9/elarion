package game.unit;

import java.awt.Image;
import java.awt.Toolkit;

import game.Interface.Tooltip;
import game.main.MainClass;

public class UnitTooltip extends Tooltip {

	public UnitTooltip(MainClass mc,Unit u) {
		super(mc);
		
		Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		this.newImg(img, 3, 3);
		
		img = u.getIcon().getScaledInstance(56, 56, 1);
		this.newImg(img, 5, 5);
		
		String s = u.getName();
		if(s == null){
			s = "";
		}
		
		this.newText(s, 70, 30);
		s = new String("XP : " + u.getExperience().x + " / " + u.getExperience().y);
		this.newText(s, 70, 45);
		
		s = new String("Level : " + u.getLevel());
		this.newText(s, 70, 60);
		
		s = new String("Init : " + u.getCombatStats().getInitiative());
		this.newText(s, 20, 100);
		s = new String("MP : " + u.getMovementPoints() / 10);
		this.newText(s, 20, 115);
		
		s = new String("Health : " + u.getCombatStats().getHealth().x + "/" + u.getCombatStats().getHealth().y);
		this.newText(s, 20, 155);
		s = new String("Mana : " + u.getCombatStats().getMana().x + "/" + u.getCombatStats().getMana().y);
		this.newText(s, 20, 170);
		
		s = new String("Str : " + u.getCombatStats().getStrenght());
		this.newText(s, 180, 70);
		s = new String("Con : " + u.getCombatStats().getConstitution());
		this.newText(s, 180, 85);
		
		s = new String("Dex : " + u.getCombatStats().getDexterity());
		this.newText(s, 180, 115);
		s = new String("Int : " + u.getCombatStats().getIntelligence());
		this.newText(s, 180, 130);

		s = new String("Wis : " + u.getCombatStats().getWisdom());
		this.newText(s, 180, 160);
		s = new String("Cha : " + u.getCombatStats().getCharisma());
		this.newText(s, 180, 175);
		
		
		
	}

}
