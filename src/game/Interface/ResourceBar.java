package game.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import game.main.MainClass;

public class ResourceBar {
	
	public ResourceBar(){
	}
	
	public void draw(Graphics g,MainClass mc){
		Color color = new Color(255, 255, 255);
		g.setColor(color);
		Font font = new Font(Font.SERIF, Font.BOLD, 17);
		g.setFont(font);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("src/game/images/test/ResourceBar.jpg"),20,20,null);
		String string =  mc.getCurrentPlayer().getName();
		g.drawString(string,30,40);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("src/game/images/test/ResourceBar.jpg"),20,45,null);
		string = "Gold: " + mc.getCurrentPlayer().getGold().getAmount();
		g.drawString(string,30,65);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("src/game/images/test/ResourceBar.jpg"),20,70,null);
		string = "Wood: " + mc.getCurrentPlayer().getWood().getAmount();
		g.drawString(string,30,90);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("src/game/images/test/ResourceBar.jpg"),20,95,null);
		string = "Stone: " + mc.getCurrentPlayer().getStone().getAmount();
		g.drawString(string,30,115);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("src/game/images/test/ResourceBar.jpg"),20,120,null);
		string = "Turn: " + mc.getTurnSystem().getCurrentTurn();
		g.drawString(string,30,140);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),(156-2),38,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/menu/hourglass.jpg"),(156),40,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),(156-2),78,null);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/menu/menu.jpg"),(156),80,null);
	}
	
}