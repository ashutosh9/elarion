package game.Interface;

import java.awt.Image;
import java.awt.Toolkit;

import game.main.Animation;

public class MainMenu {
	
 	public MainMenu(){
		Animation a = new Animation();
		Image img = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg");
		a.addScene(img, 250);
		//img = kartinkata , 250 = kolko milisekundi 6te sedi to4no taq kartinka
		// taka pravi6 animaciq sus si4ki kartinki koito iska6
	}

}
