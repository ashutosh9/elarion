package game.castle;

import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class Barracks extends CastleBuilding {
	
	public Barracks(Castle owner) {
		super(owner);
		x = 206;
		y = 417;
		w = 176;
		h = 77;
		goldcost = 2000;
		woodcost = 5;
		stonecost = 10;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Barracks.png");
		built = true;
		index = 2;
	}
}
