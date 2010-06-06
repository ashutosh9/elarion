package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

public class Market extends CastleBuilding {

	public Market(Castle owner, MainClass mc) {
		super(owner,mc);
		x = 637;
		y = 524;
		w = 177;
		h = 87;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Market.png");
		goldcost = 2000;
		woodcost = 15;
		stonecost = 0;
		upgradegoldcost = 2500;
		upgradewoodcost = 0;
		upgradestonecost = 15;
		built = false;
		index = 6;
		upgraded = false;
		this.mc = mc;
		name = "Market";
		description = "nodescript";
	}
	
	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground.png"),101,101,null);
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
