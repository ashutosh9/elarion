package game.field;

import java.awt.Image;
import java.awt.Toolkit;

import game.field.Square;

public class Field {
	
	private int height;
	private int width;
	private Square[][] s;
	private Terrain grass;
	//private Terrain water;
	//private Image grassImg;
	
	public Field(int width, int height){
		//Image waterImg = Toolkit.getDefaultToolkit().getImage("to be done");
		//grassImg = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg");
		//water.setImg(waterImg);
		Image grassImg = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass2.png");
		grass = new Terrain(grassImg);
		s = new Square[width][height];
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				s[x][y] = new Square(x,y); // if square == water - add new animation to animations array list
				s[x][y].setTerrain(grass);
				s[x][y].setTooltip("Grass");
				s[x][y].setPassable(true);
			}
		}
		
		for(int x=0; x<width; x++){
			for(int y=0; y<4; y++){
				s[x][y].setPassable(false);
			}
		}
		
		for(int x=0; x<width; x++){
			for(int y=(height-4); y<height; y++){
				s[x][y].setPassable(false);
			}
		}
		
		for(int x=0; x<4; x++){
			for(int y=0; y<height; y++){
				s[x][y].setPassable(false);
			}
		}
		
		for(int x=(width-4); x<width; x++){
			for(int y=0; y<height; y++){
				s[x][y].setPassable(false);
			}
		}
		
		this.height = height;
		this.width = width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void initImages(){
		@SuppressWarnings("unused")
		Image i = Toolkit.getDefaultToolkit().getImage("game/terrain/images/Grass1.jpg");
		//Image img2 = Toolkit.getDefaultToolkit().getImage("game/terrain/images/Water1.jpg");
		//etc
		//list and get all types of terrain images because that method is slooow
	}
	
	public Square getSquare(int x, int y) {
		return s[x][y];
	}
	
	public void setSquare(int x, int y,Square sq){
		s[x][y] = sq;
	}
	
}

