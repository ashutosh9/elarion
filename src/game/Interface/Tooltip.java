package game.Interface;

public class Tooltip {
	
	String text;
	//Images for background etc
	//method for drawing it on the proper location - requires coordinates and graphics object
	public Tooltip(String s){
		text = s;
	}
	
	public void setTooltip(String s){
		text = s;
	}
	
	public String getTooltip(){
		return text;
	}
	
}
