package game.graphic;

import game.main.Animation;
import game.main.Sprite;

import java.util.ArrayList;

public class AnimationConatiner {
	
	ArrayList<Animation> animations = new ArrayList<Animation>();
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	public void addAnimation(Animation a){
		animations.add(a);
	}
	
	public void addSprite(Sprite s){
		sprites.add(s);
	}
	
	
}
