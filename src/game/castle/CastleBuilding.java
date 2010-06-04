package game.castle;

import game.graphic.CastleView;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

public class CastleBuilding {
	protected Image image;
	protected int x;
	protected int y;
	protected int w;//width
	protected int h;//height
	protected Castle owner;
	protected boolean built;
	protected int goldcost;
	protected int woodcost;
	protected int stonecost;
	protected int index;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public CastleBuilding (Castle owner) {
		built = false;
		this.owner = owner;
	}
	
	public void modBuilt(boolean b) {
		built = b;
	}
	
	public boolean isBuilt() {
		return built;
	}

	public void setLoc(int x, int y) {
			this.x = x;
			this.y = y;
	}
	
	public int getX(){
		return x;	
	}
	
	public int getY(){
		return y;
	}

	public void setSize(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public int getW() {
		return w;
	}
	
	public int getH() {
		return h;
	}
	
	public void update() {
	}

	public int getgold() {
		return goldcost;
	}
	
	public void setgold(int goldcost) {
		this.goldcost = goldcost;
	}
	
	public int getwood() {
		return woodcost;
	}
	
	public void setwood(int woodcost) {
		this.woodcost = woodcost;
	}
	
	public int getstone() {
		return stonecost;
	}
	
	public void setstone(int stonecost) {
		this.stonecost = stonecost;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int i) {
		index = i;
	}
	
	public void drawMenu(Graphics g, CastleView castleView) {	
	}
}
