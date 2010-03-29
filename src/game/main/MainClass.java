package game.main;

import game.Interface.Screen;
import game.building.Building;
import game.field.Field;
import game.player.Player;
import game.unit.Hero;
//import javax.swing.*;
import java.awt.*;
//import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

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
	
	public static void main(String args[]){
		field = new Field(500,500);
		// Visibility :: will be calculated every move depending on owned buildings of the player, owned heroes, their visibility and side effects
		//ArrayList<Player> playerList = new ArrayList<Player>(12);
		Player playerRed = new Player();
		currentPlayer = playerRed;
		Hero h = new Hero();
		currentPlayer.newHero(h,30, 20, field);
		currentPlayer.setCurrentView(field.getSquare(30, 30));
		
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
			a.update(timePassed);
			sprite.update(timePassed);
			//update sprites and animations
			update();
			
			
			Graphics2D g = s.getGraphics();

			draw(g);
			g.dispose();
			s.update();
			
			try {
				Thread.sleep(20);
			} catch(Exception ex){}
		}
	}
	
	private void update() {
		//gets all animations from the animations arrayList and updates them
		//gets all sprites from the sprites arrayList and updates them
		//a.update(timePassed);
		//sprite.update(timePassed);
		
	}

	public void draw(Graphics g){
		//draw buildings (maybe state 1 ,2 ,3 etc for animating)
		for(int i=1;i<28;i++){
			for(int j=1;j<36;j++){
				Image img = field.getSquare((currentPlayer.getCurrentView().getX() + j - 1), (currentPlayer.getCurrentView().getY() + i - 1)).getImage();
				g.drawImage(img
						, Math.round((j-1)*img.getWidth(null)), Math.round((i-1)*img.getHeight(null)), null);
				if(field.getSquare((currentPlayer.getCurrentView().getX() + j - 1), (currentPlayer.getCurrentView().getY() + i - 1)).getHero() != null){
					Hero hero = field.getSquare((currentPlayer.getCurrentView().getX() + j - 1), (currentPlayer.getCurrentView().getY() + i - 1)).getHero();
					if(hero.isMoving()){
						g.drawImage(hero.getCurrentMovingSprite().getImage(),Math.round(hero.getCurrentMovingSprite().getX())
								,Math.round(hero.getCurrentMovingSprite().getY()),null); // to finish the formula so it works for the current
						//condition - adding and decrementing by one ( because of the two loops
					} else {
						g.drawImage(hero.getStandAnimation().getImage(), Math.round((j-1)*img.getWidth(null)), Math.round((i-1)*img.getHeight(null)), null);
					}
					//checks the direction the hero is moving and then draws the hero Image in dependency of the direction and on different part of the current 
					//square, after stopped moving - set the hero location to the next square , activate animation for standing ( if any ) and 
					//set previous square hero to null and sprite for movement to null, the hero animation is drawn depending on his heading
					/* METHOD :: g.drawImage(sprite.getImage(),Math.round(sprite.getX()),Math.round(sprite.getY()), null); */
					//the moving sprite image location will equal the square location + some pixels for the movement itself
					//the movement orientation will depend on the heading
					//get square get building - if animations[] contains building.getanmation draw(animations.getbuildinganim.getImage()...) 
					// else draw a single image
					//start moving method :
					//-ismoving = true
					//-setheading 
					//-start the sprite for that heading
					//-set currentmovingsprite to that sprite
					//-location of the sprite = location of square
					//-when sprite = moved all way long = > sprite = 0 ; 
					//-currentmovingsprite = null
					//-hero location = next square
					//-ismoving = false
					//-hero animation for still
				}
				if(field.getSquare((currentPlayer.getCurrentView().getX() + j - 1), (currentPlayer.getCurrentView().getY() + i - 1)).getBuilding() != null){
					Building building = field.getSquare((currentPlayer.getCurrentView().getX() + j - 1), (currentPlayer.getCurrentView().getY() + i - 1)).getBuilding();
					g.drawImage(building.getImage(), Math.round((j-1)*img.getWidth(null)), Math.round((i-1)*img.getHeight(null)), null);
				}
				/*if(turnSystem.getCurrentPlayer().getMainHero().getCurrentSquare() == field.getSquare(j, i)) {
					//draw hero
				}*/
				//g.drawImage(Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg"),i*30,j*30,null);
			}
		}
		g.drawImage(a.getImage(), 0, 0, null);
		g.drawImage(sprite.getImage(),Math.round(sprite.getX()),Math.round(sprite.getY()), null);
		g.drawImage(face1,1060,30,null);
		g.drawImage(bg, 0, 0, null);
		// array list for sprite && animations - returns every animation and every sprite
		///
	}

	public void loadimages() {
		//load every image
		field.initImages();
		//Image img1 = Toolkit.getDefaultToolkit().getImage("game/terrain/images/Grass1.jpg"); //field.initImages();
		bg = Toolkit.getDefaultToolkit().getImage("src/game/images/test/bg.png"); 
		face1 = Toolkit.getDefaultToolkit().getImage("src/game/images/test/pic 1.png");
//		Image face2 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/pic 2.png");
		Image a1 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/1.png");
		Image a2 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/2.png");
		Image a3 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/3.png");
		Image a4 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/4.png");
		Image a5 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/5.png");
		Image a6 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/6.png");
		Image a7 =  Toolkit.getDefaultToolkit().getImage("src/game/images/test/7.png");
		
		//test animation
		a = new Animation();
		a.addScene(a1,200);
		a.addScene(a2,200);
		a.addScene(a3,150);
		a.addScene(a4,200);
		a.addScene(a5,200);
		a.addScene(a6,200);
		a.addScene(a7,200);
		
		sprite = new Sprite(a);
		sprite.setVelocityOfX(0.3f);
		sprite.setVelocityOfY(0.3f);
		sprite.setX(200);
		sprite.setY(200);
		sprite.setToMoveX(600f);
		sprite.setToMoveY(0f);
		loaded = true;
	}

	public void stop() {
		running = !running;
	}	
	
	public void exit() {
		exited = true;
	}	
	
	public static Player getCurrentPlayer() {
		return currentPlayer;
	}

	public static void setCurrentPlayer(Player currentPlayer) {
		MainClass.currentPlayer = currentPlayer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		KeyMap km = new KeyMap(e,mc,1,field);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// key tapped
		
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
 * 
 * 			RenderingHints rh = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setRenderingHints(rh);
			
			
			
@SuppressWarnings("serial")
public class MainClass extends JFrame {
	
	private Screen screen;
	private boolean loaded;
	private static Field field;
	
	public static void main(String[] args) {		
		field = new Field(500,500);
		DisplayMode dm = new DisplayMode(1280,800,16,DisplayMode.REFRESH_RATE_UNKNOWN);
		MainClass mc = new MainClass();
		mc.run(dm);		
	}

	
	public void run(DisplayMode dm){
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));
		
		loaded = false;
		
		screen = new Screen();
		try{
			screen.setFullScreen(dm);
			loadimages();
			try{
				Thread.sleep(5000);
			}catch(Exception ex) {}
		}finally{
			screen.restoreScreen();
		}
	}
	
	private void loadimages() {
		field.initImages();
		loaded = true;
		repaint();
	}

	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if(loaded){
		g.drawString("MOST AWESOME GAME EVER",200,300);
		//g.drawImage(asd,0,0,null);
		//za po natat16ni paint-vaniq se vika repaint();
		}
	}

}


	private Image img;


	public MainClass() {
			setTitle("Game");
			setSize(1000,800);
			setResizable(false);
			setBackground(Color.BLACK);
			
			setVisible(true);
	}
	
	void paint() {
		repaint();
	}
	
	public void setBGimage(String s) {
		img = Toolkit.getDefaultToolkit().getImage(s);
	}
 */
