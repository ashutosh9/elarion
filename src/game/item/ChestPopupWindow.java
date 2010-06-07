package game.item;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import game.Interface.PopupWindow;
import game.main.MainClass;
import game.player.Player;
import game.unit.Hero;

public class ChestPopupWindow extends PopupWindow {

	private Hero hero;
	private int bonusXP;
	private int bonusGold;
	
	public ChestPopupWindow(MainClass mc,Player p) {
		super(mc);
		setHero(p.getSelectedHero());
		
		setBackground(Toolkit.getDefaultToolkit().getImage("Images/tooltip/background.jpg"));
		setX(Math.round(((1280 - 300) / 2)));
		setY(Math.round(((800 - 200) / 2)));
		
		Random random = new Random();
		
		int i = random.nextInt(3);
		
		Image img1 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/xp_big.jpg");
		Image img2 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/xp_big_clicked.jpg");
		
		if(i==0){
			bonusXP = 1000;
			newChoice(bonusXP + "  XP  or ", "addXP1000", 60, 60, img1, img2, img1);
			bonusGold = bonusXP*2;
			
			img1 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/gold_big.jpg");
			img2 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/gold_big_clicked.jpg");
			
			newChoice(bonusGold + "  Gold", "addGold2000", 160, 60, img1, img2, img1);
		} 
		if(i==1){
			bonusXP = 1750;
			newChoice(bonusXP + "  XP  or ", "addXP1750", 60, 60, img1, img2, img1);
			bonusGold = bonusXP*2;
			
			img1 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/gold_big.jpg");
			img2 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/gold_big_clicked.jpg");
			
			newChoice(bonusGold + "  Gold", "addGold3500", 160, 60, img1, img2, img1);
		}
		if(i==2){
			bonusXP = 2500;
			newChoice(bonusXP + "  XP  or ", "addXP2500", 60, 60, img1, img2, img1);
			bonusGold = bonusXP*2;
			
			img1 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/gold_big.jpg");
			img2 = Toolkit.getDefaultToolkit().getImage("Buttons/resource/gold_big_clicked.jpg");
			
			newChoice(bonusGold + "  Gold", "addGold5000", 160, 60, img1, img2, img1);
		}

	}

	public void setBonusXP(int bonusXP) {
		this.bonusXP = bonusXP;
	}

	public int getBonusXP() {
		return bonusXP;
	}

	public void setBonusGold(int bonusGold) {
		this.bonusGold = bonusGold;
	}

	public int getBonusGold() {
		return bonusGold;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Hero getHero() {
		return hero;
	}

}
