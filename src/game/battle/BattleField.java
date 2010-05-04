package game.battle;

import game.field.Square;
import game.field.Terrain;

import java.awt.Image;
import java.awt.Toolkit;

public class BattleField {
	
	private int height = 15;
	private int width = 25;
	private BattleTile[][] b;
	private Terrain grass;
	//private Terrain water;
	//private Image grassImg;
	
	public BattleField(){
		//Image waterImg = Toolkit.getDefaultToolkit().getImage("to be done");
		//grassImg = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg");
		//water.setImg(waterImg);
		Image grassImg = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass2.png");
		grass = new Terrain(grassImg);
		b = new BattleTile[width][height];
		for(int x=1; x<width; x++) {
			for(int y=1; y<height; y++) {
				b[x][y] = new BattleTile(x,y); // if square == water - add new animation to animations array list
				b[x][y].setTerrain(grass);
				b[x][y].setPassable(true);
			}
		}
		
	}


}
