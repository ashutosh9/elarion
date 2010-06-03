package game.castle;

import java.awt.Toolkit;

public class Keep extends CastleBuilding {
	
	public Keep(Castle owner) {
		super(owner);
		x = 855;
		y = 208;
		w = 425;
		h = 212;
		goldcost = 7500;
		woodcost = 20;
		stonecost = 20;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Keep.png");
		built = true;
	}
}
