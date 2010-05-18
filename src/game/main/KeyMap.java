package game.main;

import game.field.Field;

import java.awt.event.KeyEvent;

public class KeyMap {
	
	KeyMap(KeyEvent e,MainClass mc,int i,Field f){
		
		int keyCode = e.getKeyCode();
		
		int speed = 4;
		
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
				y+=mc.getScreenHeight()+2;
				if(y<f.getHeight()){
					if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsY() != 0){
						int temp = mc.getCurrentPlayer().getCurrentViewAbsY();
						mc.getCurrentPlayer().setCurrentViewAbsY(temp+speed);
					}
				}
			}
			
			if(keyCode == KeyEvent.VK_UP){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				y--;
				if(y>=0){
					if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsY() != 0){
						int temp = mc.getCurrentPlayer().getCurrentViewAbsY();
						mc.getCurrentPlayer().setCurrentViewAbsY(temp-speed);
					}
				}
			}
			
			if(keyCode == KeyEvent.VK_LEFT){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				x--;
				if(x>=0){
					if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsX() != 0){
						int temp = mc.getCurrentPlayer().getCurrentViewAbsX();
						mc.getCurrentPlayer().setCurrentViewAbsX(temp-speed);
					}
				}
			}
			
			if(keyCode == KeyEvent.VK_RIGHT){
				int x = mc.getCurrentPlayer().getCurrentView().getX();
				int y = mc.getCurrentPlayer().getCurrentView().getY();
				x+=mc.getScreenWidth()+2;
				if(x<f.getWidth()){
					if(f.getSquare(x, y)!=null || mc.getCurrentPlayer().getCurrentViewAbsX() != 0){
						int temp = mc.getCurrentPlayer().getCurrentViewAbsX();
						mc.getCurrentPlayer().setCurrentViewAbsX(temp+speed);
					}
				}
			}
			
			if(keyCode == KeyEvent.VK_S){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(2, f);
			}
			
			if(keyCode == KeyEvent.VK_W){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(1, f);
			}
			
			if(keyCode == KeyEvent.VK_A){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(3, f);
			}
			
			if(keyCode == KeyEvent.VK_D){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(4, f);
			}
			
			if(keyCode == KeyEvent.VK_Q){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(13, f);
			}
			
			if(keyCode == KeyEvent.VK_E){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(14, f);
			}
			
			if(keyCode == KeyEvent.VK_Z){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(23, f);
			}
			
			if(keyCode == KeyEvent.VK_C){
				mc.getCurrentPlayer().getSelectedHero().moveOneSquare(24, f);
			}
			
			else {
				e.consume();
			}
			
		}
		if(i==2) { //released
		}
		
		if(i==3) { //typed
			e.consume();
		}
	}

}
