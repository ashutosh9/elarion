package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;
import game.unit.TestUnits;
import game.unit.Unit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public class Archery extends CastleBuilding {
	
	public Archery(Castle owner, MainClass mc) {
		super(owner, mc);
		x = 66;
		y = 413;
		w = 140;
		h = 67;
		goldcost = 1500;
		woodcost = 10;
		stonecost = 5;
		upgradegoldcost = 1000;
		upgradewoodcost = 5;
		upgradestonecost = 5;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Archery.png");
		built = false;
		index = 3;
		upgraded = false;
		this.mc = mc;
	}
	
	@Override
	public void update() {
	}

	@Override
	public void drawMenu(Graphics g, CastleView castleView) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground"),101,101,null);
		g.setColor(black);
		g.fillRect(351, 201, 200, 200);
		g.setColor(white);
		g.drawRect(351, 201, 200, 200);
		g.drawString("Buy Archer",355,205);
		g.drawString("Cost:",355,230);
		g.drawString("Gold: 1000",355,255);
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
			clicked = true;
			if(mc.getCurrentPlayer().getGold().getAmount() >= 1000) {
				if (owner.getGarrisonSquare().getHero() != null) {
					if (owner.getGarrisonSquare().getHero().getUnitsAmmount() < 8) {
						TestUnits testUnits = new TestUnits();
						Unit u = new Unit();
						u = testUnits.getArcher();
						if (upgraded) {
							u.setExperiance(1000);
						}
						owner.getGarrisonSquare().getHero().addUnit(u);
						mc.getCurrentPlayer().getGold().removeAmount(1000);
					}
				} else if (owner.getGarrison().getUnitsAmmount() < 8) {
					if (owner.getGarrison().getUnitsAmmount() < 8) {
						TestUnits testUnits = new TestUnits();
						Unit u = new Unit();
						u = testUnits.getArcher();
						if (upgraded) {
							u.setExperiance(1000);
						}
						owner.getGarrison().addUnit(u);
						mc.getCurrentPlayer().getGold().removeAmount(1000);
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
