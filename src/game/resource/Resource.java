package game.resource;

import java.awt.Image;

public class Resource {
	private Image img;
	private String name;
	private long amount;
	private int income;
	
	public Resource(String s, int i, long a, Image img){
		setName(s);
		setIncome(i);
		setAmount(a);
		setImage(img);
	}
	
	public void setImage(Image img){
		this.img = img;
	}
	
	public void setName(String s){
		name = s;
	}
	
	public void setAmount(long l){
		amount = l;
	}
	
	public void addAmount(long l){
		amount += l;
	}
	
	public void removeAmount(long l){
		amount -= l;
	}
	
	public void setIncome(int i){
		income = i;
	}
	
	public void addIncome(int i){
		income += i;
	}
	
	public void removeIncome(int i){
		income -= i;
	}
	
	public String getName(){
		return name;
	}
	
	public long getAmount(){
		return amount;
	}
	
	public int getIncome(){
		return income;
	}
	
	public Image getImage(){
		return img;
	}	
}
