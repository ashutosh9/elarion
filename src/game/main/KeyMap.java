package game.main;

import game.field.Field;

import java.awt.event.KeyEvent;

public class KeyMap {
	
	KeyMap(KeyEvent e,MainClass mc,int i,Field f){
		int keyCode = e.getKeyCode();
		if(i==1){//pressed
			
			if(keyCode == KeyEvent.VK_ESCAPE){
				mc.stop();
			}
			
			if(keyCode == KeyEvent.VK_1){
				mc.exit();
			}
			
			if(keyCode == KeyEvent.VK_DOWN){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				x--;
				if(f.getSquare(x, y)!=null){
				mc.getCurrentPlayer().setCurrentView(f.getSquare(x, y));
				}
			}
			
			if(keyCode == KeyEvent.VK_UP){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				x++;
				if(f.getSquare(x, y)!=null){
				mc.getCurrentPlayer().setCurrentView(f.getSquare(x, y));
				}
			}
			
			if(keyCode == KeyEvent.VK_LEFT){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				y--;
				if(f.getSquare(x, y)!=null){
				mc.getCurrentPlayer().setCurrentView(f.getSquare(x, y));
				}
			}
			
			if(keyCode == KeyEvent.VK_RIGHT){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				y++;
				if(f.getSquare(x, y)!=null){
				mc.getCurrentPlayer().setCurrentView(f.getSquare(x, y));	
				}
			}
			
		}
		if(i==2) { //released
			
		}
		
		if(i==3) { //typed
			
		}
	}

}
