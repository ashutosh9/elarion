package game.building;

import java.awt.Image;

import game.field.Square;

public interface IBuilding {
	
		public abstract int getX();
		
		public abstract int getY();
		
		public abstract BuildingType getType();
		
		public abstract boolean getPassable();
		
		public abstract BuildingEvent getEvent();
		
		public abstract void setImage(Image i);
		
		public abstract Image getImage();
		
		public abstract void setX(int x);
		
		public abstract void setY(int y);
		
		public abstract void setType(BuildingType t);
		
		public abstract void setPassable(boolean b);
		
		public abstract void setEvent(BuildingEvent e);
		
		public abstract void removeEvent();
		
		public abstract void removeGather();
		
		public abstract Square[] getOccupiedSquares();
		
		public abstract void setupSquares(); // gets building event and sets it to square
		
}
