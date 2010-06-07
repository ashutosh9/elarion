package game.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import game.Interface.PopupWindow;
import game.main.MainClass;
import game.player.Player;

public class TurnPopupWindow extends PopupWindow {
	Player player;

	public TurnPopupWindow(MainClass mc,Player p) {
		super(mc);
		player = p;
		setBackground(Toolkit.getDefaultToolkit().getImage("Images/tooltip/background.jpg"));
		setX(Math.round(((1280 - 300) / 2)));
		setY(Math.round(((800 - 200) / 2)));
		newChoice(" ","close", 230, 130, Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_pressed.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_hovered.jpg"));
	}
	
	public void draw(Graphics g){
		super.draw(g);
		Color color = new Color(220, 220, 220);
		g.setColor(color);
		Font font = new Font(Font.SERIF, Font.BOLD, 26);
		g.setFont(font);
		g.drawString(player.getName() + "'s turn",70 + getX(), 95 + getY());
	}

}
