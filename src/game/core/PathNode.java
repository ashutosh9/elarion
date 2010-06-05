package game.core;

import game.field.Square;

public class PathNode {
	
	private PathNode parent;
	private Square nodeSquare;
	private double heuristicCost;
	private int goCost;
	private boolean visited;
	
	
	public PathNode(Square s){
		nodeSquare = s;
	}
	
	public Square getSquare() {
		return nodeSquare;
	}
	
	public void setParentNode(PathNode n){
		parent = n;
	}
	
	public void setVisited(boolean b){
		visited  = b;
	}
	
	public boolean getVisited(){
		return visited;
	}
	public PathNode getParentNode() {
		return parent;
	}
	
	public void setHeuristic(double d){
		heuristicCost = d;
	}
	
	public void setGoCost(int i){
		goCost = i;
	}
	
	public int getGoCost(){
		return goCost;
	}
	
	public double getHeuristicCost(){
		return heuristicCost;
	}
	
	public double getFullCost(){
		return (heuristicCost + goCost);
	}
	
	public boolean equals(PathNode other){
		if(this.getSquare().getX() != other.getSquare().getX()){
			return false;
		}
		if(this.getSquare().getY() != other.getSquare().getY()){
			return false;
		}
		return true;
	}
	
}
