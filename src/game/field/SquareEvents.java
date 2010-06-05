package game.field;

import game.main.MainClass;
import game.player.Player;
import game.unit.Hero;

public class SquareEvents {
	
	public void pickUp(Square s, Hero h){
		if(s.getItem() != null ) {
			h.addItem(s.getItem());
			s.setItem(null);
		}
	}
	
	public void pickUpResource(Square s, Player p){
		if(s.getResource() != null ) {
			if(s.getResource().getName()=="gold") {
				p.getGold().addAmount(s.getResource().getAmount());
			} else if(s.getResource().getName()=="wood") {
				p.getWood().addAmount(s.getResource().getAmount());
			} else if(s.getResource().getName()=="stone") {
				p.getStone().addAmount(s.getResource().getAmount());
			}
			s.setResource(null);
		}
	}
	
	public void enterCastle(Square s, Player p, MainClass mc){
		if(s.getCastle()!=null) {
			System.out.print("stage1 pass\n");
			if (s.getCastle().getOwner() == p) {
				System.out.print("stage2 pass\n");
				System.out.print("stage3 pass\n");
				if (mc != null) { System.out.print("MC OK\n"); } else { System.out.print("MC fail\n");}
				mc.enterCastle(s.getCastle());
				System.out.print("stage4 pass, SquareEvent should be OK\n");
			}
		}
	}
	
}
