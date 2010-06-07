package game.core;

import game.castle.Castle;
import game.field.Field;
import game.player.Player;
import game.player.Players;
import game.unit.Hero;

public class TurnSystem{
	
	private int currentTurn;
	
	
	
	public TurnSystem(){
		currentTurn = 0;
	}
	
	public void nextTurn(Players players,Field f){	
		if(players.getCurrentPlayer() == players.getPlayer(0)){
			currentTurn++;
			for(Player p :players.getPlayers()) {
				for (Castle c : p.getCastles()) {
					c.turnUpdate();
				}
			}
		}
		//set all hero movement points to maximum
		//set current view
		players.getCurrentPlayer().getGold().addAmount(players.getCurrentPlayer().getGold().getIncome());
		players.getCurrentPlayer().getStone().addAmount(players.getCurrentPlayer().getGold().getIncome());
		players.getCurrentPlayer().getWood().addAmount(players.getCurrentPlayer().getGold().getIncome());
		
		for(int i = 0; i < f.getWidth() ; i ++){
			for(int j = 0; j < f.getHeight() ; j ++){
				f.getSquare(i, j).setPath(false);
			}
		}
		
		for(Hero h : players.getCurrentPlayer().getHeroes()) {
			if(h.getPath() != null){
				h.getPath().setAutoMoving(false);
				h.setPath(null);
			}
			h.refillMovementPoints();
		}
		
	}
	
	public int getCurrentTurn(){
		return currentTurn;
	}

}
