package game.building;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import game.field.Field;
import game.main.MainClass;

public class WoodMine extends Building{
	
	public WoodMine(MainClass mc, int x, int y, Field f) {
		super(x,y,f,mc);
		currentSprite=Toolkit.getDefaultToolkit().getImage("Images/buildings/WoodMine.png");
	}
	
	@Override
	public void turnUpdate(int turn) {
		if (owner != null) {
			owner.getWood().addAmount(2);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/popup/popupBack.png"),101,101,null);
		g.setColor(black);
		g.fillRect(151, 151, 300, 30);
		g.setColor(gold);
		g.drawRect(151, 151, 300, 30);
		g.setColor(white);
		g.drawString("Owner is " + owner.getName(), 153, 175);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"),501,501,null);
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		Point topLeft = new Point(501,501);
		Point bottomRight = new Point(560,560);
		if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
			mc.setCurrentBuilding(null);
		}
	}
}