package game.core;

import java.util.ArrayList;
import java.util.EventListener;

import game.player.Player;

public class TurnSystem extends Thread implements EventListener{
	
	private Player currentPlayer;
	private int currentTurn;
	@SuppressWarnings("unused")
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private int i = 1;
	private boolean turnInProgress;
	private boolean gameInProgress;
	//add players to collection
	
	
	
	public TurnSystem(ArrayList<Player> playerList){
		this.playerList = playerList;
		turnInProgress = true;
		gameInProgress = true;
		
		this.start();
		while(gameInProgress){
			setCurrentPlayer(playerList.get(i));
			if(i<playerList.size()) {
				i++;
			} else {
				i = 0;
			}
			//changePlayer();
			//loadData();
			currentTurn++;
			turnInProgress = true;
		}
		//end game events;
	}

	public void setCurrentPlayer(Player currentPlayer){
		this.currentPlayer = currentPlayer;
	}

	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public void endTurn(){
		turnInProgress = false;
	}
	
	public void endGame(){
		gameInProgress = false;
	}
	
	
	

}
