package game.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PopupMenu {
	
	private Image background;
	private ArrayList<Choice> choices;
	private ArrayList<Img> images;
	private ArrayList<Text> texts;
	private static final int constX = 500;
	private static final int constY = 400;
	
	public PopupMenu(MainClass mc){
	}
	
	public void update(int timePassed){
		
	}
	
	public void draw(Graphics g){
		
		g.drawImage(background, constX, constY, null);
		
		for(Choice c : choices){
			String s = c.getText();
			g.drawString(s,c.getX() + constX,c.getY() + constY);
			if(c.isPressed()){
				g.drawImage(c.getButtonPressed(),c.getX() + constX,c.getY() + constY,null);
			} else if(c.isHovered()) {
				g.drawImage(c.getButtonHovered(),c.getX() + constX,c.getY() + constY,null);
			} else {
				g.drawImage(c.getButton(),c.getX() + constX,c.getY() + constY,null);
			}
		}
		
		for(Img i : images){
			g.drawImage(i.getImg(),i.getX() + constX,i.getY() + constY,null);
		}
		
		for(Text t : texts){
			g.drawString(t.getString(), t.getX() + constX, t.getY() + constY);
		}
	}
	
	public void mouseMoved(MouseEvent e,MainClass mc){
		for(Choice c : choices){
			c.setHovered(false);
			Point start = new Point(c.getX(),c.getY());
			Point end = new Point((c.getX() + c.getButton().getWidth(null)),(c.getY() + c.getButton().getHeight(null)));
			if(mc.withinBounds(mc.getMousePos(), start, end)){
				c.setHovered(true);
			}
		}
	}
	
	public void mousePressed(MouseEvent e, MainClass mc){
		for(Choice c : choices){
			c.setPressed(false);
			Point start = new Point(c.getX(),c.getY());
			Point end = new Point((c.getX() + c.getButton().getWidth(null)),(c.getY() + c.getButton().getHeight(null)));
			if(mc.withinBounds(mc.getMousePos(), start, end)){
				c.setPressed(true);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e, MainClass mc){
		for(Choice c : choices){
			Point start = new Point(c.getX(),c.getY());
			Point end = new Point((c.getX() + c.getButton().getWidth(null)),(c.getY() + c.getButton().getHeight(null)));
			if((mc.withinBounds(mc.getMousePos(), start, end)) && (c.isPressed())){
				//execute event
			}
			c.setPressed(false);
		}
	}
	
	private class Choice{
		
		private String text;
		private Image button;
		private Image buttonPressed;
		private Image buttonHovered;
		private boolean pressed;
		private boolean hovered;
		private int x;
		private int y;
		
		public Choice(String s, Image button, Image buttonPressed, Image buttonHovered){
			text = s;
			this.button = button;
			this.buttonPressed = buttonPressed;
			this.buttonHovered = buttonHovered;
			setPressed(false);
			setHovered(false);
		}
		
		public String getText(){
			return text;
		}
		
		public Image getButton(){
			return button;
		}
		
		public Image  getButtonPressed(){
			return buttonPressed;
		}
		
		public Image getButtonHovered(){
			return buttonHovered;
		}

		public void setPressed(boolean pressed) {
			this.pressed = pressed;
		}

		public boolean isPressed() {
			return pressed;
		}

		public void setHovered(boolean hovered) {
			this.hovered = hovered;
		}

		public boolean isHovered() {
			return hovered;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getX() {
			return x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getY() {
			return y;
		}
		
		
	}
	
	public void newChoice(String s,int x,int y, Image button, Image buttonPressed, Image buttonHovered){
		Choice choice = new Choice(s,button,buttonPressed,buttonHovered);
		choice.setX(x);
		choice.setY(y);
		choices.add(choice);
	}
	
	private class Img{
		
		private Image img;
		private int x;
		private int y;
		
		public Img(Image img, int x, int y){
			this.setImg(img);
			this.setX(x);
			this.setY(y);
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getX() {
			return x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getY() {
			return y;
		}

		public void setImg(Image img) {
			this.img = img;
		}

		public Image getImg() {
			return img;
		}
		
	}
	
	public void newImg(Image img,int x,int y){
		Img image = new Img(img,x,y);
		images.add(image);
	}
	
	private class Text{
		
		private String string;
		private int x;
		private int y;
		
		public Text(String s, int x, int y){
			setString(s);
			this.setX(x);
			this.setY(y);
		}

		public void setString(String string) {
			this.string = string;
		}

		public String getString() {
			return string;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getX() {
			return x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getY() {
			return y;
		}
		
	}
	
	public void newText(String s, int x,int y){
		Text text = new Text(s,x,y);
		texts.add(text);
	}
	

}
