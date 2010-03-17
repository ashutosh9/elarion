package game.main;

import java.awt.Image;

public class Sprite {

	private Animation a;
	private float x;
	private float y;
	private float velocityX; //speed speed per time
	private float velocityY; //speed
	private float toMoveX; // the total distance it has to move 
	private float toMoveY; // the total distance it has to move 	
	private float movedX;
	private float movedY;
	private long timePassed;
	
	public Sprite(Animation a){
		this.a = a;
	}
	//add CHECK of something like if (sprite.getVelocityOfX == 0 && sprite.getVelocityOfY == 0){ sprite = null }
	public void update(long timePassed){
		this.timePassed += timePassed;
		if((toMoveX != 0) && (movedX >= toMoveX) || (toMoveX == 0)) {
			velocityX = 0;
		}
		if((toMoveY != 0) && (movedY >= toMoveY) || (toMoveY == 0)) {
			velocityY = 0;
		}
		x += velocityX * timePassed;
		movedX += velocityX * timePassed;
		y += velocityY * timePassed;
		movedY += velocityY * timePassed;
		a.update(timePassed);

	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void setVelocityOfX(float vx){
		velocityX = vx;
	}
	
	public void setVelocityOfY(float vy){
		velocityY = vy;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getVelocityOfX(){
		return velocityX;
	}
	
	public float getVelocityOfY(){
		return velocityY;
	}
	
	public Image getImage(){
		return a.getImage();
	}

	public void setToMoveX(float toMoveX) {
		this.toMoveX = toMoveX;
	}

	public float getToMoveX() {
		return toMoveX;
	}

	public void setToMoveY(float toMoveY) {
		this.toMoveY = toMoveY;
	}

	public float getToMoveY() {
		return toMoveY;
	}
	
	public int getWidth(){
		return a.getImage().getWidth(null);
	}
	
	public int getHeight(){
		return a.getImage().getHeight(null);
	}
	public void setAnimation(Animation a) {
		this.a = a;
	}
	public Animation getAnimation() {
		return a;
	}
	
}
