package game.main;

import java.awt.Image;
import java.util.ArrayList;

public class Animation {
	
	private ArrayList<OneScene> scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;
	
	public Animation(){
		scenes = new ArrayList<OneScene>();
		totalTime = 0;
		start();
	}
	
	public synchronized void addScene(Image i, long t){
		totalTime += t;
		scenes.add(new OneScene(i, totalTime));		
	}
	
	public synchronized void start(){
		movieTime = 0;
		sceneIndex = 0;
	}
	
	public synchronized void update(long timePassed){
		if(scenes.size()>1) {
			movieTime += timePassed;
			if(movieTime >= totalTime) {
				movieTime = 0;
				sceneIndex = 0;
			}
			while(movieTime > getScene(sceneIndex).endTime){
				sceneIndex++;
			}
		}
	}
	
	public synchronized Image getImage(){
		if(scenes.size()==0){
			return null;
		}else {
			return getScene(sceneIndex).pic;
		}
	}
	
	public long getTotalTime(){
		return totalTime;
	}
	
	public ArrayList<Image> getImages(){
		ArrayList<Image> list = new ArrayList<Image>();
		for(OneScene s : scenes) {
			list.add(s.getImage());
		}
		return list;
	}
	
	private OneScene getScene(int x){
		return (OneScene)scenes.get(x);
	}
	
/*	@SuppressWarnings("unused")
	private Image getSceneImage(int x){
		return scenes.get(x).getImage();
	}
	
	@SuppressWarnings("unused")
	private int getTotalScenes(){
		return scenes.size();
	}*/
	
	private class OneScene{
		Image pic;
		long endTime;
		
		public OneScene(Image pic, long endTime){
			this.pic = pic;
			this.endTime = endTime;
		}
		
		public Image getImage(){
			return pic;
		}
		
	}
	
	
	
}
