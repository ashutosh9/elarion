package game.field;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import game.field.Square;
import game.item.Item;
import game.resource.Resource;

public class Field {
	
	private int height;
	private int width;
	private Square[][] s;
	private Terrain grass;
	private SquareEvents events;
	//private Terrain water;
	//private Image grassImg;
	
	public Field(int width, int height){
		//Image waterImg = Toolkit.getDefaultToolkit().getImage("to be done");
		//grassImg = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg");
		//water.setImg(waterImg);
		Random generator = new Random(100);
		Image grassImg = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass2.jpg");
		grass = new Terrain(grassImg);
		grass.setName("Grass");
		setEvents(new SquareEvents());
		s = new Square[width][height];
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				int i = generator.nextInt(15);
				int a = generator.nextInt(20);
				int ga = generator.nextInt(1000);

				s[x][y] = new Square(x,y); // if square == water - add new animation to animations array list
				s[x][y].setTerrain(grass);
				s[x][y].setPassable(true);
				
				if(i==1){
					s[x][y].setResource(new Resource("gold",0,ga,Toolkit.getDefaultToolkit().getImage("src/game/images/resource/gold.png")));
				}
				if(i==2){
					s[x][y].setResource(new Resource("stone",0,a,Toolkit.getDefaultToolkit().getImage("src/game/images/resource/stone.png")));
				}
				if(i==3){
					s[x][y].setResource(new Resource("wood",0,a,Toolkit.getDefaultToolkit().getImage("src/game/images/resource/wood.png")));
				}
				if(i==4){
					s[x][y].setItem(new Item("chest", Toolkit.getDefaultToolkit().getImage("src/game/images/resource/chest.png")));
				}
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
	
	public Square getSquare(int x, int y) {
		return s[x][y];
	}
	
	public void setSquare(int x, int y,Square sq){
		s[x][y] = sq;
	}

	public void setEvents(SquareEvents events) {
		this.events = events;
	}

	public SquareEvents getEvents() {
		return events;
	}
	
}

