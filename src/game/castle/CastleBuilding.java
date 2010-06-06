package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;

import java.awt.Color;
import java.awt.Font;
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
	protected int upgradegoldcost;
	protected int upgradestonecost;
	protected int upgradewoodcost;
	protected int index;
	protected boolean upgraded;
	Color white = new Color(255, 255, 255);
	Color black = new Color(0,0,0);
	Font font = new Font(Font.SERIF, Font.BOLD, 17);
	protected MainClass mc;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public CastleBuilding (Castle owner, MainClass mc) {
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
	
	public void upgrade() {
	}
	
	public void drawMenu(Graphics g, CastleView castleView) {	
	}
	
	public void mousePressed(MouseEvent e, CastleView castleView) {
	}
}
