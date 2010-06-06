package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;
import game.unit.TestUnits;
import game.unit.Unit;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

public class MageTower extends CastleBuilding {	

	public MageTower(Castle owner, MainClass mc) {
		super(owner,mc);
		x = 627;
		y = 296;
		w = 158;
		h = 121;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/MageTower.png");
		goldcost = 3000;
		woodcost = 15;
		stonecost = 15;
		upgradegoldcost = 2000;
		upgradewoodcost = 10;
		upgradestonecost = 5;
		built = false;
		upgraded = false;
		this.mc = mc;
		index = 4;
		name = "Mage Tower";
		description = "nodescript";
	}
	
	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground"),101,101,null);
		g.setColor(black);
		g.fillRect(351, 201, 200, 200);
		g.setColor(white);
		g.drawRect(351, 201, 200, 200);
		g.drawString("Buy Mage",355,205);
		g.drawString("Cost:",355,230);
		g.drawString("Gold: 2000",355,255);
		if (upgraded) {
			g.drawString("Upgrade Bonus: +1000XP",425,305);
		}
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),481,431,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),701,501,null);
	}
	
	@Override
	public void mousePressed(MouseEvent e, CastleView castleView) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
		topLeft.setLocation(481,431);
		bottomRight.setLocation(540,490);
		if(mc.isWithinBounds(mc.getMousePos(),topLeft,bottomRight)) {
			if(mc.getCurrentPlayer().getGold().getAmount() >= 2000) {
				if (owner.getGarrisonSquare().getHero() != null) {
					if (owner.getGarrisonSquare().getHero().getUnitsAmmount() < 8) {
						TestUnits testUnits = new TestUnits();
						Unit u = new Unit();
						u = testUnits.getMage();
						if (upgraded) {
							u.setExperiance(1000);
						}
						owner.getGarrisonSquare().getHero().addUnit(u);
						mc.getCurrentPlayer().getGold().removeAmount(200);
					}
				} else if (owner.getGarrison().getUnitsAmmount() < 8) {
					if (owner.getGarrison().getUnitsAmmount() < 8) {
						TestUnits testUnits = new TestUnits();
						Unit u = new Unit();
						u = testUnits.getMage();
						if (upgraded) {
							u.setExperiance(1000);
						}
						owner.getGarrison().addUnit(u);
						mc.getCurrentPlayer().getGold().removeAmount(200);
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
			}
			
		}
	}
	
	
}
