package game.main;

import java.awt.event.KeyEvent;

public class KeyMap {
	
	KeyMap(KeyEvent e,MainClass mc,int i){
		int keyCode = e.getKeyCode();
		if(i==1){//pressed
			
			if(keyCode == KeyEvent.VK_ESCAPE){
				mc.stop();
			}
			
		}
		if(i==2) { //released
			
		}
		
		if(i==3) { //typed
			
		}
	}

}
