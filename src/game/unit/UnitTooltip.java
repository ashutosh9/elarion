package game.unit;

import game.Interface.Tooltip;
import game.main.MainClass;

public class UnitTooltip extends Tooltip {

	public UnitTooltip(MainClass mc,Unit u) {
		super(mc);
		
		String s = u.getName();
		
		this.newText(s, 100, 50);
		s = new String("XP : " + u.getExperience().x + " / " + u.getExperience().y);
		this.newText(s, 100, 80);
		
		s = new String("Level : " + u.getLevel());
		this.newText(s, 455, 80);
		
		s = new String("Strenght : " + u.getCombatStats().getStrenght());
		this.newText(s, 455, 110);
		s = new String("Constitution : " + u.getCombatStats().getConstitution());
		this.newText(s, 455, 130);
		
		s = new String("Dexterity : " + u.getCombatStats().getDexterity());
		this.newText(s, 455, 160);
		s = new String("Intelligence : " + u.getCombatStats().getIntelligence());
		this.newText(s, 455, 180);

		s = new String("Wisdom : " + u.getCombatStats().getWisdom());
		this.newText(s, 455, 210);
		s = new String("Charisma : " + u.getCombatStats().getCharisma());
		this.newText(s, 455, 230);
		
		s = new String("Initiative : " + u.getCombatStats().getInitiative());
		this.newText(s, 455, 260);
		s = new String("Movement Points : " + u.getMovementPoints() / 10);
		this.newText(s, 455, 280);
		
		s = new String("Health : " + u.getCombatStats().getHealth().x + "/" + u.getCombatStats().getHealth().y);
		this.newText(s, 455, 310);
		s = new String("Mana : " + u.getCombatStats().getMana().x + "/" + u.getCombatStats().getMana().y);
		this.newText(s, 455, 330);
		
	}

}
