package game.castle;

import game.main.MainClass;

import java.awt.Toolkit;

public class Tavern extends CastleBuilding {

	public Tavern(Castle owner, MainClass mc) {
		super(owner,mc);
		x = 865;
		y = 508;
		w = 320;
		h = 208;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Tavern.png");
		goldcost = 1000;
		woodcost = 5;
		stonecost = 5;
		built = true;
		index = 5;
	}
}
