package game.Interface;

import game.main.MainClass;

public class MenuEventMap {
	
	public MenuEventMap(String event, MainClass mc, PopupWindow popupMenu){
		if(event == "exit"){
			mc.exit();
		}
		if(event == "close"){
			popupMenu.closePopup();
		}
		if(event == "addXP1000"){
			mc.getCurrentPlayer().getSelectedHero().addExperience(1000, mc);
			popupMenu.closePopup();
		}
		if(event == "addXP1750"){
			mc.getCurrentPlayer().getSelectedHero().addExperience(1750, mc);
			popupMenu.closePopup();
		}
		if(event == "addXP2500"){
			mc.getCurrentPlayer().getSelectedHero().addExperience(2500, mc);
			popupMenu.closePopup();
		}
		if(event == "addGold2000"){
			mc.getCurrentPlayer().getGold().addAmount(2000);
			popupMenu.closePopup();
		}
		if(event == "addGold3500"){
			mc.getCurrentPlayer().getGold().addAmount(3500);
			popupMenu.closePopup();
		}
		if(event == "addGold5000"){
			mc.getCurrentPlayer().getGold().addAmount(5000);
			popupMenu.closePopup();
		}
	}
	
	public MenuEventMap(String event, MainClass mc, Tooltip tooltip){
		if(event == "exit"){
			mc.exit();
		}
		if(event == "close"){
			tooltip.closePopup();
		}
	}

}
