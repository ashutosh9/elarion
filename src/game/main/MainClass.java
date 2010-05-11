package game.main;

import game.Interface.Screen;
import game.building.Building;
import game.core.Path;
import game.core.PathfindingSystem;
import game.field.Field;
import game.player.Player;
import game.unit.Hero;
//import javax.swing.*;
import java.awt.*;
//import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.MouseInputListener;

public class MainClass implements KeyListener,MouseInputListener {
	
	private Sprite sprite;
	private Animation a;
	private Screen s;
	private Image bg;
	private Image face1;
	private boolean loaded;
	private static Field field;
	private static Player currentPlayer;
	private static MainClass mc;
	private boolean running;
	private boolean exited;
	private Hero movingHero = new Hero();
	private int screenWidth;
	private int screenHeight;
	
	
	//for testing
	private static Hero h;
	
	public static void main(String args[]){
		field = new Field(500,500);
		// Visibility :: will be calculated every move depending on owned buildings of the player, owned heroes, their visibility and side effects
		//ArrayList<Player> playerList = new ArrayList<Player>(12);
		Player playerRed = new Player();
		currentPlayer = playerRed;
		h = new Hero();
		currentPlayer.newHero(h,480, 480, field);
		currentPlayer.selectHero(h);
		Building building = new Building();
		building.setImage(Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg"));
		field.getSquare(6, 6).setBuilding(building);
		field.getSquare(6, 6).setPassable(false);
		//field.getSquare(498, 498).setHero(h);
		currentPlayer.setCurrentView(field.getSquare(465, 465));
		currentPlayer.setCurrentViewAbsX(0);
		currentPlayer.setCurrentViewAbsY(0);
		
/*		playerRed.Activate();
		if(playerRed.isActive()){
			playerList.add(playerRed);
		}
		TurnSystem turnSystem = new TurnSystem(playerList);*/
		mc = new MainClass();
		// this will be the main graphics class
		// it will get the current player from the turn system
		mc.run();
	}

	private static final DisplayMode modes[] = {
		new DisplayMode(1280,800,32,0),
		//new DisplayMode(1280,800,24,0),
		//new DisplayMode(1280,800,16,0),		
		//new DisplayMode(1024,720,32,0),
		//new DisplayMode(1024,720,24,0),
		//new DisplayMode(1024,720,16,0),
	};
	
	public void run() {
		s = new Screen();
		try {
			DisplayMode dm = s.findCompatibleMode(modes);
			s.setFullScreen(dm);
			Window w = s.getFullScreenWindow();
			w.setFocusTraversalKeysEnabled(false);
			w.addKeyListener(this);
			loaded = false;
			running = true;
			loadimages();
			screenWidth = 33;
			screenHeight = 22;
			if(loaded){
				while(!exited){
					movieLoop();
				}
			}
		} finally {
			s.restoreScreen();
		}
	}
	
	public void movieLoop() {
		long startingTime = System.currentTimeMillis();
		long cumTime = startingTime;
		//while(!running) - draw menu 
		while(running && !exited){
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			//a.update(timePassed);
			//sprite.update(timePassed);
			//update sprites and animations
			update(timePassed);
			
			
			Graphics2D g = s.getGraphics();

			draw(g);
			g.dispose();
			s.update();
			
			try {
				Thread.sleep(20);
			} catch(Exception ex){}
		}
	}
	
	private void update(long timePassed) {
		ArrayList<Animation> a = h.getGraphicalData().getGraphicalData();
		for(Animation anim : a) {
			anim.update(timePassed);
		}
		if(h.getCurrentSprite() != null) {
			h.getCurrentSprite().update(timePassed);
		}
		
		//combatView.update(timePassed);
		
		//gets all animations from the animations arrayList and updates them
		//gets all sprites from the sprites arrayList and updates them
		//a.update(timePassed);
		//sprite.update(timePassed);
		
	}

	public void draw(Graphics g){
		
		//different views : world view/city view/combat view
		//currently there is just 1 setup view - world view
		
		//draw buildings (maybe state 1 ,2 ,3 etc for animating)
		/* METHOD :: g.drawImage(sprite.getImage(),Math.round(sprite.getX()),Math.round(sprite.getY()), null); */
		//the moving sprite image location will equal the square location + some pixels for the movement itself
		//the movement orientation will depend on the heading
		//get square get building - if animations[] contains building.getanmation draw(animations.getbuildinganim.getImage()...) 
		// else draw a single image
		
		//combatView.draw(g);
		
		if(movingHero.isMoving()){
			
			if((movingHero.getCurrentSquare().getX() < 11) && (movingHero.getCurrentSquare().getY() < 11)){
				currentPlayer.setCurrentView(field.getSquare(0, 0));
			} else if((movingHero.getCurrentSquare().getX() < 11)) {
				currentPlayer.setCurrentView(field.getSquare(0, movingHero.getCurrentSquare().getY() - 10));
			} else if((movingHero.getCurrentSquare().getY() < 11)) {
				currentPlayer.setCurrentView(field.getSquare((movingHero.getCurrentSquare().getX() - 10), 0));
			} else if ((movingHero.getCurrentSquare().getX() < (field.getWidth() - 34)) && (movingHero.getCurrentSquare().getY() < (field.getHeight() - 34))){
				currentPlayer.setCurrentView(field.getSquare(movingHero.getCurrentSquare().getX() - 10, movingHero.getCurrentSquare().getY() - 10));
			} else 
				
			if((movingHero.getCurrentSquare().getX() > (field.getWidth() - screenWidth)) && (movingHero.getCurrentSquare().getY() > (field.getHeight() - screenHeight))){
				currentPlayer.setCurrentView(field.getSquare((field.getWidth() - screenWidth), (field.getHeight() - screenHeight)));
			} else if((movingHero.getCurrentSquare().getX() > (field.getWidth() - screenWidth))) {
				currentPlayer.setCurrentView(field.getSquare((field.getWidth() - screenWidth), movingHero.getCurrentSquare().getY() - 10));
			} else if((movingHero.getCurrentSquare().getY() > (field.getHeight() - screenHeight))) {
				currentPlayer.setCurrentView(field.getSquare((movingHero.getCurrentSquare().getX() - 10), (field.getHeight() - screenHeight)));
			} else {
				currentPlayer.setCurrentView(field.getSquare(movingHero.getCurrentSquare().getX() - 10, movingHero.getCurrentSquare().getY() - 10));
			}
			
		}
		
		for(int x=-2;x<screenWidth;x++){
			for(int y=-2;y<screenHeight;y++){
				
				Image img = field.getSquare((x+2+currentPlayer.getCurrentView().getX()),(y+2+currentPlayer.getCurrentView().getY())).getImage();
				
				g.drawImage(img
						, Math.round((x)*img.getWidth(null) - currentPlayer.getCurrentViewAbsX()), Math.round((y)*img.getHeight(null) -
									currentPlayer.getCurrentViewAbsY()), null);
				
				if(field.getSquare((x+2+currentPlayer.getCurrentView().getX()),(y+2+currentPlayer.getCurrentView().getY())).getBuilding() != null){
					
					Building building = field.getSquare((x+2+currentPlayer.getCurrentView().getX()),(y+2+currentPlayer.getCurrentView().getY())).getBuilding();
					g.drawImage(building.getImage(), Math.round((x)*img.getWidth(null) - currentPlayer.getCurrentViewAbsX()), Math.round((y)*img.getHeight(null) -
							currentPlayer.getCurrentViewAbsY()), null);
					
				}
		
			}
		}		
		
		for(int x=-2;x<screenWidth;x++){
			for(int y=-2;y<screenHeight;y++){
				
				Image img = field.getSquare((x+2+currentPlayer.getCurrentView().getX()),(y+2+currentPlayer.getCurrentView().getY())).getImage();
				
				if(field.getSquare((x+2+currentPlayer.getCurrentView().getX()),(y+2+currentPlayer.getCurrentView().getY())).getHero() != null){
					
					movingHero = field.getSquare((x+2+currentPlayer.getCurrentView().getX()),(y+2+currentPlayer.getCurrentView().getY())).getHero();
					
					if(movingHero.isMoving()){
						
						g.drawImage(movingHero.getCurrentSprite().getImage() , Math.round((x)*img.getWidth(null) - currentPlayer.getCurrentViewAbsX()-10+movingHero.getCurrentSprite().getX()), Math.round((y)*img.getHeight(null) -
							currentPlayer.getCurrentViewAbsY()-10+movingHero.getCurrentSprite().getY()), null);
						
						if(Math.abs(movingHero.getCurrentSprite().getX())>=40 || Math.abs(movingHero.getCurrentSprite().getY())>=40) {
							movingHero.movedOneSquare(field);
						}
						
					} else {
						
						g.drawImage(movingHero.getStandAnimation().getImage() , Math.round((x)*img.getWidth(null) - currentPlayer.getCurrentViewAbsX()-10), Math.round((y)*img.getHeight(null) -
								currentPlayer.getCurrentViewAbsY()-10), null);
					}
					
				}
				
			}
		}
		

		
		
		
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("src/game/images/test/testMenu.png"),20,20,null);
		//g.drawImage(a.getImage(), 0, 0, null);
		//g.drawImage(sprite.getImage(),Math.round(sprite.getX()),Math.round(sprite.getY()), null);
		//g.drawImage(face1,1060,30,null);
		//g.drawImage(bg, 0, 0, null);
		// array list for sprite && animations - returns every animation and every sprite
		///
		String string = " X: " + currentPlayer.getCurrentView().getX() + " Y: " + currentPlayer.getCurrentView().getY();
		g.drawString(string,20,20);
		
		currentViewChecker();
	}

	public void loadimages() {
		//load every image
		field.initImages();
		//Image img1 = Toolkit.getDefaultToolkit().getImage("game/terrain/images/Grass1.jpg"); //field.initImages();
		bg = Toolkit.getDefaultToolkit().getImage("src/game/images/test/bg.png"); 
		face1 = Toolkit.getDefaultToolkit().getImage("src/game/images/test/pic 1.png");
		ArrayList<Animation> a = h.getGraphicalData().getGraphicalData();
//		Image face2 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/pic 2.png");
//		Image a1 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/1.png");
//		Image a2 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/2.png");
//		Image a3 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/3.png");
//		Image a4 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/4.png");
//		Image a5 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/5.png");
//		Image a6 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/6.png");
//		Image a7 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/7.png");
		
		//test animation
//		a = new Animation();
//		a.addScene(a1,200);
//		a.addScene(a2,200);
//		a.addScene(a3,150);
//		a.addScene(a4,200);
//		a.addScene(a5,200);
//		a.addScene(a6,200);
//		a.addScene(a7,200); 
//		
//		sprite = new Sprite(a);
//		sprite.setVelocityOfX(-0.3f);
//		sprite.setVelocityOfY(0.3f);
//		sprite.setX(200);
//		sprite.setY(200);
//		sprite.setToMoveX(200f);
//		sprite.setToMoveY(0f); 
		loaded = true;
	}

	public void stop() {
		running = !running;
	}	
	
	public void exit() {
		exited = true;
	}	
	
	public void currentViewChecker(){
		if(currentPlayer.getCurrentViewAbsX()>=40) {
			currentPlayer.setCurrentViewAbsX(0);
			currentPlayer.setCurrentView(field.getSquare((currentPlayer.getCurrentView().getX()+1), currentPlayer.getCurrentView().getY()));
		}		
		if(currentPlayer.getCurrentViewAbsY()>=40) {
			currentPlayer.setCurrentViewAbsY(0);
			currentPlayer.setCurrentView(field.getSquare(currentPlayer.getCurrentView().getX(), (currentPlayer.getCurrentView().getY()+1)));
		}
		if(currentPlayer.getCurrentViewAbsX()<=-40) {
			currentPlayer.setCurrentViewAbsX(0);
			currentPlayer.setCurrentView(field.getSquare((currentPlayer.getCurrentView().getX()-1), currentPlayer.getCurrentView().getY()));
		}		
		if(currentPlayer.getCurrentViewAbsY()<=-40) {
			currentPlayer.setCurrentViewAbsY(0);
			currentPlayer.setCurrentView(field.getSquare(currentPlayer.getCurrentView().getX(), (currentPlayer.getCurrentView().getY()-1)));
		}
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public static void setCurrentPlayer(Player currentPlayer) {
		MainClass.currentPlayer = currentPlayer;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		@SuppressWarnings("unused")
		KeyMap km = new KeyMap(e,mc,1,field);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		@SuppressWarnings("unused")
		KeyMap km = new KeyMap(e,mc,2,field);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		@SuppressWarnings("unused")
		KeyMap km = new KeyMap(e,mc,3,field);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}




/*	 
   			RenderingHints rh = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setRenderingHints(rh);	
			
			String string = " asd " + currentPlayer.getName() + " asd ";
			
			g.setColor(w.getBackground());
			g.fillRect(0,0,s.getWidth(),s.getHeight());
			g.setColoer(w.getForeground());
			g.drawString(string,x,y); // draws background && string
			
			
 */
