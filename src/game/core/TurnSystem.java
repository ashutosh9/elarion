package game.core;

import game.player.Player;
import game.player.Players;

public class TurnSystem{
	
	private int currentTurn;
	
	
	
	public TurnSystem(){
		
	}
	
	public void nextTurn(Players players){	
		if(players.getCurrentPlayer() == players.getPlayer(0)){
			currentTurn++;
		}
		//set all hero movement points to maximum
		//set current view
		players.getCurrentPlayer().getGold().addAmount(players.getCurrentPlayer().getGold().getIncome());
		players.getCurrentPlayer().getStone().addAmount(players.getCurrentPlayer().getGold().getIncome());
		players.getCurrentPlayer().getWood().addAmount(players.getCurrentPlayer().getGold().getIncome());
	}
	
	public int getCurrentTurn(){
		return currentTurn;
	}

}
