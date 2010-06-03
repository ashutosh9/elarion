package game.battle;

import game.field.Terrain;

import java.awt.Image;
import java.awt.Toolkit;

public class BattleField {
	
	private int height = 9;
	private int width = 16;
	private BattleTile[][] b;
	private Terrain grass;
	//private Terrain water;
	//private Image grassImg;
	
	public BattleField(){
		Image grassImg = Toolkit.getDefaultToolkit().getImage("Images/battlefield/battle_tile.png");
		grass = new Terrain(grassImg);
		b = new BattleTile[width][height];
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				b[x][y] = new BattleTile(x,y); 
				b[x][y].setTerrain(grass);
				b[x][y].setPassable(true);
			}
		}
	}
	
	
	public BattleTile getTile(int x, int y){
		return b[x][y];
	}
	


}
