package game.castle;

import java.awt.Toolkit;

public class MageTower extends CastleBuilding {	

	public MageTower(Castle owner) {
		super(owner);
		x = 627;
		y = 296;
		w = 158;
		h = 121;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/MageTower.png");
		goldcost = 3000;
		woodcost = 15;
		stonecost = 15;
	}
	
	
	
}
