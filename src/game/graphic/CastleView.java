package game.graphic;
/* IMAGES POSITIONING INFO
 * Background - 1280x800, coords 0x0
 * Town Hall - coords 504x0
 * Barracks - coords 206x417
 * Archery - coords 66x413
 * MageTower - coords 627x296
 * Market - coords 637x524
 * Tavern - coords 865x508
 * Keep - coords 855x208
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import game.castle.Castle;
import game.main.MainClass;
import game.player.Player;
import game.player.Players;
import game.unit.Hero;

public class CastleView {

	private int castle; // index of castle in ArrayList<Castle> in player class
	private boolean inCastle; // ako e true - se risuva CastleView ako ne e true ne se risuva

	
	public CastleView (int castle, MainClass mc) {
		setInCastle(true);
		// mc.getCurrentPlayer().getCastles().get(castle); - izpolzva6 tova za da raboti6 sus zamuka
		
	}
	
	public void update(long timePassed){
		//ako ima animacii
		//za vsqka
		//a.update(timePassed);
	}
	
	public void draw(Graphics g){
		
		//for( Building b : castle.getbuildings
		g.setColor(new Color(244));
		g.fillRect(0, 0, 1600, 1000);
		//vurti6 cikul za vsqka postroika - ako e postroena - q risuva6
		//g.draw(img, x , y , null)  null e za observeri kvito ne polzvame
		//otdelno risuva6 i butoni i si4ko
		
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
