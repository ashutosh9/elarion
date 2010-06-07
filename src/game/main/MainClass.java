package game.main;

import game.Interface.PausePopupWindow;
import game.Interface.PopupWindow;
import game.Interface.ResourceBar;
import game.Interface.Screen;
import game.Interface.Tooltip;
import game.building.Building;
import game.castle.Castle;
import game.core.Path;
import game.core.PathNode;
import game.core.TurnPopupWindow;
import game.core.TurnSystem;
import game.field.Field;
import game.graphic.CastleView;
import game.graphic.CombatView;
import game.item.Item;
import game.item.RandomItemGenerator;
import game.player.Player;
import game.player.Players;
import game.resource.Resource;
import game.unit.Hero;
import game.unit.HeroPopupWindow;
import game.unit.RandomHeroGenerator;
import game.unit.TestUnits;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MainClass implements KeyListener,MouseMotionListener,MouseListener {
	


	private Screen s;
	private boolean loaded;
	private static Field field;
	private static MainClass mc;
	private boolean running;
	private boolean exited;
	private int screenWidth;
	private int screenHeight;
	private Robot robot;
	private static Players players;
	private Point mousePos = new Point(30,30);
	private static TurnSystem turnSystem;
	private boolean inCastle = false;
	private CastleView castleView;
	private static RandomItemGenerator itemGen;
	private static RandomHeroGenerator heroGen;
	private Tooltip tooltip;

	private static ResourceBar resourceBar;
	private PopupWindow popupWindow = null;
	
	
	//for testing
	private static Hero h;
//	private Image bg;
//	private Image face1;
//	private Animation a;
//	private Sprite sprite;
//	private static Item pathNode;
	private static CombatView combatView;
	
	public static void main(String args[]){
		mc = new MainClass();
		itemGen = new RandomItemGenerator();
		heroGen = new RandomHeroGenerator(mc);
		field = new Field(500,500);
		// Visibility :: will be calculated every move depending on owned buildings of the player, owned heroes, their visibility and side effects
		//ArrayList<Player> playerList = new ArrayList<Player>(12);
		players = new Players(2,field);
		turnSystem = new TurnSystem();
		Castle c = new Castle(479,478,field,mc);
		Castle c2 = new Castle (5,5,field,mc);
		h = new Hero(mc);
		Hero h2 = new Hero(mc);
		h.setName("Erag Tone");
		h2.setName("Kirie");
		h2.setIcon(Toolkit.getDefaultToolkit().getImage("Images/heroes/human/human_hero_2.jpg"));
		players.getCurrentPlayer().getDeadHeroes().add(heroGen.getRandomHero());
		
		players.getCurrentPlayer().getGold().setAmount(100000);
		players.getCurrentPlayer().getWood().setAmount(1000);
		players.getCurrentPlayer().getStone().setAmount(1000);
		players.getCurrentPlayer().newHero(h,480, 480, field);
		//players.getCurrentPlayer().newHero(h2,481, 480, field);
		players.getPlayer(1).newHero(h2, 30, 40, field);
		players.getCurrentPlayer().newCastle(c);
		players.getPlayer(1).newCastle(c2);
		
		players.getCurrentPlayer().setCurrentView(field.getSquare(2, 2));
		TestUnits testUnits = new TestUnits();
		TestUnits testUnits2 = new TestUnits();
		h.addUnit(testUnits.getWarrior());
		h.addUnit(testUnits.getArcher());
		h.addUnit(testUnits.getMage());
		h2.addUnit(testUnits2.getMage());
		h2.addUnit(testUnits2.getWarrior());
		h2.addUnit(testUnits2.getArcher());
		combatView = new CombatView(h2,h);
		combatView.setCombat(false);
		resourceBar = new ResourceBar();

		
//		path = new Path();
//		path = path.findPath(field, field.getSquare(4, 5), field.getSquare(14, 6));

		
/*		playerRed.Activate();
		if(playerRed.isActive()){
			playerList.add(playerRed);
		}
		TurnSystem turnSystem = new TurnSystem(playerList);*/
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
			w.addMouseListener(this);
			w.addMouseMotionListener(this);
			loaded = false;
			running = true;
			loadimages();
			screenWidth = 33;
			screenHeight = 22;
			if(loaded){
				while(!exited){
					drawLoop();
				}
			}
		} finally {
			s.restoreScreen();
		}
	}
	
	public void drawLoop() {
		long startingTime = System.currentTimeMillis();
		long runningTime = startingTime;
		while(running && !exited){
			long timePassed = System.currentTimeMillis() - runningTime;
			runningTime += timePassed;
			//a.update(timePassed);
			//sprite.update(timePassed);
			//update sprites and animations
			update(timePassed);
			
			Graphics2D g = s.getGraphics();

			try {
				draw(g);
			} catch (NullPointerException e) {
				System.out.print("draw error");
			}
			
			g.dispose();
			s.update();
			
			try {
				Thread.sleep(20);
			} catch(Exception ex){}
		}
	}
	
	private void update(long timePassed) {
//		ArrayList<Animation> a = h.getGraphicalData().getGraphicalData();
//		for(Animation anim : a) {
//				anim.update(timePassed);
//		}
		if(players.getCurrentPlayer().getSelectedHero() != null){
			if(players.getCurrentPlayer().getSelectedHero().getCurrentSprite() != null) {
				players.getCurrentPlayer().getSelectedHero().getCurrentSprite().update(timePassed);
			}
			
			if(players.getCurrentPlayer().getSelectedHero().getCurrentAnimation() != null) {
				players.getCurrentPlayer().getSelectedHero().getCurrentAnimation().update(timePassed);
			}
		}
		
		if(popupWindow != null){
			if(!popupWindow.isOpened()){
				popupWindow = null;
			}
		}
		
		//combatView.update(timePassed);
		
		//a.update(timePassed);
		//sprite.update(timePassed);
		
	}

	public void draw(Graphics g) throws NullPointerException{
		
		//different views : world view/city view/combat view
		//currently there is just 1 setup view - world view
		
		//draw buildings (maybe state 1 ,2 ,3 etc for animating)
		/* METHOD :: g.drawImage(sprite.getImage(),Math.round(sprite.getX()),Math.round(sprite.getY()), null); */
		//get square get building - if animations[] contains building.getanimation draw(animations.getbuildinganim.getImage()...) 
		// else draw a single image
//		if(combatView.isCombat()){
//			combatView.draw(g);
//		}
		//combatView.setCombat(false);
		
		//if(!combatView.isCombat()) {
		if(inCastle){
			castleView.draw(g);
		} else 
		if(!inCastle){
		
			if(players.getCurrentPlayer().getSelectedHero() != null){
				if(players.getCurrentPlayer().getSelectedHero().isMoving()){
					movingHeroChecker();
				}
			}
			
			for(int x=-2;x<screenWidth;x++){
				for(int y=-2;y<screenHeight;y++){
					
					Image img = field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getImage();
					
					g.drawImage(img
							, Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()), Math.round((y)*img.getHeight(null) -
										players.getCurrentPlayer().getCurrentViewAbsY()), null);
					
					if(field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getResource() != null){
						
						Resource r = field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getResource();
						g.drawImage(r.getImage(), Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()), Math.round((y)*img.getHeight(null) -
								players.getCurrentPlayer().getCurrentViewAbsY()), null);
						
					}
					
					if(field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getBuilding() != null){
						
						Building building = field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getBuilding();
						g.drawImage(building.getImage(), Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()), Math.round((y)*img.getHeight(null) -
								players.getCurrentPlayer().getCurrentViewAbsY()), null);
						
					}
					
					if(field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getItem() != null){
						
						Item r = field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getItem();
						g.drawImage(r.getImage(), Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()), Math.round((y)*img.getHeight(null) -
								players.getCurrentPlayer().getCurrentViewAbsY()), null);
						
					}
					
					if(field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).isPath()){
						g.drawImage(field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getPathNode().getImage(), Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()), Math.round((y)*img.getHeight(null) -
								players.getCurrentPlayer().getCurrentViewAbsY()), null);
					}
					
				}
			}		
			
			for(int x=-2;x<screenWidth;x++){
				for(int y=-2;y<screenHeight;y++){
					
					Image img = field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getImage();
					
					if(field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getCastle() != null){
						Castle c = field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getCastle();
						g.drawImage(c.getImage(), Math.round((x-1)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()), Math.round((y-2)*img.getHeight(null) -
								players.getCurrentPlayer().getCurrentViewAbsY()), null);
						
					}
					
					if(field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getHero() != null){
						
						Hero hero = field.getSquare((x+2+players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getHero();
						if(hero == players.getCurrentPlayer().getSelectedHero()){
							if(players.getCurrentPlayer().getSelectedHero().isMoving()){
								
								g.drawImage(players.getCurrentPlayer().getSelectedHero().getCurrentSprite().getImage() , Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()-10+players.getCurrentPlayer().getSelectedHero().getCurrentSprite().getX()), Math.round((y)*img.getHeight(null) -
									players.getCurrentPlayer().getCurrentViewAbsY()-10+players.getCurrentPlayer().getSelectedHero().getCurrentSprite().getY()), null);
								
								if(Math.abs(players.getCurrentPlayer().getSelectedHero().getCurrentSprite().getX())>=40 || Math.abs(players.getCurrentPlayer().getSelectedHero().getCurrentSprite().getY())>=40) {
									players.getCurrentPlayer().getSelectedHero().movedOneSquare(field);
								}
								
							} else {
								
								g.drawImage(players.getCurrentPlayer().getSelectedHero().getStandAnimation().getImage() , Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()-10), Math.round((y)*img.getHeight(null) -
										players.getCurrentPlayer().getCurrentViewAbsY()-10), null);
							}
						} else {
							g.drawImage(hero.getStandAnimation().getImage() , Math.round((x)*img.getWidth(null) - players.getCurrentPlayer().getCurrentViewAbsX()-10), Math.round((y)*img.getHeight(null) -
									players.getCurrentPlayer().getCurrentViewAbsY()-10), null);
						}
						
					}
					
					
				}
			}
			
			//g.drawImage(a.getImage(), 0, 0, null);
			//g.drawImage(sprite.getImage(),Math.round(sprite.getX()),Math.round(sprite.getY()), null);
			//g.drawImage(face1,1060,30,null);
			//g.drawImage(bg, 0, 0, null);
			// array list for sprite && animations - returns every animation and every sprite
	
			resourceBar.draw(g, mc);			
			
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),208,18,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),248,18,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),288,18,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),328,18,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),368,18,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),408,18,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),448,18,null);
			
			
			int h = 210;
			for(Hero hero : players.getCurrentPlayer().getHeroes()){
				if(hero.isSelected()){
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero_selected.jpg"),(h-2),18,null);
				} else {
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),(h-2),18,null);
				}
				g.drawImage(hero.getIcon(),h,20,null);
				h += 40;
			}
			h = 310;
			for(Castle castle : players.getCurrentPlayer().getCastles()){
				if(castle.isSelected()){
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/castle_selected"),(h-2),18,null);
				} else {
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/castle/castle_icon"),(h-2),18,null);
				}
				g.drawImage(castle.getIcon(),h,20,null);
				h += 40;
			}
			
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),(156-2),38,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/menu/hourglass.jpg"),(156),40,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg"),(156-2),78,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Buttons/menu/menu.jpg"),(156),80,null);
			
			
			if(tooltip != null){
				tooltip.draw(g);
			} else {
				tooltip = new Tooltip(this);
			}
			
			if(popupWindow != null){
				popupWindow.draw(g);
			}
	
			mouseChecker();
			currentViewChecker();
			autoMovementChecker();
		}
	}

	public void loadimages() {
		
		loaded = true;
	}

	public void stop() {
		running = !running;
	}	
	
	public void exit() {
		exited = true;
	}	
	
	public void currentViewChecker(){
		if(players.getCurrentPlayer().getCurrentViewAbsX()>=40) {
			players.getCurrentPlayer().setCurrentViewAbsX(0);
			players.getCurrentPlayer().setCurrentView(field.getSquare((players.getCurrentPlayer().getCurrentView().getX()+1), players.getCurrentPlayer().getCurrentView().getY()));
		}		
		if(players.getCurrentPlayer().getCurrentViewAbsY()>=40) {
			players.getCurrentPlayer().setCurrentViewAbsY(0);
			players.getCurrentPlayer().setCurrentView(field.getSquare(players.getCurrentPlayer().getCurrentView().getX(), (players.getCurrentPlayer().getCurrentView().getY()+1)));
		}
		if(players.getCurrentPlayer().getCurrentViewAbsX()<=-40) {
			players.getCurrentPlayer().setCurrentViewAbsX(0);
			players.getCurrentPlayer().setCurrentView(field.getSquare((players.getCurrentPlayer().getCurrentView().getX()-1), players.getCurrentPlayer().getCurrentView().getY()));
		}		
		if(players.getCurrentPlayer().getCurrentViewAbsY()<=-40) {
			players.getCurrentPlayer().setCurrentViewAbsY(0);
			players.getCurrentPlayer().setCurrentView(field.getSquare(players.getCurrentPlayer().getCurrentView().getX(), (players.getCurrentPlayer().getCurrentView().getY()-1)));
		}
	}
	
	public void autoMovementChecker(){
		
		if(players.getCurrentPlayer().getSelectedHero() != null){
			if(players.getCurrentPlayer().getSelectedHero().getPath() != null){
				if(!players.getCurrentPlayer().getSelectedHero().isMoving()) {
					if (players.getCurrentPlayer().getSelectedHero().getPath().isAutoMoving()) {
						try {
							robot = new Robot();
							robot.keyPress(KeyEvent.VK_SPACE);
						} catch (AWTException e) {
							System.out.print("Robot fail");
						}

					}
				}
			}
		}
		
	}
	
	public void movingHeroChecker(){
		
		int x = players.getCurrentPlayer().getSelectedHero().getCurrentSquare().getX() - Math.round(screenWidth / 2) - 1;
		int y = players.getCurrentPlayer().getSelectedHero().getCurrentSquare().getY() - Math.round(screenHeight / 2) - 1;
		
		if(x < 0) {
			x = 0;
		} else if(x > (field.getWidth() - screenWidth - 2)) {
			x = field.getWidth() - screenWidth - 2;
		}
		if(y < 0) {
			y = 0;
		} else if(y > (field.getHeight() - screenHeight - 2)) {
			y = field.getHeight() - screenHeight - 2;
		}
		
		if(players.getCurrentPlayer().getCurrentView().getX() > (x + 2)) {
			int tempY = players.getCurrentPlayer().getCurrentView().getY();
			players.getCurrentPlayer().setCurrentView(field.getSquare(x,tempY));
		}
		if(players.getCurrentPlayer().getCurrentView().getX() < (x - 2)) {
			int tempY = players.getCurrentPlayer().getCurrentView().getY();
			players.getCurrentPlayer().setCurrentView(field.getSquare(x,tempY));
		}
		if(players.getCurrentPlayer().getCurrentView().getY() > (y + 2)) {
			int tempX = players.getCurrentPlayer().getCurrentView().getX();
			players.getCurrentPlayer().setCurrentView(field.getSquare(tempX,y));
		}
		if(players.getCurrentPlayer().getCurrentView().getY() < (y - 2)) {
			int tempX = players.getCurrentPlayer().getCurrentView().getX();
			players.getCurrentPlayer().setCurrentView(field.getSquare(tempX,y));
		}
		
		if(players.getCurrentPlayer().getCurrentView().getX() < field.getSquare(x, y).getX()) {
			int i = players.getCurrentPlayer().getCurrentViewAbsX();
			players.getCurrentPlayer().setCurrentViewAbsX(i + 5);
		} else if(players.getCurrentPlayer().getCurrentView().getX() > field.getSquare(x, y).getX()) {
			int i = players.getCurrentPlayer().getCurrentViewAbsX();
			players.getCurrentPlayer().setCurrentViewAbsX(i - 5);
		} else {}
		if(players.getCurrentPlayer().getCurrentView().getY() < field.getSquare(x, y).getY()) {
			int i = players.getCurrentPlayer().getCurrentViewAbsY();
			players.getCurrentPlayer().setCurrentViewAbsY(i + 5);
		} else if(players.getCurrentPlayer().getCurrentView().getY() > field.getSquare(x, y).getY()) {
			int i = players.getCurrentPlayer().getCurrentViewAbsY();
			players.getCurrentPlayer().setCurrentViewAbsY(i - 5);
		} else {}
		
		if(players.getCurrentPlayer().getCurrentView() == field.getSquare(x,y)){
			players.getCurrentPlayer().setCurrentView(field.getSquare(x,y));
		}

	}
	
	public void endedTurn(){
		players.nextPlayer();
		turnSystem.nextTurn(players,field);
		setPopupWindow(new TurnPopupWindow(mc,getCurrentPlayer()));
	}
	
	public RandomHeroGenerator getHeroGen() {
		return heroGen;
	}
	
	public RandomItemGenerator getItemGen() {
		return itemGen;
	}
	
	public Player getCurrentPlayer() {
		return players.getCurrentPlayer();
	}
	
	public TurnSystem getTurnSystem() {
		return turnSystem;
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
	
	public CombatView getCombatView() {
		return combatView;
	}

	public void clearPath(){
		if(players.getCurrentPlayer().getSelectedHero() != null){
			if(players.getCurrentPlayer().getSelectedHero().getPath() != null){
				for(PathNode pn : players.getCurrentPlayer().getSelectedHero().getPath().getSquares()){
					if(field.getSquare(pn.getSquare().getX(), pn.getSquare().getY()).isPath()){
						field.getSquare(pn.getSquare().getX(), pn.getSquare().getY()).setPath(false);
					}
				}
				players.getCurrentPlayer().getSelectedHero().getPath().setAutoMoving(false);
				players.getCurrentPlayer().getSelectedHero().setPath(null);
			}
		}
	}
	
	public void setInCastle(boolean inCastle) {
		this.inCastle = inCastle;
	}

	public boolean isInCastle() {
		return inCastle;
	}

	public Point getMousePos(){
		return mousePos;
	}
	
	public void setCastleView(CastleView castleView) {
		this.castleView = castleView;
	}

	public CastleView getCastleView() {
		return castleView;
	}

	public void mouseChecker(){
		if(mousePos.getX()<10){
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_LEFT);
			} catch (AWTException e1) {
				System.out.print("robot fail");
			}

		}
		if(mousePos.getX()>(s.getScreenWidth()-10)){
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_RIGHT);
			} catch (AWTException e1) {
				System.out.print("robot fail");
			}

		}
		if(mousePos.getY()<10){
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_UP);
			} catch (AWTException e1) {
				System.out.print("robot fail");
			}

		}
		if(mousePos.getY()>(s.getScreenHeight()-10)){
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
			} catch (AWTException e1) {
				System.out.print("robot fail");
			}

		}
		if(popupWindow != null){
			popupWindow.mouseChecker(this);
		}
	}
	
	public void enterCastle(Castle castle){
		setCastleView(new CastleView(castle,this));
		inCastle = true;
	}
	
	public void exitCastle(){
		setCastleView(null);
		inCastle = false;
	}

	public boolean isWithinBounds(Point currentPoint, Point startPoint,Point endPoint){
		if((currentPoint.getX() >= startPoint.getX()) && (currentPoint.getX() <= endPoint.getX()) 
				&& (currentPoint.getY() >= startPoint.getY()) && (currentPoint.getY() <= endPoint.getY())){
			return true;
		}
		return false;
	}
	
	public void setPopupWindow(PopupWindow popupWindow) {
		this.popupWindow = popupWindow;
	}

	public PopupWindow getPopupWindow() {
		return popupWindow;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}
	
	public void exitGamePopup(){
		PausePopupWindow popupWindow = new PausePopupWindow(mc);
		mc.setPopupWindow(popupWindow);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(popupWindow == null){
			@SuppressWarnings("unused")
			KeyMap km = new KeyMap(e,mc,1,field);
		} else {
			popupWindow.keyPressed(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(popupWindow == null){
			@SuppressWarnings("unused")
			KeyMap km = new KeyMap(e,mc,2,field);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(popupWindow == null){
			@SuppressWarnings("unused")
			KeyMap km = new KeyMap(e,mc,3,field);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		boolean clicked = false;
		
		if(popupWindow != null){
			popupWindow.mousePressed(e, this);
			clicked = true;
		}
		if (!clicked) {
			if(inCastle){
				castleView.mousePressed(e);
				clicked = true;
			}
		}
		if((mc.getCurrentPlayer().getSelectedHero() != null) && (!clicked)){
			if(mc.getCurrentPlayer().getSelectedHero().getPath() != null){
				if(mc.getCurrentPlayer().getSelectedHero().getPath().isAutoMoving()){
					mc.getCurrentPlayer().getSelectedHero().getPath().setAutoMoving(false);
					clicked = true;
				}
			}
		}
		
		if(!clicked){
			if(isWithinBounds(getMousePos(),new Point((156-2),38),new Point((196-2),78))){
				endedTurn();
				clicked = true;
			}
			if(isWithinBounds(getMousePos(),new Point((156-2),78),new Point((196-2),118))){
				exitGamePopup();
				clicked = true;
			}
			for(int i = 0; i < 280; i += 40) {
				long x = mousePos.x;
				long y = mousePos.y;
				int xi = 210 + i;
				int ximax = 210 + i + 39;
				if((x>xi) && (x<ximax) && (y>18) && (y<58) && (i/40 < players.getCurrentPlayer().getHeroes().size())){
					ArrayList<Hero> heroes = players.getCurrentPlayer().getHeroes();
					clearPath();
					if(players.getCurrentPlayer().getSelectedHero() == players.getCurrentPlayer().getHeroes().get(i/40)){
						popupWindow = new HeroPopupWindow(this,players.getCurrentPlayer().getHeroes().get(i/40));
						movingHeroChecker();
					} else {
						players.getCurrentPlayer().selectHero(heroes.get(i/40));
						movingHeroChecker();
					}
					clicked = true;
				}
			}
		}
		
		if(!clicked){
			for(int x = 0; x < (screenWidth + 1);x++){
				for(int y = 0; y < (screenHeight + 1);y++){		
					if((mousePos.x > (x*40 - players.getCurrentPlayer().getCurrentViewAbsX())) && (mousePos.x < ((x)*40 + 40 - players.getCurrentPlayer().getCurrentViewAbsX())) 
							&& (mousePos.y > (y*40 - players.getCurrentPlayer().getCurrentViewAbsY())) && (mousePos.y < ((y)*40 + 40 - players.getCurrentPlayer().getCurrentViewAbsY()))){
						if(field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getHero() != null){
							Hero hero = field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getHero();
							if(players.getCurrentPlayer().getHeroes().contains(hero)){
								clearPath();
								players.getCurrentPlayer().selectHero(players.getCurrentPlayer().getHero(hero));
								clicked = true;
							}
						}
					}
				}
			}
		}
		
		if(!clicked && players.getCurrentPlayer().getSelectedHero() != null ){
			for(int x = 0; x < (screenWidth + 1);x++){
				for(int y = 0; y < (screenHeight + 1);y++){				
					if((mousePos.x > (x*40 - players.getCurrentPlayer().getCurrentViewAbsX())) && (mousePos.x < ((x)*40 + 40 - players.getCurrentPlayer().getCurrentViewAbsX())) 
							&& (mousePos.y > (y*40 - players.getCurrentPlayer().getCurrentViewAbsY())) && (mousePos.y < ((y)*40 + 40 - players.getCurrentPlayer().getCurrentViewAbsY()))){
						if(e.getButton() == MouseEvent.BUTTON1){
						
							clearPath();
							Path path = new Path();
							path = path.findPath(field, players.getCurrentPlayer().getSelectedHero().getCurrentSquare(), field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())));
							
							players.getCurrentPlayer().getSelectedHero().setPath(path);
							
							if(players.getCurrentPlayer().getSelectedHero() != null){
								if(players.getCurrentPlayer().getSelectedHero().getPath() != null){
									for(PathNode pn : players.getCurrentPlayer().getSelectedHero().getPath().getSquares()){
										field.getSquare(pn.getSquare().getX(), pn.getSquare().getY()).setPath(true);
									}
								}
							}
								
							
						}
						
						if(e.getButton() == MouseEvent.BUTTON3){
							try {
								robot = new Robot();
								robot.keyPress(KeyEvent.VK_M);
							} catch (AWTException e1) {
								System.out.print("robot Fail");
							}

//							Building building = new Building();
//							building.setImage(Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass1.jpg"));
//							field.getSquare(5, 5).setBuilding(building);
//							field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).setBuilding(building);
//							field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).setPassable(false);
							
						}
					}
					
				}
			}
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(popupWindow != null){
			popupWindow.mouseReleased(e, this);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos.x = (int) Math.round(e.getLocationOnScreen().getX());
		mousePos.y = (int) Math.round(e.getLocationOnScreen().getY());
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
