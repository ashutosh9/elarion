package game.castle;

import java.awt.Image;
import java.awt.Toolkit;

public class Archery extends CastleBuilding {
	private Image image;
	
	
	public Archery(Castle owner) {
		super(owner);
		x = 66;
		y = 413;
		w = 140;
		h = 67;
		goldcost = 1500;
		woodcost = 10;
		stonecost = 5;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Archery.png");
	}
	
	@Override
	public void update() {
	}
	
}
