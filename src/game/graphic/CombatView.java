package game.graphic;

import game.field.Square;
import game.player.Player;
import game.unit.Hero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class CombatView {
	
	public Player playerInControl;
	public boolean combat;

	public CombatView(){
		combat = true;
	}
	
	public CombatView(Hero attacker, Hero defender,Square s) {
		
	}
	
	
	public void update(long timePassed){
		
	}
	
	public void draw(Graphics g){
		g.setColor(new Color(244));
		g.fillRect(0, 0, 1600, 1000);
		for(int x=0;x<16;x++){
			for(int y=0;y<9;y++){
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/battlefield/battle_tile.png"),x*80,y*80,null);
			}
		}
		
	}
	
	public boolean isCombat() {
		return combat;
	}

	public void setCombat(boolean combat) {
		this.combat = combat;
	}

	
}
