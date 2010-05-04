package game.core;

import game.field.Square;

public class Path {
	
	private Square startSquare;
	private Square destinationSquare;
	private int movementCost;
	private PathNode[] path;
	
	public Path(PathNode[] pathA,Square startSquare,Square destinationSquare,int movementCost){
		this.path = pathA;
		this.destinationSquare = destinationSquare;
		this.movementCost = movementCost;
		this.startSquare = startSquare;
	}
	
	public int getMovementCost() {
		return movementCost;
	}
	
	public PathNode getNode(int x) {
		return path[x];
	}
	
	public Square getSquare(int x) {
		return path[x].getSquare();
	}
	
	public Square getStartSquare() {
		return startSquare;
	}
	
	public Square getDestinationSquare() {
		return destinationSquare;
	}
	
	public PathNode[] getSquares(){
		return path;
	}
	
}
