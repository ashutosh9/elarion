package game.castle;

import java.awt.Toolkit;

public class Market extends CastleBuilding {

	public Market(Castle owner) {
		super(owner);
		x = 637;
		y = 524;
		w = 177;
		h = 87;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Market.png");
		goldcost = 2000;
		woodcost = 15;
		stonecost = 0;
	}
}
