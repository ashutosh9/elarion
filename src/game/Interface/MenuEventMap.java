package game.Interface;

import game.main.MainClass;

public class MenuEventMap {
	
	public MenuEventMap(String event, MainClass mc, PopupMenu popupMenu){
		if(event == "exit"){
			mc.exit();
		}
		if(event == "close"){
			popupMenu.closePopup();
		}
	}

}
