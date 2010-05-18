package game.graphic;

import game.field.Square;
import game.player.Player;
import game.unit.Hero;

import java.awt.Graphics;
import java.awt.Toolkit;

public class CombatView {
	
	public Player playerInControl;
	
	public CombatView(Hero attacker, Hero defender,Square s) {
		
	}
	
	
	public void update(long timePassed){
		
	}
	
	public void draw(Graphics g){
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/battlefield/battle_tile.png"),45,46,null);
	}
	
}
