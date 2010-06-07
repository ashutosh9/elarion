package game.castle;

import game.graphic.CastleView;
import game.item.Item;
import game.main.MainClass;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Market extends CastleBuilding {
	private ArrayList<Item> items = new ArrayList<Item>(8);
	private int selection;
	private int j;
	private int invOffset;

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
		selection = -1;
		invOffset = 0;
		items.clear();
		update();
	}
	
	@Override
	public void update() {
		items.clear();
		for (int i=0;i<8;i++) {
			items.add(mc.getItemGen().getRandomItem());
		}
	}

	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground.png"),101,101,null);
		g.setColor(black);
		g.fillRect(151, 151, 600, 400);
		g.setColor(white);
		g.drawRect(151, 151, 600, 400);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),701,501,null);
		g.drawString("Wood",155,165);
		g.drawString("Buy 5 for 500", 155,190);
		g.drawString("Sell 5 for 100",155,215);
		g.drawString("Buy",155,230);
		g.drawString("Sell",221,230);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),156,255,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),221,255,null);
		g.drawString("Stone",300,165);
		g.drawString("Buy 5 for 500", 300, 190);
		g.drawString("Sell 5 for 100",300, 215);
		g.drawString("Buy",300,230);
		g.drawString("Sell",366,230);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),301,255,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),366,255,null);
		if (upgraded) {
			for (int i=0; i<8; i++) {
				if(items.get(i) != null) {
					g.drawImage(items.get(i).getImage(),157+(40*i),403,null);
					if(selection == i) {
						g.setColor(gold);
						g.drawRect(157+(40*i), 403, 36, 36);
					}
				}
			}
			if (owner.getCurrentSquare().getHero() != null) {
//				if ((invOffset != 0) && (owner.getCurrentSquare().getHero().getInventory().size() > 8)) {
//					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left_available.jpg"),155,461,null);
//				} else { g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left.jpg"),155,461,null); }
//				for (int i=0; i<8; i++) {
//					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/default.jpg"),155,461,null);
//				}
//				if (invOffset < (owner.getCurrentSquare().getHero().getInventory().size() - 8)) {
//					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right_available.jpg"),731,461,null);
//				} else { g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right.jpg"),731,461,null); }
//				j = 0;
//				for (Item item : owner.getCurrentSquare().getHero().getInventory()) {
//					if (((j - invOffset) > -1)&&((j - invOffset) < 8)) {
//						g.drawImage(item.getImage(),219 + (64*j),461,null);
//						if ((selection - 8) == j) {
//							g.setColor(gold);
//							g.drawRect(219+(64*j),461,64,64);
//						}
//					}
//				}
				if(invOffset != 0) {
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left_available.jpg"),501,403,null);
				} else {g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left.jpg"),501,403,null);
				if(owner.getCurrentSquare().getHero().getInventory().size() - 8 > invOffset) {
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right_available.jpg"),571,403,null);
				} else { g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right.jpg"),571,403,null); }
				
				}
				j++;
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e, CastleView castleView) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
		topLeft.setLocation(156,255);
		bottomRight.setLocation(215,314);
		if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
			clicked = true;
			if (mc.getCurrentPlayer().getGold().getAmount() >= 500) {
				mc.getCurrentPlayer().getGold().removeAmount(500);
				mc.getCurrentPlayer().getWood().addAmount(5);
			}
		}
		if (!clicked) {
			topLeft.setLocation(221,255);
			bottomRight.setLocation(260,314);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				clicked = true;
				if (mc.getCurrentPlayer().getWood().getAmount() >= 5) {
					mc.getCurrentPlayer().getWood().removeAmount(5);
					mc.getCurrentPlayer().getGold().addAmount(100);
				}
			}
		}
		if (!clicked) {
			topLeft.setLocation(301,255);
			bottomRight.setLocation(360,314);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				clicked = true;
				if (mc.getCurrentPlayer().getGold().getAmount() >= 500) {
					mc.getCurrentPlayer().getGold().removeAmount(500);
					mc.getCurrentPlayer().getStone().addAmount(5);
				}
			}
		}
		if (!clicked) {
			topLeft.setLocation(366,255);
			bottomRight.setLocation(425,314);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				clicked = true;
				if (mc.getCurrentPlayer().getStone().getAmount() >= 5) {
					mc.getCurrentPlayer().getStone().removeAmount(5);
					mc.getCurrentPlayer().getGold().addAmount(100);
				}
			}
		}
		
		if (!clicked) {
			topLeft.setLocation(501,501);
			bottomRight.setLocation(760,560);
			if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				castleView.setMenuBuilding(-1);
				clicked = true;
			}
			
		}
		if(upgraded) {
			if (!clicked) {
				for (int i=0; i<8; i++) {
					topLeft.setLocation(157+(40*i),403);
					bottomRight.setLocation(220+(40*i),467);
					if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
						clicked = true;
						if (items.get(i) != null) {
							selection = i;
						}	
					}
				}
			}
			if (!clicked) {
				j = 0;
				if(owner.getGarrisonSquare().getHero() != null) {
					if (owner.getGarrisonSquare().getHero().getInventory() != null) {
							for (Item item : owner.getGarrisonSquare().getHero().getInventory()) {
							if (((j - invOffset) > -1) && ((j - invOffset) < 8)) {
								topLeft.setLocation(219 + (64*(j - invOffset)),524);
								bottomRight.setLocation(282 + (64*(j - invOffset)),524);
								if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
									clicked = true;
									selection = (j-invOffset);
								}
							}
							j++;
						}
					}
				}
			}
		}
	}
}
