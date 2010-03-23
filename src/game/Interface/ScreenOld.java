package game.Interface;

import java.awt.*;
import javax.swing.JFrame;

public class ScreenOld {
	
	private GraphicsDevice videoCard;
	
	public ScreenOld() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		videoCard = env.getDefaultScreenDevice();
	}
	
	public void setFullScreen(DisplayMode dm, JFrame window) {
		window.setUndecorated(true);
		window.setResizable(false);
		videoCard.setFullScreenWindow(window);
		
		if(dm != null && videoCard.isDisplayChangeSupported()) {
			try {
				videoCard.setDisplayMode(dm);
			} catch (Exception ex) {}
		}
	}
	
	public Window getFullScreenWindow(){
		return videoCard.getFullScreenWindow();
	}
	
	public void restoreScreen(){
		Window w = videoCard.getFullScreenWindow();
		if(w != null) {
			w.dispose();
		}
		videoCard.setFullScreenWindow(null);
	}
}
