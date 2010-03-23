package game.unit;

import game.main.Animation;
import game.main.Sprite;

public class HeroMapMovementAnimations {
	
	private Sprite headingUpSprite;
	private Sprite headingDownSprite;
	private Sprite headingLeftSprite;
	private Sprite headingRightSprite;
	private Sprite headingUpRightSprite;
	private Sprite headingUpLeftSprite;
	private Sprite headingDownLeftSprite;
	private Sprite headingDownRightSprite;
	
	/*private Animation headingUpAnimation;
	private Animation headingDownAnimation;
	private Animation headingLeftAnimation;
	private Animation headingRightAnimation;
	private Animation headingUpRightAnimation;
	private Animation headingUpLeftAnimation;
	private Animation headingDownLeftAnimation;
	private Animation headingDownRightAnimation;*/
	
	private Hero h;
	private Sprite[] movementSprites;

	
	
	public HeroMapMovementAnimations(Hero h){
		this.h = h;
	}
	
	public void setMoveUpSprite(Animation a){
		//setup animation before adding it to the sprite
		headingUpSprite = new Sprite(a);
		headingUpSprite.setX(h.getHeroX());
		headingUpSprite.setY(h.getHeroY());
		movementSprites[1] = headingUpSprite;
	}
	
	public void setMoveDownSprite(Animation a){
		headingDownSprite = new Sprite(a);
		headingDownSprite.setX(h.getHeroX());
		headingDownSprite.setY(h.getHeroY());
		movementSprites[2] = headingDownSprite;
	}
	
	public void setMoveLeftSprite(Animation a){
		headingLeftSprite = new Sprite(a);
		headingLeftSprite.setX(h.getHeroX());
		headingLeftSprite.setY(h.getHeroY());
		movementSprites[3] = headingLeftSprite;
	}
	
	public void setMoveRightSprite(Animation a){
		headingRightSprite = new Sprite(a);
		headingRightSprite.setX(h.getHeroX());
		headingRightSprite.setY(h.getHeroY());
		movementSprites[4] = headingRightSprite;
	}
	
	public void setMoveUpLeftSprite(Animation a){
		headingUpLeftSprite = new Sprite(a);
		headingUpLeftSprite.setX(h.getHeroX());
		headingUpLeftSprite.setY(h.getHeroY());
		movementSprites[5] = headingUpLeftSprite;
	}
	
	public void setMoveUpRightSprite(Animation a){
		headingUpRightSprite = new Sprite(a);
		headingUpRightSprite.setX(h.getHeroX());
		headingUpRightSprite.setY(h.getHeroY());
		movementSprites[6] = headingUpRightSprite;
	}
	
	public void setMoveDownLeftSprite(Animation a){
		headingDownLeftSprite = new Sprite(a);
		headingDownLeftSprite.setX(h.getHeroX());
		headingDownLeftSprite.setY(h.getHeroY());
		movementSprites[7] = headingDownLeftSprite;
	}
	
	public void setMoveDownRightSprite(Animation a){
		headingDownRightSprite = new Sprite(a);
		headingDownRightSprite.setX(h.getHeroX());
		headingDownRightSprite.setY(h.getHeroY());
		movementSprites[8] = headingDownRightSprite;
	}
	
	public Sprite getMoveUpSprite(){
		return headingUpSprite;
	}
	
	public Sprite getMoveDownSprite(){
		return headingDownSprite;
	}
	
	public Sprite getMoveLeftSprite(){
		return headingLeftSprite;
	}
	
	public Sprite getMoveRightSprite(){
		return headingRightSprite;
	}
	
	public Sprite getMoveUpLeftSprite(){
		return headingUpLeftSprite;
	}
	
	public Sprite getMoveUpRightSprite(){
		return headingUpRightSprite;
	}
	
	public Sprite getMoveDownLeftSprite(){
		return headingDownLeftSprite;
	}
	
	public Sprite getMoveDownRightSprite(){
		return headingDownRightSprite;
	}
	
	public Sprite[] getSprites(){
		return movementSprites;
	}
	
}
