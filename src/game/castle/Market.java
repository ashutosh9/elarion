package game.castle;

import game.graphic.CastleView;
import game.item.Item;
import game.main.MainClass;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
public class Market extends CastleBuilding {
	private ArrayList<Item> items = new ArrayList<Item>(8);
	private int selection;
	private int invIndex;
	private static int xInv;
	private static int yInv;

	public Market(Castle owner, MainClass mc) {
		super(owner,mc);
		xInv = 436;
		yInv = -50;
		invIndex = 0;
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
					g.drawImage(items.get(i).getImage(),157+(40*i),331,null);
					if(selection == i) {
						g.setColor(gold);
						g.drawRect(157+(40*i), 331, 36, 36);
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
				if(owner.getCurrentSquare().getHero().getInventory().get(invIndex + 32) != null ){
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),40 + (7)*40 + xInv - 2, 360 + yInv - 2 + 0,40,40,null);
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right_available.jpg"),40 + (7)*40 + xInv, 360 + yInv,36,36,null);
				} else {
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),40 + (7)*40 + xInv - 2, 360 + yInv - 2 + 0,40,40,null);
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right.jpg"),40 + (7)*40 + xInv, 360 + yInv,36,36,null);
				}
				
				if(invIndex>0){
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),(7)*40 + xInv - 2, 360 + yInv - 2 + 0,40,40,null);
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left_available.jpg"),(7)*40 + xInv, 360 + yInv,36,36,null);
				} else {
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),(7)*40 + xInv - 2, 360 + yInv - 2 + 0,40,40,null);
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left.jpg"),(7)*40 + xInv, 360 + yInv,36,36,null);
				}
				
				int plusY = 0;
				int minX = 0;
					
				for(int i = invIndex; i < (invIndex + 32);i++){
					if((i-invIndex)%8 == 0){
						plusY += 40;
						minX += 320;
					}
					Image img = null;
					if(owner.getCurrentSquare().getHero().getInventory().get(i) != null){
						img = owner.getCurrentSquare().getHero().getInventory().get(i).getImage();
					} else {
						img = Toolkit.getDefaultToolkit().getImage("Buttons/inventory/default.jpg");
					}
					if(i == selection - 8){
						g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button_hovered.jpg"),40 + (i-invIndex)*40 + xInv - 2 - minX, 400 + yInv - 2 + plusY,40,40,null);
					} else {
						g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),40 + (i-invIndex)*40 + xInv - 2 - minX, 400 + yInv - 2 + plusY,40,40,null);
					}
					g.drawImage(img,40 + (i-invIndex)*40 + xInv - minX, 400 + yInv + plusY,36,36, null);
				}	
				
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg") ,(7)*40 + xInv - 2 - 25, 360 + yInv - 2 + 15,25,25,null);
				
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
					topLeft.setLocation(157+(40*i),331);
					bottomRight.setLocation(220+(40*i),395);
					if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
						clicked = true;
						if (items.get(i) != null) {
							selection = i;
						}	
					}
				}
			}
			if (!clicked) {
				int plusY = 0;
				int minX = 0;
				for(int i = invIndex; i < (invIndex + 32);i++){
					if((i-invIndex)%8 == 0){
						plusY += 40;
						minX += 320;
					}
					Point start = new Point(40 + (i-invIndex)*40 + xInv - 2 - minX, 400 + yInv - 2 + plusY);
					Point end = new Point(80 + (i-invIndex)*40 + xInv - 2 - minX, 440 + yInv - 2 + plusY);
					if(mc.isWithinBounds(mc.getMousePos(), start, end)){
						if(owner.getCurrentSquare().getHero().getInventory().get(i) != null){
							if(i == selection - 8){
								owner.getCurrentSquare().getHero().getEquipment().equip(owner.getCurrentSquare().getHero().getInventory().get(i), owner.getCurrentSquare().getHero().getInventory());
								selection = -1;
							} else {
								selection = i + 8;
							}
						}
						break;
					}
				}
				
				if(owner.getCurrentSquare().getHero().getInventory().get(invIndex + 32) != null ){
					Point start = new Point(40 + (7)*40 + xInv - 2, 360 + yInv - 2);
					Point end = new Point(80 + (7)*40 + xInv - 2, 400 + yInv - 2);
					if(mc.isWithinBounds(mc.getMousePos(), start, end)){
						invIndex += 32;
					}
				} 
				
				if(invIndex>0){
					Point start = new Point((7)*40 + xInv - 2, 360 + xInv - 2);
					Point end = new Point((8)*40 + yInv - 2, 400 + yInv - 2);
					if(mc.isWithinBounds(mc.getMousePos(), start, end)){
						invIndex -=32;
						if(invIndex < 0 ) invIndex = 0;
					}
				}
			}
		}
	}
}
