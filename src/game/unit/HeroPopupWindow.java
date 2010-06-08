package game.unit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import game.Interface.PopupWindow;
import game.Interface.Tooltip;
import game.item.Item;
import game.main.MainClass;

public class HeroPopupWindow extends PopupWindow {
	
	private Hero hero;
	private int invIndex;
	private int selectedItem;
	private int selectedUnit;

	public HeroPopupWindow(MainClass mc, Hero hero) {
		
		super(mc);
		invIndex = 0;
		selectedItem = -1;
		selectedUnit = -1;
		this.hero = hero;
		this.newChoice(" ","close", 700, 500, Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_pressed.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_hovered.jpg"));
		
		Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		this.newImg(img, 33, 33);
		
		img = hero.getIcon().getScaledInstance(56, 56, 1);
		this.newImg(img, 35, 35);
		
		String s = hero.getName();
		this.newText(s, 100, 50);
		
		s = new String("XP : " + hero.getExperience().x + " / " + hero.getExperience().y);
		this.newText(s, 100, 80);
		
		img = Toolkit.getDefaultToolkit().getImage("Images/popup/stats2.png").getScaledInstance(300, 370, Image.SCALE_DEFAULT);
		this.newImg(img, 415, 33);
		
		s = new String("Level : " + hero.getLevel());
		this.newText(s, 455, 80);
		
		int bonus = 0;
		for(Item i : hero.getEquipment().getEquipment()){
			if(i!=null){
				for(String str : i.getBonuses()){
					if(str == "strenght"){
						bonus++;
					}
				}
			}
		}
		s = new String("Strenght : " + hero.getCombatStats().getStrenght());
		this.newText(s, 455, 110);
		s = new String("Constitution : " + hero.getCombatStats().getConstitution());
		this.newText(s, 455, 130);
		
		s = new String("Dexterity : " + hero.getCombatStats().getDexterity());
		this.newText(s, 455, 160);
		s = new String("Intelligence : " + hero.getCombatStats().getIntelligence());
		this.newText(s, 455, 180);

		s = new String("Wisdom : " + hero.getCombatStats().getWisdom());
		this.newText(s, 455, 210);
		s = new String("Charisma : " + hero.getCombatStats().getCharisma());
		this.newText(s, 455, 230);
		
		s = new String("Initiative : " + hero.getCombatStats().getInitiative());
		this.newText(s, 455, 260);
		s = new String("Movement Points : " + hero.getMovementPoints() / 10);
		this.newText(s, 455, 280);
		
		s = new String("Health : " + hero.getCombatStats().getHealth().x + "/" + hero.getCombatStats().getHealth().y);
		this.newText(s, 455, 310);
		s = new String("Mana : " + hero.getCombatStats().getMana().x + "/" + hero.getCombatStats().getMana().y);
		this.newText(s, 455, 330);
		
		
		
	}
	
	public void draw(Graphics g){
		super.draw(g);
		drawInventory(g);
		drawEquipment(g);
		drawUnits(g);
		drawBonuses(g);
	}
	
	public void drawBonuses(Graphics g){
		int bonus = 0;
		for(Item i : hero.getEquipment().getEquipment()){
			if(i!=null){
				for(String str : i.getBonuses()){
					if(str == "strenght"){
						bonus++;
					}
				}
			}
		}
		String s = new String(" + " + bonus);
		g.drawString(s, 595 + getX(), 110 + getY());
		
		bonus = 0;
		for(Item i : hero.getEquipment().getEquipment()){
			if(i!=null){
				for(String str : i.getBonuses()){
					if(str == "constitution"){
						bonus++;
					}
				}
			}
		}
		
		s = new String(" + " + bonus);
		g.drawString(s, 595 + getX(), 130 + getY());
		
		bonus = 0;
		for(Item i : hero.getEquipment().getEquipment()){
			if(i!=null){
				for(String str : i.getBonuses()){
					if(str == "dexterity"){
						bonus++;
					}
				}
			}
		}
		
		s = new String(" + " + bonus);
		g.drawString(s, 595 + getX(), 160 + getY());
		bonus = 0;
		for(Item i : hero.getEquipment().getEquipment()){
			if(i!=null){
				for(String str : i.getBonuses()){
					if(str == "intelligence"){
						bonus++;
					}
				}
			}
		}
		s = new String(" + " + bonus);
		g.drawString(s, 595 + getX(), 180 + getY());
		bonus = 0;
		for(Item i : hero.getEquipment().getEquipment()){
			if(i!=null){
				for(String str : i.getBonuses()){
					if(str == "wisdom"){
						bonus++;
					}
				}
			}
		}
		s = new String(" + " + bonus);
		g.drawString(s, 595 + getX(), 210 + getY());
		bonus = 0;
		for(Item i : hero.getEquipment().getEquipment()){
			if(i!=null){
				for(String str : i.getBonuses()){
					if(str == "charisma"){
						bonus++;
					}
				}
			}
		}
		s = new String(" + " + bonus);
		g.drawString(s, 595 + getX(), 230 + getY());

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
			if(i == selectedItem){
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button_hovered.jpg"),40 + (i-invIndex)*40 + super.getX() - 2 - minX, 400 + super.getY() - 2 + plusY,40,40,null);
			} else {
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"),40 + (i-invIndex)*40 + super.getX() - 2 - minX, 400 + super.getY() - 2 + plusY,40,40,null);
			}
			g.drawImage(img,40 + (i-invIndex)*40 + super.getX() - minX, 400 + super.getY() + plusY,36,36, null);
		}	
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg") ,(7)*40 + super.getX() - 2 - 25, 360 + super.getY() - 2 + 15,25,25,null);
		
	}
	
	public void drawEquipment(Graphics g){
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 280 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getLeftHand() != null){
			g.drawImage(hero.getEquipment().getLeftHand().getImage(), 40 + super.getX(), 280 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/hand.jpg"), 40 + super.getX(), 280 + super.getY(),46,46, null);
		}
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 135 + super.getX() - 2, 260 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getLegs() != null){
			g.drawImage(hero.getEquipment().getLegs().getImage(), 135 + super.getX(), 260 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/legs.jpg"), 135 + super.getX(), 260 + super.getY(),46,46, null);
		}
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 280 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getRightHand() != null){
			g.drawImage(hero.getEquipment().getRightHand().getImage(), 230 + super.getX(), 280 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/hand.jpg"), 230 + super.getX(), 280 + super.getY(),46,46, null);
		}

		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 220 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getFeet() != null){
			g.drawImage(hero.getEquipment().getFeet().getImage(), 40 + super.getX(), 220 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/feet.jpg"), 40 + super.getX(), 220 + super.getY(),46,46, null);
		}
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 135 + super.getX() - 2, 190 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getArmor() != null){
			g.drawImage(hero.getEquipment().getArmor().getImage(), 135 + super.getX(), 190 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/armor.jpg"), 135 + super.getX(), 190 + super.getY(),46,46, null);
		}
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 220 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getNeck() != null){
			g.drawImage(hero.getEquipment().getNeck().getImage(), 230 + super.getX(), 220 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/neck.jpg"), 230 + super.getX(), 220 + super.getY(),46,46, null);
		}

		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 160 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getBracers() != null){
			g.drawImage(hero.getEquipment().getBracers().getImage(), 40 + super.getX(), 160 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/bracers.jpg"), 40 + super.getX(), 160 + super.getY(),46,46, null);
		}
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 135 + super.getX() - 2, 120 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getHead() != null){
			g.drawImage(hero.getEquipment().getHead().getImage(), 135 + super.getX(), 120 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/helm.jpg"), 135 + super.getX(), 120 + super.getY(),46,46, null);
		}
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 160 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getRing1() != null){
			g.drawImage(hero.getEquipment().getRing1().getImage(), 230 + super.getX(), 160 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/ring.jpg"), 230 + super.getX(), 160 + super.getY(),46,46, null);
		}

		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 40 + super.getX() - 2, 100 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getGloves() != null){
			g.drawImage(hero.getEquipment().getGloves().getImage(), 40 + super.getX(), 100 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/gloves.jpg"), 40 + super.getX(), 100 + super.getY(),46,46, null);
		}
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg"), 230 + super.getX() - 2, 100 + super.getY() - 2,50,50, null);
		if(hero.getEquipment().getRing2() != null){
			g.drawImage(hero.getEquipment().getRing2().getImage(), 230 + super.getX(), 100 + super.getY(),46,46, null);
		} else {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/inventory/ring.jpg"), 230 + super.getX(), 100 + super.getY(),46,46, null);
		}
		
	}
	
	public void drawUnits(Graphics g){
		for(int i = 0; i < 8;i++){
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button.jpg") ,i * 50 +365 + super.getX() - 2, 400 + super.getY() - 2,50,50,null);
			if(hero.getUnits().get(i) != null){
				if(i == selectedUnit){
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/empty/button_hovered.jpg") ,i * 50 +365 + super.getX() - 2, 400 + super.getY() - 2,50,50,null);
					g.drawImage(hero.getUnits().get(i).getIcon() ,i * 50 +365 + super.getX() + 2, 400 + super.getY() + 2,44,44,null);
				} else {
					g.drawImage(hero.getUnits().get(i).getIcon() ,i * 50 +365 + super.getX() + 2, 400 + super.getY() + 2,44,44,null);
				}
			} else {
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/units/default.jpg") ,i * 50 +365 + super.getX() + 2, 400 + super.getY() + 2,42,42,null);
			}
		}
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg") ,7 * 50 +385 + super.getX() + 2, 370 + super.getY() + 2,25,25,null);
		
	}
	
	public void mousePressed(MouseEvent e, MainClass mc) {
		super.mousePressed(e, mc);
		
		if(e.getButton() == MouseEvent.BUTTON1){
		
			int plusY = -40;
			int minX = -320;
			
			for(int i = invIndex; i < (invIndex + 32);i++){
				if((i-invIndex)%8 == 0){
					plusY += 40;
					minX += 320;
				}
				Point start = new Point(40 + (i-invIndex)*40 + super.getX() - 2 - minX, 400 + super.getY() - 2 + plusY);
				Point end = new Point(80 + (i-invIndex)*40 + super.getX() - 2 - minX, 440 + super.getY() - 2 + plusY);
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getInventory().get(i) != null){
						if(i == selectedItem){
							hero.getEquipment().equip(hero.getInventory().get(i), hero.getInventory());
							selectedItem = -1;
						} else {
							selectedItem = i;
						}
					}
					break;
				}
			}
			
			if(hero.getInventory().get(invIndex + 32) != null ){
				Point start = new Point(40 + (7)*40 + super.getX() - 2, 360 + super.getY() - 2);
				Point end = new Point(80 + (7)*40 + super.getX() - 2, 400 + super.getY() - 2);
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					invIndex += 32;
					for(int i=0 + invIndex;i<(32+invIndex);i++){
						//hero.addItem(null);
						if(hero.getInventory().get(i) == null){
							hero.getInventory().add(i, null);
						}
					}
				}
			} 
			
			if(invIndex>0){
				Point start = new Point((7)*40 + super.getX() - 2, 360 + super.getY() - 2);
				Point end = new Point((8)*40 + super.getX() - 2, 400 + super.getY() - 2);
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					invIndex -=32;
					if(invIndex < 0 ) invIndex = 0;
				}
			} 
			
			if(mc.isWithinBounds(mc.getMousePos(), new Point((7)*40 + super.getX() - 2 - 25, 360 + super.getY() - 2 + 15), new Point((7)*40 + super.getX() - 2 , 360 + super.getY() - 2 + 40))){
				if(selectedItem != -1){
					if(hero.getInventory().get(selectedItem) != null){
						hero.getInventory().remove(selectedItem);
						hero.getInventory().add(selectedItem,null);
						selectedItem = -1;
					}
				}
			}
			
			Point start;
			Point end;
			
			start = new Point(40 + super.getX(), 280 + super.getY());
			end = new Point(90 + super.getX(), 330 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"leftHand");
			}
	
			start = new Point(135 + super.getX(), 260 + super.getY());
			end = new Point(185 + super.getX(), 310 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"legs");
			}
	
			start = new Point(230 + super.getX(), 280 + super.getY());
			end = new Point(280 + super.getX(), 330 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"rightHand");
			}
	
			start = new Point(40 + super.getX(), 220 + super.getY());
			end = new Point(90 + super.getX(), 270 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"feet");
			}
	
			start = new Point(135 + super.getX(), 190 + super.getY());
			end = new Point(185 + super.getX(), 240 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"armor");
			}
	
			start = new Point(230 + super.getX(), 220 + super.getY());
			end = new Point(280 + super.getX(), 270 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"neck");
			}
	
			start = new Point(40 + super.getX(), 160 + super.getY());
			end = new Point(90 + super.getX(), 210 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"bracers");
			}
			
			start = new Point(135 + super.getX(), 120 + super.getY());
			end = new Point(185 + super.getX(), 170 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"head");
			}
	
			start = new Point( 230 + super.getX(), 160 + super.getY());
			end = new Point( 280 + super.getX(), 210 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"ring1");
			}
	
			start = new Point(40 + super.getX(), 100 + super.getY());
			end = new Point(90 + super.getX(), 150 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"gloves");
			}
	
			start = new Point( 230 + super.getX(), 100 + super.getY());
			end = new Point( 280 + super.getX(), 150 + super.getY());
			
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				hero.getEquipment().equip(null, hero.getInventory(),"ring2");
			}
	
			for(int i = 0;i<8;i++){
				start = new Point(i * 50 +365 + super.getX() - 2, 400 + super.getY() - 2);
				end = new Point(i * 50 +415 + super.getX() - 2, 450 + super.getY() - 2);
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(selectedUnit != -1){
						if(selectedUnit == i){
							selectedUnit = -1;
							break;
						} 
						hero.swapUnit(hero, i, selectedUnit);
						selectedUnit = -1;
					} else {
						if(hero.getUnits().get(i) != null){
							selectedUnit = i;
						} else {
							selectedUnit = -1;
						}
					}
					break;
				}
			}
	
			if(mc.isWithinBounds(mc.getMousePos(), new Point(7 * 50 +385 + super.getX() + 2, 370 + super.getY() + 2), new Point(7 * 50 +410 + super.getX() + 2, 395 + super.getY() + 2))){
				if(selectedUnit != -1){
					if(hero.getUnits().get(selectedUnit) != null){
						hero.getUnits().remove(selectedUnit);
						hero.getUnits().add(selectedUnit,null);
						selectedUnit = -1;
					}
				}
			}
		
		}
		
		if(e.getButton() == MouseEvent.BUTTON3){
			
			for(int i = 0;i<8;i++){
				Point start = new Point(i * 50 +365 + super.getX() - 2, 400 + super.getY() - 2);
				Point end = new Point(i * 50 +415 + super.getX() - 2, 450 + super.getY() - 2);
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getUnits().get(i) != null){
						mc.setTooltip(new UnitTooltip(mc, hero.getUnits().get(i)));
					}
				}
			}
			
			int plusY = -40;
			int minX = -320;
			
			for(int i = invIndex; i < (invIndex + 32);i++){
				
				if((i-invIndex)%8 == 0){
					plusY += 40;
					minX += 320;
				}
				
				Point start = new Point(40 + (i-invIndex)*40 + super.getX() - 2 - minX, 400 + super.getY() - 2 + plusY);
				Point end = new Point(80 + (i-invIndex)*40 + super.getX() - 2 - minX, 440 + super.getY() - 2 + plusY);
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getInventory().get(i) != null){
						Tooltip t = new Tooltip(mc);
						
						Item item = hero.getInventory().get(i);
						
						Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_DEFAULT);
						t.newImg(img, 3, 3);
						
						img = item.getImage().getScaledInstance(56, 56, 1);
						t.newImg(img, 5, 5);
						
						String s = item.getName();
						if(s == null){
							s = "";
						}
						t.newText(s, 70, 30);
						s = new String("Prize : " + item.getCost());
						t.newText(s, 70, 45);
						
						int bonus = 1;
						if(item.getBonuses().get(0) != item.getBonuses().get(1)){
							bonus++;
						}
						
						if(!(bonus == 2)){
							s = new String("Adds 2 to " + item.getBonuses().get(0) + ".");
							t.newText(s, 20, 115);
						} else {
							s = new String("Adds 1 to " + item.getBonuses().get(0) + ".");
							t.newText(s, 20, 100);
							s = new String("Adds 1 to " + item.getBonuses().get(1) + ".");
							t.newText(s, 20, 115);
						}
						
						mc.setTooltip(t);
					}
					break;
				}
				
				
				start = new Point(40 + super.getX(), 280 + super.getY());
				end = new Point(90 + super.getX(), 330 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getLeftHand()!=null){
						ItemTooltip(hero.getEquipment().getLeftHand(), mc);
					}
				}
				
				start = new Point(135 + super.getX(), 260 + super.getY());
				end = new Point(185 + super.getX(), 310 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getLegs()!=null){
						ItemTooltip(hero.getEquipment().getLegs(), mc);
					}
				}
		
				start = new Point(230 + super.getX(), 280 + super.getY());
				end = new Point(280 + super.getX(), 330 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getRightHand()!=null){
						ItemTooltip(hero.getEquipment().getRightHand(), mc);
					}
				}
		
				start = new Point(40 + super.getX(), 220 + super.getY());
				end = new Point(90 + super.getX(), 270 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getFeet()!=null){
						ItemTooltip(hero.getEquipment().getFeet(), mc);
					}
				}
		
				start = new Point(135 + super.getX(), 190 + super.getY());
				end = new Point(185 + super.getX(), 240 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getArmor()!=null){
						ItemTooltip(hero.getEquipment().getArmor(), mc);
					}
				}
		
				start = new Point(230 + super.getX(), 220 + super.getY());
				end = new Point(280 + super.getX(), 270 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getNeck()!=null){
						ItemTooltip(hero.getEquipment().getNeck(), mc);
					}
				}
		
				start = new Point(40 + super.getX(), 160 + super.getY());
				end = new Point(90 + super.getX(), 210 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getBracers()!=null){
						ItemTooltip(hero.getEquipment().getBracers(), mc);
					}
				}
				
				start = new Point(135 + super.getX(), 120 + super.getY());
				end = new Point(185 + super.getX(), 170 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getHead()!=null){
						ItemTooltip(hero.getEquipment().getHead(), mc);
					}
				}
		
				start = new Point( 230 + super.getX(), 160 + super.getY());
				end = new Point( 280 + super.getX(), 210 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getRing1()!=null){
						ItemTooltip(hero.getEquipment().getRing1(), mc);
					}
				}
		
				start = new Point(40 + super.getX(), 100 + super.getY());
				end = new Point(90 + super.getX(), 150 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getGloves()!=null){
						ItemTooltip(hero.getEquipment().getGloves(), mc);
					}
				}
		
				start = new Point( 230 + super.getX(), 100 + super.getY());
				end = new Point( 280 + super.getX(), 150 + super.getY());
				
				if(mc.isWithinBounds(mc.getMousePos(), start, end)){
					if(hero.getEquipment().getRing2()!=null){
						ItemTooltip(hero.getEquipment().getRing2(), mc);
					}
				}
				
			}
			
		}
	
	}	
	
	public void ItemTooltip(Item i,MainClass mc){
		Tooltip t = new Tooltip(mc);
		
		Item item = i;
		
		Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		t.newImg(img, 3, 3);
		
		img = item.getImage().getScaledInstance(56, 56, 1);
		t.newImg(img, 5, 5);
		
		String s = item.getName();
		if(s == null){
			s = "";
		}
		t.newText(s, 70, 30);
		s = new String("Prize : " + item.getCost());
		t.newText(s, 70, 45);
		
		int bonus = 1;
		if(item.getBonuses().get(0) != item.getBonuses().get(1)){
			bonus++;
		}
		
		if(!(bonus == 2)){
			s = new String("Adds 2 to " + item.getBonuses().get(0) + ".");
			t.newText(s, 20, 115);
		} else {
			s = new String("Adds 1 to " + item.getBonuses().get(0) + ".");
			t.newText(s, 20, 100);
			s = new String("Adds 1 to " + item.getBonuses().get(1) + ".");
			t.newText(s, 20, 115);
		}
		
		mc.setTooltip(t);
	}
	
	public void mouseReleased(MouseEvent e,MainClass mc){
		super.mouseReleased(e, mc);
		if(e.getButton() == MouseEvent.BUTTON3){
			mc.setTooltip(mc.getMinimap());
		}
	}
	
}
