package game.player;

import game.field.Field;

import java.util.ArrayList;

public class Players {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Players(int i,Field field){
		for(int j = 0; j < i; j++){

			String name = "Player " + (j+1);
			Player p = new Player(name);
			p.getGold().setAmount(5000);
			p.getWood().setAmount(50);
			p.getStone().setAmount(50);
			p.setCurrentView(field.getSquare(2, 2));
			p.setCurrentViewAbsX(0);
			p.setCurrentViewAbsY(0);
			players.add(p);

		}
		players.get(0).setCurrentPlayer(true);
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
	
	public void nextPlayer(){
		int i = 0;
		for(Player p : players){
			if(p.isCurrentPlayer()){
				p.setCurrentPlayer(false);
				i = players.indexOf(p);
				i++;
				if(i==players.size()){
					i=0;
				}
				break;
			}
		}
		players.get(i).setCurrentPlayer(true);
	}
	
	public Player getCurrentPlayer(){
		int i = 0;
		for(Player p : players){
			if(p.isCurrentPlayer()){
				i = players.indexOf(p);
			}
		}
		return players.get(i);
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	

}
