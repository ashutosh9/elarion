package game.building;

import game.field.Square;

public interface IBuilding {
	
		public abstract int getX();
		
		public abstract int getY();
		
		public abstract Type getType();
		
		public abstract boolean getPassable();
		
		public abstract Event getEvent();
		
		public abstract Gather getGather();
		
		public abstract void setBimage(String s);
		
		public abstract void setX(int x);
		
		public abstract void setY(int y);
		
		public abstract void setType(Type t);
		
		public abstract void setPassable(boolean b);
		
		public abstract void setEvent(Event e);
		
		public abstract void removeEvent();
		
		public abstract void setGather(Gather g);
		
		public abstract void removeGather();
		
		public abstract Square[] getOccupiedSquares();
		
		public abstract void setupSquares(); // gets building event and sets it to square
		
		public abstract void drawBuilding(); // checks if the building is in the visible area and draws it BEFORE menu items and stuff 
		
}
