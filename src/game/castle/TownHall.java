package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;
import game.unit.TestUnits;
import game.unit.Unit;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

public class TownHall extends CastleBuilding {
private int selection;
	
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
		upgradegoldcost = 10000;
		upgradewoodcost = 0;
		upgradestonecost = 0;
		built = true;
		index = 1;
		upgraded = false;
		this.mc = mc;
		name = "Town Hall";
		description = "nodescript";
		selection = -1;
	}
	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground"),101,101,null);
		g.setColor(black);
		g.fillRect(151, 151, 600, 400);
		g.setColor(white);
		g.drawRect(151, 151, 600, 400);
		for (int i=0; i<7; i++) {
			if (owner.getBuilding(i).isBuilt()) {
				if(owner.getBuilding(i).isUpgraded()) {
					g.setColor(gold);
					g.fillRect(171,171+(30*i),200,25);
				} else {
					g.setColor(green);
					g.fillRect(171,171+(30*i),200,25);
				}
			} else {
				g.setColor(grey);
				g.fillRect(171,171+(30*i),200,25);
			}
			g.setColor(white);
			g.drawString(owner.getBuilding(i).getName(),174,174+(i*30));
			if (i == selection) {
				g.setColor(white);
				g.drawRect(171, 171+(30*i), 200, 25);
			}
		}
		g.setColor(white);
		g.drawRect(501,171,200,25);
		g.drawRect(501,201,200,25);
		g.drawRect(501,231,200,25);
		g.drawRect(501,261,200,25);
		g.drawRect(501,291,200,25);
		if (selection != -1) {
			if(owner.getBuilding(selection).isBuilt()) {
				if (owner.getBuilding(selection).isUpgraded()) {
					g.drawString(owner.getBuilding(selection).getName(),503,173);
					g.drawString("Upgraded",503,203);
				} else {
					g.drawString(owner.getBuilding(selection).getName(), 503, 173);
					g.drawString("cost:",503,203);
					g.drawString("Gold: "+owner.getBuilding(selection).getUpGold(),503,233);
					g.drawString("Wood: "+owner.getBuilding(selection).getUpWood(),503,263);
					g.drawString("Stone: "+owner.getBuilding(selection).getUpStone(),503,293);
				}
			} else {
				g.drawString(owner.getBuilding(selection).getName(), 503, 173);
				g.drawString("cost:",503,203);
				g.drawString("Gold: "+owner.getBuilding(selection).getGold(),503,233);
				g.drawString("Wood: "+owner.getBuilding(selection).getWood(),503,263);
				g.drawString("Stone: "+owner.getBuilding(selection).getStone(),503,293);
			}
		}
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),621,501,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),701,501,null);
	}
	
	@Override
	public void mousePressed(MouseEvent e, CastleView castleView) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
		for(int i=0; i<7; i++){
			if(!clicked) {
				topLeft.setLocation(171,171+(30*i));
				bottomRight.setLocation(370,195+(30*i));
				if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
					selection = i;
					clicked = true;
				}
			}
		}
		if(!clicked) {
			topLeft.setLocation(621,501);
			bottomRight.setLocation(680,560);
			if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				if (selection != -1) {
					if(owner.getBuilding(selection).isBuilt()) {
						if(!owner.getBuilding(selection).isUpgraded()) {
							if(owner.getBuildLimit() != 0) {
								owner.getBuilding(selection).upgrade();
							}
						}
					} else {
						if(owner.getBuildLimit() != 0) {
							owner.getBuilding(selection).build();
						}
					}
				}
			}
		}	
		if (!clicked) {
			topLeft.setLocation(701,501);
			bottomRight.setLocation(760,560);
			if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				castleView.setMenuBuilding(-1);
				clicked = true;
				selection = -1;
			}
			
		}
	}
}
