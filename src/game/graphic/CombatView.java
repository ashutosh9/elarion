package game.graphic;

import game.battle.BattleField;
import game.field.Square;
import game.player.Player;
import game.unit.Hero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class CombatView {
	
	public Player playerInControl;
	public boolean combat;
	public Hero attacker;
	public Hero defender;
	public Square square;
	public BattleField bf;

	public CombatView(){
		combat = true;
		bf = new BattleField();
	}
	
	public CombatView(Hero attacker, Hero defender,Square s) {
		this.attacker = attacker;
		this.defender = defender;
		square = s;
		combat = true;
		bf = new BattleField();
	}
	
	
	public void update(long timePassed){
		
	}
	
	public void draw(Graphics g){
		g.setColor(new Color(244));
		g.fillRect(0, 0, 1600, 1000);
		for(int x=0;x<16;x++){
			for(int y=0;y<9;y++){
				Image i = bf.getTile(x, y).getTerrain().getImg();
				g.drawImage(i,x*80,y*80,null);
			}
		}
		for(int x=0;x<16;x++){
			for(int y=0;y<9;y++){
				if(bf.getTile(x,y).getUnit() != null) {
					Image i;
					if(bf.getTile(x,y).getUnit().getCombatHeading() == 1) {
						i = bf.getTile(x, y).getUnit().getGraphicalData().getBattleFieldStandRight().getImage();
					} else {
						i = bf.getTile(x, y).getUnit().getGraphicalData().getBattleFieldStandLeft().getImage();
					} 
					g.drawImage(i,x*80,y*80,null);
				}
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
