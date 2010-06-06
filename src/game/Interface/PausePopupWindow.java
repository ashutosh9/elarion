package game.Interface;

import java.awt.Toolkit;

import game.main.MainClass;

public class PausePopupWindow extends PopupWindow {

	public PausePopupWindow(MainClass mc) {
		super(mc);
		setBackground(Toolkit.getDefaultToolkit().getImage("Images/tooltip/background.jpg"));
		setX(Math.round(((1280 - 300) / 2)));
		setY(Math.round(((800 - 200) / 2)));
		newChoice(" ","close", 230, 130, Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_pressed.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/ok/button_ok_hovered.jpg"));
		newChoice("Exit","exit", 120, 60, Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel_pressed.jpg"), Toolkit.getDefaultToolkit().getImage("Buttons/cancel/button_cancel_hovered.jpg"));
	}


}
