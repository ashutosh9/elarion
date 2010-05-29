package game.castle;

import game.main.Sprite;

public class CastleBuilding {

	protected boolean built;
	protected int x;
	protected int y;
	protected int w;//width
	protected int h;//height
	protected Sprite currentSprite;
	
	public void build()	{
		built = true;
	}
	
	public void destroy() {
			built = false;
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
	
	public void Update() {
	}
}
