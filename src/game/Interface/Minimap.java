package game.Interface;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import game.castle.Castle;
import game.field.Field;
import game.main.MainClass;
import game.player.Player;

public class Minimap extends Tooltip {

	int visibleX;
	int visibleY;

	public Minimap(MainClass mc,Field f) {
		super(mc);
		visibleX = 0;
		visibleY = 0;
		for(int i=0;i<20;i++){
			for(int j=0;j<19;j++){
				Image img = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass2.jpg").getScaledInstance(10, 10, Image.SCALE_SMOOTH);
				newImg(img,40 + i*10,5+j*10);
			}
		}
		for(Player p : mc.getPlayers().getPlayers()){
			for(Castle c : p.getCastles()){
				int x = c.getCurrentSquare().getX();
				int y = c.getCurrentSquare().getY();
							
				int xx =(int) Math.round(((double)x/(double)f.getWidth())*200);
				int yy =(int) Math.round(((double)y/(double)f.getHeight())*190);
				
				Image img = Toolkit.getDefaultToolkit().createImage("Images/tooltip/minimap_castle.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				
				if(xx+22>200){
					xx -=22;
				}
				if(xx-22<0){
					xx = 2;
				}
				if(yy+22>190){
					yy-=22;
				}
				if(yy-22<0){
					yy = 2;
				}
				
				newImg(img,40 + xx, 5 + yy);
				
			}
		}
		
	}
	
	public void draw(Graphics g){
		super.draw(g);
	}
	
	public void MousePressed(MouseEvent e,MainClass mc){
		super.mousePressed(e, mc);
		if(mc.isWithinBounds(mc.getMousePos(), new Point(40 + getX(),5 + getY()), new Point(240 + getX(),195 + getY()))){
			System.out.print("ASd");
		}
	}
	
	

}
