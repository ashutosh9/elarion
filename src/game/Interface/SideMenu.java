package game.Interface;

import game.castle.Castle;
import game.main.MainClass;
import game.unit.Hero;

import java.awt.Graphics;
import java.awt.Toolkit;


public class SideMenu {
	
	public void draw(Graphics g,MainClass mc){
		int h = 210;
		for(Hero hero : mc.getPlayers().getCurrentPlayer().getHeroes()){
			if(hero.isSelected()){
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero_selected.jpg"),(h-2),18,null);
			} else {
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),(h-2),18,null);
			}
			g.drawImage(hero.getIcon(),h,20,null);
			h += 40;
		}
		h = 210;
		for(Castle castle : mc.getPlayers().getCurrentPlayer().getCastles()){
			if(castle.isSelected()){
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero_selected.jpg"),(h-2),61,null);
			} else {
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),(h-2),61,null);
			}
			g.drawImage(castle.getIcon(),h,63,null);
			h += 40;
		}
	}
	
	
	
}
