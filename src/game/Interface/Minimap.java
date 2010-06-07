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

	private int visibleX;
	private int visibleY;
	private int rectWidth;
	private int rectHeight;
	private Field f;

	public Minimap(MainClass mc,Field f) {
		super(mc);
		this.f = f;
		
		setRectHeight((int)Math.round(((double)190/(double)f.getHeight()) * (mc.getScreenHeight())));
		setRectWidth((int)Math.round(((double)200/(double)f.getWidth()) * (mc.getScreenWidth())));
				
		visibleX =(int) Math.round(((double)mc.getCurrentPlayer().getCurrentView().getX() / (double) f.getWidth()) * 200);
		visibleY =(int) Math.round(((double)mc.getCurrentPlayer().getCurrentView().getY() / (double) f.getHeight()) * 190);

		for(int i=0;i<20;i++){
			for(int j=0;j<19;j++){
				Image img = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass2.jpg").getScaledInstance(10, 10, Image.SCALE_SMOOTH);
				newImg(img,40 + i*10,5+j*10);
			}
		}
		for(Player p : mc.getPlayers().getPlayers()){
			for(Castle c : p.getCastles()){
				int x = c.getRootSquare().getX();
				int y = c.getRootSquare().getY();
							
				int xx =(int) Math.round(((double)x/(double)f.getWidth())*200);
				int yy =(int) Math.round(((double)y/(double)f.getHeight())*190);
				
				Image img = Toolkit.getDefaultToolkit().createImage("Images/tooltip/minimap_castle.png").getScaledInstance((int)Math.round(((double)3/(double)f.getHeight())*200 + 2),(int) Math.round(((double)3/(double)f.getWidth())*190 + 2), Image.SCALE_SMOOTH);
				
//				if(xx+getRectWidth()>200){
//					xx -=getRectWidth();
//				}
//				if(xx-getRectWidth()<0){
//					xx = 2;
//				}
//				if(yy+getRectHeight()>190){
//					yy-=getRectHeight();
//				}
//				if(yy-getRectHeight()<0){
//					yy = 2;
//				}
				
				newImg(img,40 + xx, 5 + yy);
				
			}
		}
		
	}
	
	public void update(MainClass mc,Field f){
		visibleX =(int) Math.round(((double)mc.getCurrentPlayer().getCurrentView().getX() / (double) f.getWidth()) * 200);
		visibleY =(int) Math.round(((double)mc.getCurrentPlayer().getCurrentView().getY() / (double) f.getHeight()) * 190);
		visibleX += 40;
		visibleY += 5;
	}
	
	public void draw(Graphics g){
		super.draw(g);
		g.drawRect(visibleX + getX(), visibleY + getY(), getRectWidth(), getRectHeight());
	}
	
	public void mousePressed(MouseEvent e,MainClass mc){
		super.mousePressed(e, mc);
		
		if(mc.isWithinBounds(mc.getMousePos(), new Point((40 + getX()),(5 + getY())), new Point((240 + getX()),(195 + getY())))){
			
			double x;
			double y;
			
			x=mc.getMousePos().x;
			y=mc.getMousePos().y;
			
			x -= getX() + 40;
			y -= getY() + 5;
			
			x = x / 200;
			y = y / 190;
			
			x = x*f.getWidth();
			y = y*f.getHeight();
			
			if(Math.round(x - mc.getScreenWidth()/2)<0){
				x=Math.round(mc.getScreenWidth()/2) + 1;
			}
			if(Math.round(y - mc.getScreenHeight()/2) < 0){
				y=Math.round(mc.getScreenHeight()/2) + 1;
			}
			if(Math.round(x)>f.getWidth() - mc.getScreenWidth() + 3){
				x=f.getWidth() - mc.getScreenWidth() + 14;
			}
			if(Math.round(y)>f.getHeight() - mc.getScreenHeight() + 3){
				y=f.getHeight() - mc.getScreenHeight() + 8;
			}

			mc.getCurrentPlayer().setCurrentView(f.getSquare((int)Math.round(x - mc.getScreenWidth()/2),(int)Math.round(y - mc.getScreenHeight()/2)));
			
		}
	}

	public void setRectWidth(int rectWidth) {
		this.rectWidth = rectWidth;
	}

	public int getRectWidth() {
		return rectWidth;
	}

	public void setRectHeight(int rectHeight) {
		this.rectHeight = rectHeight;
	}

	public int getRectHeight() {
		return rectHeight;
	}
	
	

}
