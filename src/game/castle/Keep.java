package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

public class Keep extends CastleBuilding {
	
	public Keep(Castle owner, MainClass mc) {
		super(owner,mc);
		x = 855;
		y = 208;
		w = 425;
		h = 212;
		goldcost = 7500;
		woodcost = 20;
		stonecost = 20;
		upgradegoldcost = 5000;
		upgradestonecost = 10;
		upgradewoodcost = 10;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Keep.png");
		built = true;
		index = 0;
		upgraded = false;
		this.mc = mc;
	}
	
	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground"),101,101,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),701,501,null);
		g.setColor(black);
		g.fillRect(351, 201, 200, 200);
		g.setColor(white);
		g.drawRect(351, 201, 200, 200);
		g.drawString("Keep",400,250);
		g.drawString("Heals the garrisoned hero's units every turn.",400,275);
		if(upgraded) {
			g.drawString("Upgrade bonus: Trains garrisoned units every turn.",400,300);
		}
	}

	public void mousePressed(MouseEvent e, CastleView castleView) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
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
