package game.field;

import game.item.ChestPopupWindow;
import game.main.MainClass;
import game.player.Player;
import game.unit.Hero;

public class SquareEvents {
	
	public void pickUp(Square s, Hero h,MainClass mc){
		if(s.getItem() != null ) {
			if(s.getItem().getType() == "chest"){
				mc.setPopupWindow(new ChestPopupWindow(mc,mc.getCurrentPlayer()));
				s.setItem(null);
			} else {
				h.addItem(s.getItem());
				s.setItem(null);
			}
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
			if (s.getCastle().getOwner() == p) {
				mc.clearPath();
				mc.enterCastle(s.getCastle());
			}
		}
	}
	
	public void enterBuilding(Square s, Player p, MainClass mc) {
		if(s.getBuilding()!= null) {
			mc.clearPath();
			s.getBuilding().setOwner(s.getHero().getOwner());
			mc.setCurrentBuilding(s.getBuilding());
		}
	}
	
}
