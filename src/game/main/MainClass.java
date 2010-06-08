package game.main;

import game.Interface.Minimap;
import game.Interface.PausePopupWindow;
import game.Interface.PopupWindow;
import game.Interface.ResourceBar;
import game.Interface.Screen;
import game.Interface.SideMenu;
import game.Interface.Tooltip;
import game.building.Building;
import game.castle.Castle;
import game.core.Path;
import game.core.PathNode;
import game.core.TurnPopupWindow;
import game.core.TurnSystem;
import game.field.Field;
import game.field.Square;
import game.graphic.CastleView;
import game.item.Item;
import game.item.RandomItemGenerator;
import game.player.Player;
import game.player.Players;
import game.resource.Resource;
import game.unit.Hero;
import game.unit.HeroPopupWindow;
import game.unit.RandomHeroGenerator;
import game.unit.TestUnits;
import game.unit.UnitTooltip;

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
	private Minimap minimap;
	private static ResourceBar resourceBar;
	private static SideMenu sideMenu;
	private PopupWindow popupWindow = null;
	
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
		Hero h = new Hero(mc);
		Hero h2 = new Hero(mc);
		h.setName("Erag Tone");
		for (int i=0; i<35; i++) {
			h.getInventory().set(i,itemGen.getRandomItem());
		}
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
		resourceBar = new ResourceBar();
		sideMenu = new SideMenu();

		

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
			screenWidth = 33;
			screenHeight = 22;
			load();
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
		
		getMinimap().update(this, field);
		
		//combatView.update(timePassed);
		
		//a.update(timePassed);
		//sprite.update(timePassed);
		
	}

	public void draw(Graphics g) throws NullPointerException {
		
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
			
	
			resourceBar.draw(g, mc);					
			sideMenu.draw(g,mc);
			
			if(popupWindow != null){
				popupWindow.draw(g);
			}
			
			if(tooltip != null){
				tooltip.draw(g);
			} else {
				tooltip = new Minimap(this,field);
			}

	
			mouseChecker();
			currentViewChecker();
			autoMovementChecker();
		}
	}

	public void load() {
		setMinimap(new Minimap(this,field));
		setTooltip(getMinimap());
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
	
	public void castleChecker(){
		
		int x = players.getCurrentPlayer().getSelectedCastle().getCurrentSquare().getX() - Math.round(screenWidth / 2) - 1;
		int y = players.getCurrentPlayer().getSelectedCastle().getCurrentSquare().getY() - Math.round(screenHeight / 2) - 1;
		
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
	
	public void setMinimap(Minimap minimap) {
		this.minimap = minimap;
	}

	public Minimap getMinimap() {
		return minimap;
	}

	public Players getPlayers(){
		return players;
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
		
		if(tooltip != null){
			tooltip.mousePressed(e, this);
			//clicked = true;
		}
		
		if (!clicked) {
			if(inCastle){
				castleView.mousePressed(e);
				clicked = true;
			}
		}
		
		if(e.getButton() == MouseEvent.BUTTON1){
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
							players.getCurrentPlayer().unselectCastles();
							players.getCurrentPlayer().selectHero(heroes.get(i/40));
							movingHeroChecker();
						}
						clicked = true;
					}
				}
				for(int i = 0; i < 280; i += 40) {
					long x = mousePos.x;
					long y = mousePos.y;
					int xi = 210 + i;
					int ximax = 210 + i + 39;
					if((x>xi) && (x<ximax) && (y>61) && (y<101) && (i/40 < players.getCurrentPlayer().getCastles().size())){
						ArrayList<Castle> castles = players.getCurrentPlayer().getCastles();
						if(players.getCurrentPlayer().getSelectedCastle() == players.getCurrentPlayer().getCastles().get(i/40)){
							enterCastle(players.getCurrentPlayer().getSelectedCastle());
						} else {
							players.getCurrentPlayer().unselectHeroes();
							clearPath();
							players.getCurrentPlayer().selectCastle(castles.get(i/40));
							castleChecker();
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
							
							
							Square s = field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY()));
							for(Castle c : players.getCurrentPlayer().getCastles()){
								for(int ix = 0; ix<3;ix++){
									for(int iy = 0;iy<3;iy++){
										if((c.getRootSquare().getX() + ix == s.getX()) && (c.getRootSquare().getY() + iy == s.getY())){
											if(players.getCurrentPlayer().getSelectedCastle() == c){
												enterCastle(players.getCurrentPlayer().getSelectedCastle());
											} else {
												players.getCurrentPlayer().unselectHeroes();
												clearPath();
												players.getCurrentPlayer().selectCastle(c);
											}
											clicked = true;
										}
									}
								}

							}
							
							
							if(!clicked){
								if(field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getHero() != null){
									Hero hero = field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())).getHero();
									if(players.getCurrentPlayer().getHeroes().contains(hero)){
										if(players.getCurrentPlayer().getSelectedHero() == hero){
											popupWindow = new HeroPopupWindow(this,hero);
										} else {
											players.getCurrentPlayer().unselectCastles();
											clearPath();
											players.getCurrentPlayer().selectHero(players.getCurrentPlayer().getHero(hero));
										}
										clicked = true;
									}
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
							
								if((players.getCurrentPlayer().getSelectedHero().getDestination() != null) && (players.getCurrentPlayer().getSelectedHero().getDestination().getX() == (x + 2 +players.getCurrentPlayer().getCurrentView().getX())) && 
										(players.getCurrentPlayer().getSelectedHero().getDestination().getY() == (y+2+players.getCurrentPlayer().getCurrentView().getY()))) {
									
									try {
										robot = new Robot();
										robot.keyPress(KeyEvent.VK_M);
									} catch (AWTException e1) {
										System.out.print("robot Fail");
									}
								} else {
									
									clearPath();
									Path path = new Path();
									path = path.findPath(field, players.getCurrentPlayer().getSelectedHero().getCurrentSquare(), field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())));
									
									players.getCurrentPlayer().getSelectedHero().setDestination(new Point((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY())));
									
									players.getCurrentPlayer().getSelectedHero().setPath(path);
									
									if(path == null){
										players.getCurrentPlayer().getSelectedHero().setDestination(null);
									}
									
									
									if(players.getCurrentPlayer().getSelectedHero() != null){
										if(players.getCurrentPlayer().getSelectedHero().getPath() != null){
											for(PathNode pn : players.getCurrentPlayer().getSelectedHero().getPath().getSquares()){
												field.getSquare(pn.getSquare().getX(), pn.getSquare().getY()).setPath(true);
											}
										}
									}
								}
									
								
							}
							

						}
						
					}
				}
			}
		} else 	if(e.getButton() == MouseEvent.BUTTON3){
			
			if(!clicked){
				for(int i = 0; i < 280; i += 40) {
					long x = mousePos.x;
					long y = mousePos.y;
					int xi = 210 + i;
					int ximax = 210 + i + 39;
					if((x>xi) && (x<ximax) && (y>18) && (y<58) && (i/40 < players.getCurrentPlayer().getHeroes().size())){
						if(players.getCurrentPlayer().getHeroes().get(i/40) != null){
							tooltip = new UnitTooltip(this,players.getCurrentPlayer().getHeroes().get(i/40));
						} 
						clicked = true;
					}
				}
			}
			
			if(!clicked){
				for(int i = 0; i < 280; i += 40) {
					long x = mousePos.x;
					long y = mousePos.y;
					int xi = 210 + i;
					int ximax = 210 + i + 39;
					if((x>xi) && (x<ximax) && (y>61) && (y<101) && (i/40 < players.getCurrentPlayer().getCastles().size())){
						if(players.getCurrentPlayer().getCastles().get(i/40) != null){
							Castle c = players.getCurrentPlayer().getCastles().get(i/40);
							Tooltip t = new Tooltip(this);
							Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
							t.newImg(img, 3, 3);
							
							img = c.getIcon().getScaledInstance(56, 56, 1);
							t.newImg(img, 5, 5);
							
							String s = "Castle";
							
							t.newText(s, 70, 30);
							setTooltip(t);
							
							s = new String("Owner : " + c.getOwner().getName());
							t.newText(s, 70, 45);
							
							s = new String("Buildings available : " + c.getBuildLimit());
							t.newText(s, 70, 60);
							
							String hero = "None";
							
							if(c.getGarrisonSquare().getHero() != null){
								hero = c.getGarrisonSquare().getHero().getName();
							}
							s = new String("Garrisoned Hero : ");
							t.newText(s, 20, 100);
							s = new String("		" + hero);
							t.newText(s, 20, 115);
							
							hero = "None";
							if(c.getCurrentSquare().getHero() != null){
								hero = c.getCurrentSquare().getHero().getName();
							}
							s = new String("Visiting Hero : ");
							t.newText(s, 20, 155);
							s = new String("		" + hero);
							t.newText(s, 20, 170);
						}
						clicked = true;
					}
				}
			}
			
			if(!clicked){
				if(isWithinBounds(getMousePos(),new Point((156-2),38),new Point((196-2),78))){
					Tooltip t = new Tooltip(this);
					Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					t.newImg(img, 3, 3);
					
					img = Toolkit.getDefaultToolkit().getImage("Buttons/menu/hourglass.jpg").getScaledInstance(56, 56, 1);
					t.newImg(img, 5, 5);
					
					String s = "End Turn";
					
					t.newText(s, 70, 30);
					setTooltip(t);
					clicked = true;
				}
				if(isWithinBounds(getMousePos(),new Point((156-2),78),new Point((196-2),118))){
					
					Tooltip t = new Tooltip(this);
					Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					t.newImg(img, 3, 3);
					
					img = Toolkit.getDefaultToolkit().getImage("Buttons/menu/menu.jpg").getScaledInstance(56, 56, Image.SCALE_SMOOTH);
					t.newImg(img, 5, 5);
					
					String s = "Menu";
					
					t.newText(s, 70, 30);
					setTooltip(t);
					clicked = true;
				}
			}
			
			if(!clicked){
				for(int x = 0; x < (screenWidth + 1);x++){
					for(int y = 0; y < (screenHeight + 1);y++){				
						if((mousePos.x > (x*40 - players.getCurrentPlayer().getCurrentViewAbsX())) && (mousePos.x < ((x)*40 + 40 - players.getCurrentPlayer().getCurrentViewAbsX())) 
								&& (mousePos.y > (y*40 - players.getCurrentPlayer().getCurrentViewAbsY())) && (mousePos.y < ((y)*40 + 40 - players.getCurrentPlayer().getCurrentViewAbsY()))){
							Square s = field.getSquare((x + 2 +players.getCurrentPlayer().getCurrentView().getX()),(y+2+players.getCurrentPlayer().getCurrentView().getY()));
							for(Castle c : players.getCurrentPlayer().getCastles()){
								for(int ix = 0; ix<3;ix++){
									for(int iy = 0;iy<3;iy++){
										if((c.getRootSquare().getX() + ix == s.getX()) && (c.getRootSquare().getY() + iy == s.getY())){
											Tooltip t = new Tooltip(this);
											Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
											t.newImg(img, 3, 3);
											
											img = c.getIcon().getScaledInstance(56, 56, 1);
											t.newImg(img, 5, 5);
											
											String str = "Castle";
											
											t.newText(str, 70, 30);
											setTooltip(t);
											
											str = new String("Owner : " + c.getOwner().getName());
											t.newText(str, 70, 45);
											
											str = new String("Buildings available : " + c.getBuildLimit());
											t.newText(str, 70, 60);
											
											String hero = "None";
											
											if(c.getGarrisonSquare().getHero() != null){
												hero = c.getGarrisonSquare().getHero().getName();
											}
											str = new String("Garrisoned Hero : ");
											t.newText(str, 20, 100);
											str = new String("		" + hero);
											t.newText(str, 20, 115);
											
											hero = "None";
											if(c.getCurrentSquare().getHero() != null){
												hero = c.getCurrentSquare().getHero().getName();
											}
											str = new String("Visiting Hero : ");
											t.newText(str, 20, 155);
											str = new String("		" + hero);
											t.newText(str, 20, 170);
											setTooltip(t);
											clicked = true;
										}
									}
								}

							}
							if((s.getHero() != null) && (!clicked)){
								setTooltip(new UnitTooltip(this, s.getHero()));
							} else if((s.getResource() != null) && (!clicked)){
								Tooltip t = new Tooltip(this);
								if(s.getResource().getName() == "gold"){
									Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									t.newImg(img, 3, 3);
									img = Toolkit.getDefaultToolkit().getImage("Buttons/resource/gold.jpg").getScaledInstance(56, 56, Image.SCALE_SMOOTH);
									t.newImg(img, 5, 5);
									String string = new String("X : " + s.getX() + " , Y : " + s.getY());
									t.newText(string, 70, 45);
									string = "Gold";
									t.newText(string, 70, 30);
								}
								if(s.getResource().getName() == "wood"){
									Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									t.newImg(img, 3, 3);
									img = Toolkit.getDefaultToolkit().getImage("Buttons/resource/wood.jpg").getScaledInstance(56, 56, Image.SCALE_SMOOTH);
									t.newImg(img, 5, 5);
									String string = new String("X : " + s.getX() + " , Y : " + s.getY());
									t.newText(string, 70, 45);
									string = "Wood";
									t.newText(string, 70, 30);
								}
								if(s.getResource().getName() == "stone"){
									Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									t.newImg(img, 3, 3);
									img = Toolkit.getDefaultToolkit().getImage("Buttons/resource/stone.jpg").getScaledInstance(56, 56, Image.SCALE_SMOOTH);
									t.newImg(img, 5, 5);
									String string = new String("X : " + s.getX() + " , Y : " + s.getY());
									t.newText(string, 70, 45);
									string = "Stone";
									t.newText(string, 70, 30);
								}
								setTooltip(t);
							} else if((s.getItem() != null) && (!clicked)){
								Tooltip t = new Tooltip(this);
								if(s.getItem().getType() == "chest"){
									Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									t.newImg(img, 3, 3);
									img = Toolkit.getDefaultToolkit().getImage("src/game/images/resource/chest.png").getScaledInstance(56, 56, Image.SCALE_SMOOTH);
									t.newImg(img, 9, 9);
									String string = new String("X : " + s.getX() + " , Y : " + s.getY());
									t.newText(string, 70, 45);
									string = "Treasure Chest";
									t.newText(string, 70, 30);
								} else {
									Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									t.newImg(img, 3, 3);
									img = s.getItem().getImage().getScaledInstance(56, 56, Image.SCALE_SMOOTH);
									t.newImg(img, 5, 5);
									String string = new String("X : " + s.getX() + " , Y : " + s.getY());
									t.newText(string, 70, 45);
									string = s.getItem().getName();
									t.newText(string, 70, 30);
								}
								setTooltip(t);
								
							} else if((s.getBuilding() != null) && (!clicked)){
								
							} else if(!clicked) {
								Tooltip t = new Tooltip(this);
								Image img = Toolkit.getDefaultToolkit().getImage("Images/heroes/hero.jpg").getScaledInstance(60, 60, Image.SCALE_SMOOTH);
								t.newImg(img, 3, 3);
								img = Toolkit.getDefaultToolkit().getImage("src/game/images/terrain/Grass2.jpg").getScaledInstance(56, 56, Image.SCALE_SMOOTH);
								t.newImg(img, 5, 5);
								String string = new String("X : " + s.getX() + " , Y : " + s.getY());
								t.newText(string, 70, 45);
								string = "Grass";
								t.newText(string, 70, 30);
								setTooltip(t);
							}
							
							break;
						}
					}
				}					
			}
			

			
			
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(tooltip != null){
			tooltip.mouseReleased(e, this);
		}
		if(e.getButton() == MouseEvent.BUTTON3){
			tooltip = getMinimap();
		}
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