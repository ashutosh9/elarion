package game.unit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import game.Interface.PopupWindow;
import game.main.MainClass;

public class LevelPopupWindow extends PopupWindow{

	private Unit unit;
	private String bonus1;
	private String bonus2;
	private boolean levelPopupWindow;
	
	public LevelPopupWindow(MainClass mc,Unit u) {
		super(mc);
		setLevelPopupWindow(true);
		setUnit(u);
		this.newChoice(" ","close", 700, 500, Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_pressed.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_hovered.jpg"));
		Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		this.newImg(img, 33, 33);
		img = u.getIcon().getScaledInstance(56, 56, 1);
		this.newImg(img, 35, 35);
		String s = u.getName();
		this.newText(s, 100, 50);
		s = new String("XP : " + u.getExperience().x + " / " + u.getExperience().y);
		this.newText(s, 100, 80);
		s = new String("Level : " + u.getLevel());
		this.newText(s, 100, 110);
		img = Toolkit.getDefaultToolkit().getImage("Images/popup/level_up.png");
		this.newImg(img, 200, 100);
		
		getRandomStats();
		
		
		
	}
	
	public void draw(Graphics g){
		
		super.draw(g);
		String s = new String();
		if(bonus1==bonus2){
			s = new String("Increased " + bonus1 + " by 2 points!");
			g.drawString(s, 270 + this.getX(), 320 + this.getY());
		} else {
			s = new String("Increased " + bonus1 + " by 1 points!");
			g.drawString(s, 270 + this.getX(), 320 + this.getY());
			s = new String("Increased " + bonus2 + " by 1 points!");
			g.drawString(s, 270 + this.getX(), 340 + this.getY());
		}
		
	}
	
	public void getRandomStats(){
		Random random = new Random();
		
		int i = random.nextInt(6);
		
		if(i == 0){
			getUnit().getCombatStats().setCharisma(getUnit().getCombatStats().getCharisma() + 1);
			bonus1 = "charisma";
		}
		if(i == 1){
			getUnit().getCombatStats().setStrenght(getUnit().getCombatStats().getStrenght() + 1);
			getUnit().getCombatStats().setMaximumHealth(getUnit().getCombatStats().getHealth().y + 10);
			getUnit().getCombatStats().setCurrentHealth(getUnit().getCombatStats().getMaximumHealth());
			
			bonus1 = "strenght";
		}
		if(i == 2){
			getUnit().getCombatStats().setWisdom(getUnit().getCombatStats().getWisdom() + 1);
			bonus1 = "wisdom";
		}
		if(i == 3){
			getUnit().getCombatStats().setConstitution(getUnit().getCombatStats().getConstitution() + 1);
			bonus1 = "constitution";
		}
		if(i == 4){
			getUnit().getCombatStats().setDexterity(getUnit().getCombatStats().getDexterity() + 1);
			getUnit().getCombatStats().setInitiative(getUnit().getCombatStats().getInitiative() + 1);
			bonus1 = "dexterity";
		}
		if(i == 5){
			getUnit().getCombatStats().setIntelligence(getUnit().getCombatStats().getIntelligence() + 1);
			getUnit().getCombatStats().setMaximumMana(getUnit().getCombatStats().getMana().y + 10);
			getUnit().getCombatStats().setCurrentMana(getUnit().getCombatStats().getMaximumMana());
			bonus1 = "intelligence";
		}
		
		i = random.nextInt(6);
		
		if(i == 0){
			getUnit().getCombatStats().setCharisma(getUnit().getCombatStats().getCharisma() + 1);
			bonus2 = "charisma";
		}
		if(i == 1){
			getUnit().getCombatStats().setStrenght(getUnit().getCombatStats().getStrenght() + 1);
			getUnit().getCombatStats().setMaximumHealth(getUnit().getCombatStats().getHealth().y + 10);
			getUnit().getCombatStats().setCurrentHealth(getUnit().getCombatStats().getMaximumHealth());
			bonus2 = "strenght";
		}
		if(i == 2){
			getUnit().getCombatStats().setWisdom(getUnit().getCombatStats().getWisdom() + 1);
			bonus2 = "wisdom";
		}
		if(i == 3){
			getUnit().getCombatStats().setConstitution(getUnit().getCombatStats().getConstitution() + 1);
			bonus2 = "constitution";
		}
		if(i == 4){
			getUnit().getCombatStats().setDexterity(getUnit().getCombatStats().getDexterity() + 1);
			getUnit().getCombatStats().setInitiative(getUnit().getCombatStats().getInitiative() + 1);
			bonus2 = "dexterity";
		}
		if(i == 5){
			getUnit().getCombatStats().setIntelligence(getUnit().getCombatStats().getIntelligence() + 1);
			getUnit().getCombatStats().setMaximumMana(getUnit().getCombatStats().getMana().y + 10);
			getUnit().getCombatStats().setCurrentMana(getUnit().getCombatStats().getMaximumMana());
			bonus2 = "intelligence";
		}
		
		getUnit().getCombatStats().setMaximumMana(getUnit().getCombatStats().getMana().y + (getUnit().getLevel()/2)*20);
		getUnit().getCombatStats().setCurrentMana(getUnit().getCombatStats().getMaximumMana());
		getUnit().getCombatStats().setMaximumHealth(getUnit().getCombatStats().getHealth().y + (getUnit().getLevel()/2)*10);
		getUnit().getCombatStats().setCurrentHealth(getUnit().getCombatStats().getMaximumHealth());

		
	}

	public void setLevelPopupWindow(boolean levelPopupWindow) {
		this.levelPopupWindow = levelPopupWindow;
	}

	public boolean isLevelPopupWindow() {
		return levelPopupWindow;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Unit getUnit() {
		return unit;
	}
	
}
