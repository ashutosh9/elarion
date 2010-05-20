package game.player;

import java.util.ArrayList;

public class Players {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player currentPlayer;
	
	public Players(int i){
		for(int j = 0; j < i; j++){
			String name = "Player " + (j+1);
			players.add(new Player(name));
		}
		currentPlayer = players.get(0);
	}
	
	public Player getPlayer(int i){
		return players.get(i);
	}
	
	public Player getPlayer(String s){
		for(Player player : players) {
			if(player.getName() == s){
				return player;
			}
		}
		return null;
	}
	

}
