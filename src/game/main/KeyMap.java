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
				y++;
				if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsY() != 0){
					int temp = mc.getCurrentPlayer().getCurrentViewAbsY();
					mc.getCurrentPlayer().setCurrentViewAbsY(temp+1);
				}
			}
			
			if(keyCode == KeyEvent.VK_UP){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				y--;
				if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsY() != 0){
					int temp = mc.getCurrentPlayer().getCurrentViewAbsY();
					mc.getCurrentPlayer().setCurrentViewAbsY(temp-1);
				}
			}
			
			if(keyCode == KeyEvent.VK_LEFT){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				x--;
				if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsX() != 0){
					int temp = mc.getCurrentPlayer().getCurrentViewAbsX();
					mc.getCurrentPlayer().setCurrentViewAbsX(temp-1);
				}
			}
			
			if(keyCode == KeyEvent.VK_RIGHT){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				x++;
				if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsX() != 0){
					int temp = mc.getCurrentPlayer().getCurrentViewAbsX();
					mc.getCurrentPlayer().setCurrentViewAbsX(temp+1);
				}
			}
			
		}
		if(i==2) { //released
			
		}
		
		if(i==3) { //typed
			
		}
	}

}
