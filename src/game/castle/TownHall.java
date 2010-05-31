package game.castle;

import java.awt.Toolkit;

public class TownHall extends CastleBuilding {

	public TownHall(Castle owner) {
		super(owner);
		x = 504;
		y = 0;
		w = 609;
		h = 205;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/TownHall.png");
		goldcost = 0;
		woodcost = 0;
		stonecost = 0;
		built = true;
	}
}
