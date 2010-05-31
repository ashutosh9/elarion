package game.graphic;

import game.battle.BattleField;
import game.core.BattleSystem;
import game.field.Square;
import game.player.Player;
import game.unit.Hero;
import game.unit.Unit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CombatView {
	
	public Player playerInControl;
	public boolean combat;
	public Hero attacker;
	public Hero defender;
//	public Square square;
	public BattleField bf;
	public BattleSystem bs;

	public CombatView(){
		combat = true;
		bf = new BattleField();
	}
	
	public CombatView(Hero attacker, Hero defender) {
		this.attacker = attacker;
		this.defender = defender;
		combat = true;
		bf = new BattleField();
		
//		for(Unit u : attacker.getUnits()){
//			long x = Math.round(u.getCombatStats().getCombatPos().getX());
//			long y = Math.round(u.getCombatStats().getCombatPos().getY());
//			//long in = Math.round(u.getCombatStats().getInitiative());
//			
//			for(int i=0;i<2;i++){
//				for(int j=0;j<9;j++){
//					if(u.getCombatStats().getCombatPos().getX() == i && u.getCombatStats().getCombatPos().getY() == j){
//						u.setCombatHeading(1);
//						bf.getTile(i, j).setUnit(u);
//						bf.getTile(i, j).setPassable(false);
//					}
//				}
//			}
//			if(x == 16 && y == 8) {
//				boolean set=false;
//				for(int i=0;i<2;i++){
//					for(int j=0;j<9;j++){
//						if(bf.getTile(i, j).isPassable() && !set){
//							u.setCombatHeading(1);
//							bf.getTile(i, j).setUnit(u);
//							bf.getTile(i, j).setPassable(false);
//							set = true;
//						}
//					}
//				}
//			}
//			
//			
//		}
//		
//		for(Unit u : defender.getUnits()){
//			long x = Math.round(u.getCombatStats().getCombatPos().getX());
//			long y = Math.round(u.getCombatStats().getCombatPos().getY());
//			//long in = Math.round(u.getCombatStats().getInitiative());
//			
//			for(int i=15;i>13;i--){
//				for(int j=0;j<9;j++){
//					if(u.getCombatStats().getCombatPos().getX() == i && u.getCombatStats().getCombatPos().getY() == j){
//						u.setCombatHeading(2);
//						bf.getTile(i, j).setUnit(u);
//						bf.getTile(i, j).setPassable(false);
//					}
//				}
//			}
//			
//			if(x == 16 && y == 8) {
//				for(int i=15;i>13;i--){
//					boolean set=false;
//					for(int j=0;j<9;j++){
//						if(bf.getTile(i, j).isPassable()){
//							u.setCombatHeading(2);
//							bf.getTile(i, j).setUnit(u);
//							bf.getTile(i, j).setPassable(false);
//							set = true;
//							break;
//						}
//					}
//					if(set){
//						break;
//					}
//				}
//			}
//			
//			
//		}
		
		
	}
	
	
//	public void update(long timePassed){
//		
//	}
//	
//	public void draw(Graphics g){
//		g.setColor(new Color(244));
//		g.fillRect(0, 0, 1600, 1000);
//		for(int x=0;x<16;x++){
//			for(int y=0;y<9;y++){
//				Image i = bf.getTile(x, y).getTerrain().getImg();
//				g.drawImage(i,x*80,y*80,null);
//			}
//		}
//		for(int x=0;x<16;x++){
//			for(int y=0;y<9;y++){
//				if(bf.getTile(x,y).getUnit() != null) {
//					Image i;
//					if(bf.getTile(x,y).getUnit().getCombatHeading() == 1) {
//						i = bf.getTile(x, y).getUnit().getGraphicalData().getBattleFieldStandRight().getImage();
//					} else {
//						i = bf.getTile(x, y).getUnit().getGraphicalData().getBattleFieldStandLeft().getImage();
//					}
//					g.drawImage(i,x*80,y*80,null);
//				}
//			}
//		}
//		
//		
//	}
	
	public boolean isCombat() {
		return combat;
	}

	public void setCombat(boolean combat) {
		this.combat = combat;
	}
	
	public void MouseClicked(MouseEvent e){
		
	}
}
