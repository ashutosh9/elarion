package game.castle;

import game.graphic.CastleView;
import game.main.MainClass;
import game.unit.Hero;
import game.unit.TestUnits;
import game.unit.Unit;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Tavern extends CastleBuilding {
		private ArrayList<Hero> heroes = new ArrayList<Hero>(2);
		private int selection = -1;

	public Tavern(Castle owner, MainClass mc) {
		super(owner,mc);
		x = 865;
		y = 508;
		w = 320;
		h = 208;
		image = Toolkit.getDefaultToolkit().getImage("Images/castle/Tavern.png");
		goldcost = 1000;
		woodcost = 5;
		stonecost = 5;
		upgradegoldcost = 500;
		upgradewoodcost = 5;
		upgradestonecost = 5;
		built = false;
		upgraded = false;
		index = 6;
		this.mc = mc;
		name = "Tavern";
		description = "nodescript";
		heroes.clear();
		for (int i=0; i<2; i++){
			heroes.add(mc.getHeroGen().getRandomHero());
		}
	}
	
	@Override
	public void update() {
		heroes.clear();
		for (int i=0; i<2; i++){
			heroes.add(mc.getHeroGen().getRandomHero());
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
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"),601,501,null);
		for (int i=0;i<8;i++) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),201 + (40*i),251,null);
			if (selection != -1) {
				if (heroes.get(selection).getUnits().get(i) != null) {
					g.drawImage(heroes.get(selection).getUnits().get(i).getIcon(),203 + (40*i), 253, null);
				}
			}
		}
		for (int i=0;i<2;i++) {
			if (heroes.get(i)!= null) {
				g.drawImage(heroes.get(i).getIcon(),201+(40*i),201,null);
				if (selection == i) {
					g.drawRect(201+(40*i), 201, 36, 36);
					g.drawString("Name: " + heroes.get(i).getName(),204,315);
					g.drawString("Description: " + heroes.get(i).getDescription(),204,345);
					g.drawString("Level: " + heroes.get(i).getLevel(),204,375);
					
				}
			}
		}
		g.drawRect(201, 301, 300, 25);
		g.drawRect(201, 331, 300, 25);
		g.drawRect(201, 361, 300, 25);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e, CastleView castleView) {
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(0,0);
		boolean clicked = false;
		for (int i=0; i<2; i++) {
			topLeft.setLocation(201+(40*i),201);
			bottomRight.setLocation(240+(40*i),240);
			if (mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				if (heroes.get(i) != null) {
					selection = i;					
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
		if (!clicked) {
			topLeft.setLocation(601,501);
			bottomRight.setLocation(660,560);
			if(mc.isWithinBounds(mc.getMousePos(), topLeft, bottomRight)) {
				if (selection != -1) {
					if (owner.getCurrentSquare().getHero() == null) {
						if (mc.getCurrentPlayer().getGold().getAmount() >= 2500) {
							heroes.get(selection).setHeroLocation(owner.getCurrentSquare().getX(), owner.getCurrentSquare().getY(), owner.getField());
							mc.getCurrentPlayer().getGold().removeAmount(2500);
							mc.getCurrentPlayer().newHero(owner.getCurrentSquare().getHero(),owner.getCurrentSquare().getX(),owner.getCurrentSquare().getY(),owner.getField());
							heroes.set(selection,null);
						}
					}
				}
			}
		}
	}
}
