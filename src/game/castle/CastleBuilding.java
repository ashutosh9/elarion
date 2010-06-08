package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
	Color grey = new Color(125,125,125);
	Color green = new Color(0,200,0);
	Color gold = new Color(255,221,47);
	Font font = new Font(Font.SERIF, Font.BOLD, 17);
	protected MainClass mc;
	protected String name;
	protected String description;
	
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
	
	public void setBuilt(boolean b) {
		built = b;
	}
	
	public void setUpgraded(boolean u) {
		upgraded = u;
	}
	
	public boolean isBuilt() {
		return built;
	}

	public boolean isUpgraded() {
		return upgraded;
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
	
	public void upgrade() {
		if (built && !upgraded) {
			if ((mc.getCurrentPlayer().getGold().getAmount() >= upgradegoldcost) && (mc.getCurrentPlayer().getWood().getAmount() >= upgradewoodcost) && (mc.getCurrentPlayer().getStone().getAmount() >= upgradestonecost)) {
				mc.getCurrentPlayer().getGold().removeAmount(upgradegoldcost);
				mc.getCurrentPlayer().getWood().removeAmount(upgradewoodcost);
				mc.getCurrentPlayer().getStone().removeAmount(upgradestonecost);
				upgraded = true;
				owner.setBuildLimit(owner.getBuildLimit()-1);
			}
		}
	}
	
	public void build() {
		if ((woodcost <= mc.getCurrentPlayer().getWood().getAmount()) && (stonecost <= mc.getCurrentPlayer().getStone().getAmount()) && (goldcost <= mc.getCurrentPlayer().getGold().getAmount()) && (!built)) {
			mc.getCurrentPlayer().getWood().removeAmount(woodcost);
			mc.getCurrentPlayer().getStone().removeAmount(stonecost);
			mc.getCurrentPlayer().getGold().removeAmount(goldcost);
			built = true;
			owner.setBuildLimit(owner.getBuildLimit()-1);
		}
	}
	
	public void update() {
	}

	public int getGold() {
		return goldcost;
	}
	
	public void setGold(int goldcost) {
		this.goldcost = goldcost;
	}
	
	public int getWood() {
		return woodcost;
	}
	
	public void setWood(int woodcost) {
		this.woodcost = woodcost;
	}
	
	public int getStone() {
		return stonecost;
	}
	
	public void setStone(int stonecost) {
		this.stonecost = stonecost;
	}
	
	public int getUpGold() {
		return upgradegoldcost;
	}
	
	public void setUpGold(int g) {
		upgradegoldcost = g;
	}
	
	public int getUpStone() {
		return upgradestonecost;
	}
	
	public void setUpStone(int g) {
		upgradestonecost = g;
	}
	
	public int getUpWood() {
		return upgradewoodcost;
	}
	
	public void setUpWood(int g) {
		upgradewoodcost = g;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int i) {
		index = i;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String s) {
		description = s;
	}
	
	public Point getTopLeft() {
		Point topLeft = new Point(x,y);
		return topLeft;
	}
	
	public Point getBottomRight() {
		Point bottomRight = new Point(x+w-1, y+h-1);
		return bottomRight;
	}
	
	public void drawMenu(Graphics g, CastleView castleView) {	
	}
	
	public void mousePressed(MouseEvent e, CastleView castleView) {
	}
}
