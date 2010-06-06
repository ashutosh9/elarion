package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;
import game.unit.TestUnits;
import game.unit.Unit;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

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
		upgradegoldcost = 500;
		upgradewoodcost = 5;
		upgradestonecost = 5;
		built = false;
		upgraded = false;
		index = 5;
		this.mc = mc;
		name = "Tavern";
		description = "nodescript";
	}
	
	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground"),101,101,null);
		g.setColor(black);
		g.fillRect(351, 201, 200, 200);
		g.setColor(white);
		g.drawRect(351, 201, 200, 200);
		g.drawString("NOT YET IMPLEMENTED",355,205);
		g.drawString("SORRY:",355,230);
		g.drawString("T_T",355,255);
		if (upgraded) {
			g.drawString("Upgrade Bonus: qko se nabuta",425,305);
		}
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),701,501,null);
	}
	
	@Override
	public void mousePressed(MouseEvent e, CastleView castleView) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
		topLeft.setLocation(481,431);
		bottomRight.setLocation(540,490);
		if (!clicked) {
			topLeft.setLocation(701,501);
			bottomRight.setLocation(760,560);
			if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				castleView.setMenuBuilding(-1);
				clicked = true;
			}
			
		}
	}
	
}
