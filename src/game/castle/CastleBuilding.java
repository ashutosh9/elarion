package game.castle;

import game.main.Sprite;

public class CastleBuilding {
	protected Castle owner;
	protected boolean built;
	protected int x;
	protected int y;
	protected int w;//width
	protected int h;//height
	protected int goldcost;
	protected int woodcost;
	protected int stonecost;
	protected Sprite currentSprite;
	
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
}
