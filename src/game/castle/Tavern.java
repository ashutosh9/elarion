package game.castle;

import java.awt.Toolkit;

public class Tavern extends CastleBuilding {

	public Tavern(Castle owner) {
		super(owner);
		x = 865;
		y = 508;
		w = 320;
		h = 208;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Tavern.png");
		goldcost = 1000;
		woodcost = 5;
		stonecost = 5;
	}
}
