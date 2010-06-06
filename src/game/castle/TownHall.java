package game.castle;

import game.main.MainClass;

import java.awt.Toolkit;

public class TownHall extends CastleBuilding {

	public TownHall(Castle owner,MainClass mc) {
		super(owner,mc);
		x = 0;
		y = 504;
		w = 609;
		h = 205;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/TownHall.png");
		goldcost = 0;
		woodcost = 0;
		stonecost = 0;
		built = true;
		index = 1;
	}
}
