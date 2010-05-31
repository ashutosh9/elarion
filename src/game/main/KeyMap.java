package game.main;

import game.field.Field;

import java.awt.event.KeyEvent;

public class KeyMap {
	
	KeyMap(KeyEvent e,MainClass mc,int i,Field f){
		
		int keyCode = e.getKeyCode();
		
		int speed = 4;
		if(!mc.getCombatView().isCombat()){
			if(i==1){//pressed
				
				if(keyCode == KeyEvent.VK_M){
					if(mc.getCurrentPlayer().getSelectedHero() != null){
						if(mc.getCurrentPlayer().getSelectedHero().getPath() != null){
							mc.getCurrentPlayer().getSelectedHero().getPath().setAutoMoving(true);
						}
					}
				} 
				
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
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(2, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_W){
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();						
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(1, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_A){
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(3, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_D){
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(4, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_Q){
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(13, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_E){
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(14, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_Z){
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(23, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_C){
					if(mc.getCurrentPlayer().getSelectedHero() != null) {
						mc.clearPath();
						mc.getCurrentPlayer().getSelectedHero().moveOneSquare(24, f);
					}
				}
				
				if(keyCode == KeyEvent.VK_B){
					boolean b = mc.getCombatView().isCombat();
					mc.getCombatView().setCombat(!b);
				}
				
				if(keyCode == KeyEvent.VK_0){
					mc.endedTurn();
				}
				
				if(keyCode == KeyEvent.VK_SPACE){
					if(mc.getCurrentPlayer().getSelectedHero() != null){
						if(mc.getCurrentPlayer().getSelectedHero().getMovementPoints() > 10){
							if(mc.getCurrentPlayer().getSelectedHero().getPath() != null){
								
								for(int x=-1;x<2;x++){
									for(int y=-1;y<2;y++){
										
										int sqX = mc.getCurrentPlayer().getSelectedHero().getHeroX() + x;
										int sqY = mc.getCurrentPlayer().getSelectedHero().getHeroY() + y;
	
										
										if(f.getSquare(sqX, sqY).isPath()){
											
											int heading = 0;
											
											if((x==-1) && (y==-1)){
												heading = 13;
											}
											if((x==1) && (y==1)){
												heading = 24;
											}
											if((x==1) && (y==-1)){
												heading = 14;
											}
											if((x==-1) && (y==1)){
												heading = 23;
											}
											
											if((x==-1) && (y==0)){
												heading = 3;
											}
											if((x==1) && (y==0)){
												heading = 4;
											}
											if((x==0) && (y==-1)){
												heading = 1;
											}
											if((x==0) && (y==1)){
												heading = 2;
											}
											
											if(mc.getCurrentPlayer().getSelectedHero().getPath().getSquares().size() > 0 ) {
												mc.getCurrentPlayer().getSelectedHero().getPath().getSquares().remove(0);
												//f.getSquare(sqX, sqY).setPath(false);
												mc.getCurrentPlayer().getSelectedHero().moveOneSquare(heading, f);
		
												
												if(mc.getCurrentPlayer().getSelectedHero().getPath().getSquares().size() == 0){
													mc.getCurrentPlayer().getSelectedHero().getPath().setAutoMoving(false);
													mc.clearPath();
												}
											}
											
										}
										
									}
								}
							}
						}
					}
				}
				
				if(keyCode == KeyEvent.VK_Z){
					if(mc.getCurrentPlayer().getSelectedHero() != null){
						if(mc.getCurrentPlayer().getSelectedHero().getPath() != null){
							mc.getCurrentPlayer().getSelectedHero().getPath().setAutoMoving(true);
						}
					}
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
	else if(mc.getCombatView().isCombat()){
			if(i==1){//pressed
				
				if(keyCode == KeyEvent.VK_ESCAPE){
					mc.stop();
				}
				
				if(keyCode == KeyEvent.VK_1){
					mc.exit();
				}
				
				if(keyCode == KeyEvent.VK_B){
					boolean b = mc.getCombatView().isCombat();
					mc.getCombatView().setCombat(!b);
				}
				
			}
			if(i==2) { //released
			}
			
			if(i==3) { //typed
				e.consume();
			}
		}
	}
}

