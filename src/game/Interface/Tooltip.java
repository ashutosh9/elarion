package game.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import game.main.MainClass;

public class Tooltip {
	
	private boolean opened;
	private Image background;
	private ArrayList<Choice> choices;
	private ArrayList<Img> images;
	private ArrayList<Text> texts;
	private static int X;
	private static int Y;
	
	public Tooltip(MainClass mc) {
		choices = new ArrayList<Choice>();
		images = new ArrayList<Img>();
		texts = new ArrayList<Text>();
		boolean loaded = false;
		while(!loaded){
			background = Toolkit.getDefaultToolkit().getImage("Images/popup/popupBack.png");
			loaded = true;
		}
		opened = true;
		setBackground(Toolkit.getDefaultToolkit().getImage("Images/tooltip/background.jpg"));
		setX(Math.round(((1280 - 285))));
		setY(Math.round(((800 - 235))));
	}
		
	public void update(long timePassed){
		
	}
	
	public void draw(Graphics g){
		
		g.drawImage(background, X, Y,280,200, null);
		
		for(Choice c : choices){
			String s = c.getText();
			Color color = new Color(220, 220, 220);
			g.setColor(color);
			Font font = new Font(Font.SERIF, Font.BOLD, 18);
			g.setFont(font);
			g.drawString(s,c.getX() + X,c.getY() + Y);
			if(c.isPressed()){
				g.drawImage(c.getButtonPressed(),c.getX() + X,c.getY() + Y,null);
			} else if(c.isHovered()) {
				g.drawImage(c.getButtonHovered(),c.getX() + X,c.getY() + Y,null);
			} else {
				g.drawImage(c.getButton(),c.getX() + X,c.getY() + Y,null);
			}
		}
		
		for(Img i : images){
			g.drawImage(i.getImg(),i.getX() + X,i.getY() + Y,null);
		}
		
		for(Text t : texts){
			g.drawString(t.getString(), t.getX() + X, t.getY() + Y);
		}
		
	}
	
	public void closePopup(){
		opened = false;
	}

	public boolean isOpened() {
		return opened;
	}

	public void mouseChecker(MainClass mc){
		for(Choice c : choices){

			Point start = new Point(c.getX() + X,c.getY() + Y);
			Point end = new Point((c.getX() + c.getButton().getWidth(null) + X),(c.getY() + c.getButton().getHeight(null) + Y));
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				c.setHovered(true);
			} else {
				c.setHovered(false);
			}
		}
	}
	
	public void mousePressed(MouseEvent e, MainClass mc){
		for(Choice c : choices){
			c.setPressed(false);
			Point start = new Point(c.getX() + X,c.getY() + Y);
			Point end = new Point((c.getX() + c.getButton().getWidth(null) + X),(c.getY() + c.getButton().getHeight(null) + Y));
			if(mc.isWithinBounds(mc.getMousePos(), start, end)){
				c.setPressed(true);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e, MainClass mc){
		for(Choice c : choices){
			Point start = new Point(c.getX() + X,c.getY() + Y);
			Point end = new Point((c.getX() + c.getButton().getWidth(null) + X),(c.getY() + c.getButton().getHeight(null) + Y));
			if((mc.isWithinBounds(mc.getMousePos(), start, end)) && (c.isPressed())){
				@SuppressWarnings("unused")
				MenuEventMap event = new MenuEventMap(c.getEvent(),mc,this);
			}
			c.setPressed(false);
		}
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ENTER){
			if(choices.size() > 0){
				for(Choice c : choices){
					if(c.getEvent() == "close"){
						this.closePopup();
					}
				}
			}
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
		private String event;
		
		public Choice(String text,String event, Image button, Image buttonPressed, Image buttonHovered){
			this.text = text;
			setEvent(event);
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

		public void setEvent(String event) {
			this.event = event;
		}

		public String getEvent() {
			return event;
		}
		
		
	}
	
	public void newChoice(String text,String event, int x,int y, Image button, Image buttonPressed, Image buttonHovered){
		Choice choice = new Choice(text,event,button,buttonPressed,buttonHovered);
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
	
	public int getX(){
		return X;
	}
	
	public void setX(int x){
		X = x;
	}
	
	public int getY(){
		return Y;
	}
	
	public void setY(int y){
		Y = y;
	}
	
	public void setBackground(Image i){
		background = i;
	}	

	

}

