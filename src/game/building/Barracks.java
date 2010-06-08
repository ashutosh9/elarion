package game.building;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import game.field.Field;
import game.main.MainClass;
import game.unit.TestUnits;
import game.unit.Unit;

public class Barracks extends Building{
	
	public Barracks(MainClass mc, int x, int y, Field f) {
		super(x,y,f,mc);
		currentSprite=Toolkit.getDefaultToolkit().getImage("Images/buildings/Barracks.png");
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/buildingMenuBackground.png"),101,101,null);
		g.setColor(black);
		g.fillRect(151, 151, 500, 500);
		g.setColor(white);
		g.drawRect(151, 151, 500, 500);
		g.drawString("Buy Warrior",155,205);
		g.drawString("Cost:",155,230);
		g.drawString("Gold: 1750",155,255);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),151,431,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),701,501,null);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
		topLeft.setLocation(151,431);
		bottomRight.setLocation(210,490);
		if(mc.isWithinBounds(mc.getMousePos(),topLeft,bottomRight)) {
			clicked = true;
			if(mc.getCurrentPlayer().getGold().getAmount() >= 1750) {
				if (currentSquare.getHero().getUnitsAmmount() < 8) {
					TestUnits testUnits = new TestUnits();
					Unit u = new Unit();
					u = testUnits.getWarrior();
					currentSquare.getHero().addUnit(u);
					mc.getCurrentPlayer().getGold().removeAmount(1750);
				}		
			}
		}
		if (!clicked) {
			topLeft.setLocation(701,501);
			bottomRight.setLocation(760,560);
			if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				mc.setCurrentBuilding(null);
				clicked = true;
			}
			
		}
	}
}