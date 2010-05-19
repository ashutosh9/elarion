package game.field;

import java.awt.Image;

public class Terrain {

	private Image image;
	private boolean water;
	
	public Terrain(Image img){
		this.image = img;
		setWater(false);
	}
	
	public Terrain(Image img, boolean isWater){
		this.image = img;
		setWater(isWater);
	}

	public void setImg(Image img) {
		this.image = img;
	}

	public Image getImg() {
		return image;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isWater() {
		return water;
	}
	
}
