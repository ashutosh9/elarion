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
		index = 5;
		upgraded = false;
		this.mc = mc;
		name = "Market";
		description = "nodescript";
	}
	


	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground.png"),101,101,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),701,501,null);
		g.setColor(black);
		g.fillRect(351, 201, 600, 200);
		g.setColor(white);
		g.drawRect(351, 201, 600, 200);
		g.drawString("Wood",355,205);
		g.drawString("Buy 5 for 500", 355, 230);
		g.drawString("Sell 5 for 100",355,255);
		g.drawString("Buy",355,270);
		g.drawString("Sell",421,270);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),356,295,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),421,295,null);
		g.drawString("Stone",500,205);
		g.drawString("Buy 5 for 500", 500, 230);
		g.drawString("Sell 5 for 100",500,255);
		g.drawString("Buy",500,270);
		g.drawString("Sell",566,270);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),501,295,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),566,295,null);
		if (upgraded) {
			
		}
	}
	@Override
	public void mousePressed(MouseEvent e, CastleView castleView) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
		topLeft.setLocation(356,295);
		bottomRight.setLocation(415,354);
		if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
			clicked = true;
			if (mc.getCurrentPlayer().getGold().getAmount() >= 500) {
				mc.getCurrentPlayer().getGold().removeAmount(500);
				mc.getCurrentPlayer().getWood().addAmount(5);
			}
		}
		if (!clicked) {
			topLeft.setLocation(421,295);
			bottomRight.setLocation(460,354);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				clicked = true;
				if (mc.getCurrentPlayer().getWood().getAmount() >= 5) {
					mc.getCurrentPlayer().getWood().removeAmount(5);
					mc.getCurrentPlayer().getGold().addAmount(100);
				}
			}
		}
		if (!clicked) {
			topLeft.setLocation(501,295);
			bottomRight.setLocation(560,354);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				clicked = true;
				if (mc.getCurrentPlayer().getGold().getAmount() >= 500) {
					mc.getCurrentPlayer().getGold().removeAmount(500);
					mc.getCurrentPlayer().getStone().addAmount(5);
				}
			}
		}
		if (!clicked) {
			topLeft.setLocation(566,295);
			bottomRight.setLocation(625,354);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				clicked = true;
				if (mc.getCurrentPlayer().getStone().getAmount() >= 5) {
					mc.getCurrentPlayer().getStone().removeAmount(5);
					mc.getCurrentPlayer().getGold().addAmount(100);
				}
			}
		}
		
		if (!clicked) {
			topLeft.setLocation(701,501);
			bottomRight.setLocation(760,560);
			if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				castleView.setMenuBuilding(-1);
				clicked = true;
			}
			
		}
		if(upgraded) {
			
		}
	}
}
