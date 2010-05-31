package game.graphic;
/* IMAGES POSITIONING INFO
 * Background - 1280x800, coordinates 0x0
 * Town Hall - coordinates 504x0
 * Barracks - coordinates 206x417
 * Archery - coordinates 66x413
 * MageTower - coordinates 627x296
 * Market - coordinates 637x524
 * Tavern - coordinates 865x508
 * Keep - coordinates 855x208*/

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import game.castle.Castle;
import game.castle.CastleBuilding;
import game.main.MainClass;
import game.player.Player;
import game.player.Players;
import game.unit.Hero;

public class CastleView {
	
	private Castle castle; // index of castle in ArrayList<Castle> in player class
	private boolean inCastle; // ako e true - se risuva CastleView ako ne e true ne se risuva
	private MainClass mc;
	private int menuBuilding;
	private Image menuFrame;
	
	public CastleView (int castle, MainClass mc) {
		setInCastle(true);
		this.castle = mc.getCurrentPlayer().getCastles().get(castle);
		menuBuilding = 0;
		menuFrame = Toolkit.getDefaultToolkit().getImage("Images/Castle/Frame.png");
	
	}
	
	public void update(long timePassed){
		//ako ima animacii
		//za vsqka
		//a.update(timePassed);
	}
	
	public void draw(Graphics g){
		// Draw background
		g.drawImage(castle.getBackground(),1,1,null);
		// Draw individual buildings
		for (CastleBuilding current : castle.getBuildings()) {
			if (current.isBuilt()) {
				g.drawImage(current.getImage(),current.getX(),current.getY(),null);
			}
		}
		/* MENU INFO
		 * Hero/unit icons - 36x36px with 40x40px borders
		 */
		// Draw menu
		g.drawImage(menuFrame,1,1,null);
		g.drawImage(castle.getGarrisonSquare().getHero().getIcon(),901,11,null);
		g.drawImage(castle.getCurrentSquare().getHero().getIcon(),901,61,null);
		
		/*
		/*
		//for( Building b : castle.getbuildings
		g.setColor(new Color(244));
		g.fillRect(0, 0, 1600, 1000);
		//vurti6 cikul za vsqka postroika - ako e postroena - q risuva6
		//g.draw(img, x , y , null)  null e za observeri kvito ne polzvame
		//otdelno risuva6 i butoni i si4ko
		*/
	}

	public void setInCastle(boolean isInCastle) {
		this.inCastle = isInCastle;
	}

	public boolean isInCastle() {
		return inCastle;
	}
	
	public void mouseClicked(MouseEvent e){
		//tuka pi6e6 klasut za mi6kata - za da dokopa6 kude to4no e - mc.getMousePos() i ot tam iz4islqva6 dali e vurhu postroika ili vurhu buton 
		//ako e na takova mqsto pi6e6 kakvo stava ako se klikne
	}
	
	
	
}
