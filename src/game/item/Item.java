package game.item;

import java.awt.Image;
import java.awt.Toolkit;

public class Item {

	private Image image;
	private String type;
	private String name;
	
	public Item(String type, Image img){
		name = new String("?");
		this.type = type;
		this.image = img;
		if(type == null){
			type = "armor";
		}
		if(image == null){
			image = Toolkit.getDefaultToolkit().getImage("Images/items/unknown_item.jpg");
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
