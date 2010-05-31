package game.Interface;

import java.awt.Cursor;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Screen {
	
	private GraphicsDevice videoCard;
	private JFrame f;
	
	public Screen(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		videoCard = env.getDefaultScreenDevice(); // video card gets access to monitor screen
	}
	
	//get all display modes 
	public DisplayMode[] getCompatibleDisplayModes(){
		return videoCard.getDisplayModes();
	}
	
	//compares all compatible display modes to video card display modes
	public DisplayMode findCompatibleMode(DisplayMode modes[]){
		DisplayMode goodModes[] = videoCard.getDisplayModes();
		for(int x=0;x<modes.length;x++){
			for (DisplayMode goodMode : goodModes) { //			for(int y=0;y<goodModes.length;y++){
				if(dModeMatches(modes[x],goodMode));
				return modes[x];
			}	
		}
		return null;
	}

	public DisplayMode getDisplayMode(){
		return videoCard.getDisplayMode();
	}
	
	private boolean dModeMatches(DisplayMode dm1, DisplayMode dm2) {
		if(dm1.getWidth() != dm2.getWidth() || dm1.getHeight() != dm2.getHeight()) {
			return false;
		}
		//DisplayMode.BIT_DEPTH_MULTI returns value of the bit depth if there are multiple supported
		if(dm1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && dm2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
				dm1.getBitDepth() != dm2.getBitDepth()) { 
			return false;
		}
		if(dm1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && dm2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && 
				dm1.getRefreshRate() != dm2.getRefreshRate()){
			return false;
		}
		return true;
	}
	
	public void setFullScreen(DisplayMode dm) {
		f = new JFrame();
		f.setUndecorated(true);
		f.setIgnoreRepaint(true);
		f.setResizable(false);
		videoCard.setFullScreenWindow(f);
		
		if(dm != null && videoCard.isFullScreenSupported()){
			try {
				videoCard.setDisplayMode(dm);
			} catch (Exception ex) {}
		}
		f.createBufferStrategy(2);
		Image c = Toolkit.getDefaultToolkit().getImage("src/game/images/cursors/SwordCursor.png");
		Point hotSpot = new Point(0,0); 
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(c, hotSpot, "Sword");  
		f.setCursor(cursor);
	}
	
	public Graphics2D getGraphics(){
		Window w = videoCard.getFullScreenWindow();
		if(w != null) {
			BufferStrategy bs = w.getBufferStrategy();
			return (Graphics2D)bs.getDrawGraphics();
		} else {
			return null;
		}
	}
	
	public void update(){
		Window w = videoCard.getFullScreenWindow();
		if(w != null){
			BufferStrategy bs = w.getBufferStrategy();
			if(!bs.contentsLost()){
				bs.show();
			}
		}
	}
	
	public void setCursor(Image i,String s){ //image and name
		Point hotSpot = new Point(0,0); 
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(i, hotSpot, s);  
		f.setCursor(cursor);
	}
	
	public Window getFullScreenWindow(){
		return videoCard.getFullScreenWindow();
	}
	
	public int getScreenWidth(){
		Window w = videoCard.getFullScreenWindow();
		if(w != null){
			return w.getWidth();
		} else {
			return 0;
		}
	}
	
	public int getScreenHeight(){
		Window w = videoCard.getFullScreenWindow();
		if(w != null){
			return w.getHeight();
		} else {
			return 0;
		}
	}
	
	public void restoreScreen(){
		Window w = videoCard.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		videoCard.setFullScreenWindow(null);
	}
	
	public BufferedImage createCompatibleImage(int width, int height, int transparency){
		Window w = videoCard.getFullScreenWindow();
		if(w != null){
			GraphicsConfiguration gc = w.getGraphicsConfiguration();
			return gc.createCompatibleImage(width,height,transparency);
		} else {
			return null;
		}
	}
	
	public JFrame getFrame(){
		return f;
	}
	
}
