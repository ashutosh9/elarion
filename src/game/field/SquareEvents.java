package game.field;

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
	
}
