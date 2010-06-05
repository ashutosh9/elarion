package game.unit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import game.Interface.PopupWindow;
import game.item.Item;
import game.main.MainClass;

public class HeroPopupWindow extends PopupWindow {
	
	private Hero hero;
	private int invIndex;
	private int selected;

	public HeroPopupWindow(MainClass mc, Hero hero) {
		super(mc);
		invIndex = 0;
		selected = -1;
		this.hero = hero;
		this.newChoice(" ","close", 700, 500, Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_pressed.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_hovered.jpg"));
		Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		this.newImg(img, 33, 33);
		img = hero.getIcon().getScaledInstance(56, 56, 1);
		this.newImg(img, 35, 35);
		String s = hero.getName();
		this.newText(s, 100, 50);
		s = new String("XP : " + hero.getExperience().x + " / " + hero.getExperience().y);
		this.newText(s, 100, 80);
		for(int i = 0;i<43;i++){
			hero.getInventory().add(0, new Item(null,null));
		}
	}
	
	public void draw(Graphics g){
		super.draw(g);
		drawInventory(g);
		drawEquipment(g);
	}
	
	public void drawInventory(Graphics g){
		
		if(hero.getInventory().get(invIndex + 32) != null ){
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),40 + (7)*40 + super.getX() - 2, 360 + super.getY() - 2 + 0,40,40,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right_available.jpg"),40 + (7)*40 + super.getX(), 360 + super.getY(),36,36,null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),40 + (7)*40 + super.getX() - 2, 360 + super.getY() - 2 + 0,40,40,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/right.jpg"),40 + (7)*40 + super.getX(), 360 + super.getY(),36,36,null);
		}
		
		if(invIndex>0){
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),(7)*40 + super.getX() - 2, 360 + super.getY() - 2 + 0,40,40,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left_available.jpg"),(7)*40 + super.getX(), 360 + super.getY(),36,36,null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),(7)*40 + super.getX() - 2, 360 + super.getY() - 2 + 0,40,40,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/left.jpg"),(7)*40 + super.getX(), 360 + super.getY(),36,36,null);
		}
		
		int plusY = -40;
		int minX = -320;
			
		for(int i = invIndex; i < (invIndex + 32);i++){
			if((i-invIndex)%8 == 0){
				plusY += 40;
				minX += 320;
			}
			Image img = null;
			if(hero.getInventory().get(i) != null){
				img = hero.getInventory().get(i).getImage();
			} else {
				img = Toolkit.getDefaultToolkit().getImage("Buttons/inventory/default.jpg");
			}
			if(i == selected){
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button_hovered.jpg"),40 + (i-invIndex)*40 + super.getX() - 2 - minX, 400 + super.getY() - 2 + plusY,40,40,null);
			} else {
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),40 + (i-invIndex)*40 + super.getX() - 2 - minX, 400 + super.getY() - 2 + plusY,40,40,null);
			}
			g.drawImage(img,40 + (i-invIndex)*40 + super.getX() - minX, 400 + super.getY() + plusY,36,36, null);
		}	
		
	}
	
	public void drawEquipment(Graphics g){
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 280 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/hand.jpg"), 40 + super.getX(), 280 + super.getY(),46,46, null);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 135 + super.getX() - 2, 260 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/legs.jpg"), 135 + super.getX(), 260 + super.getY(),46,46, null);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 280 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/hand.jpg"), 230 + super.getX(), 280 + super.getY(),46,46, null);

		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 220 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/feet.jpg"), 40 + super.getX(), 220 + super.getY(),46,46, null);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 135 + super.getX() - 2, 190 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/armor.jpg"), 135 + super.getX(), 190 + super.getY(),46,46, null);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 220 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/neck.jpg"), 230 + super.getX(), 220 + super.getY(),46,46, null);

		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 160 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/bracers.jpg"), 40 + super.getX(), 160 + super.getY(),46,46, null);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 135 + super.getX() - 2, 120 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/helm.jpg"), 135 + super.getX(), 120 + super.getY(),46,46, null);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 160 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/ring.jpg"), 230 + super.getX(), 160 + super.getY(),46,46, null);

		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 100 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/gloves.jpg"), 40 + super.getX(), 100 + super.getY(),46,46, null);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 100 + super.getY() - 2,50,50, null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/ring.jpg"), 230 + super.getX(), 100 + super.getY(),46,46, null);
		
	}
	
	public void mouseChecker(MainClass mc) {
		super.mouseChecker(mc);
	}
	
	public void mousePressed(MouseEvent e, MainClass mc) {
		super.mousePressed(e, mc);
	}
	
	public void mouseReleased(MouseEvent e, MainClass mc) {
		super.mouseReleased(e, mc);
	}
	
	
	
}
