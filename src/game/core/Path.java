package game.core;

import java.util.ArrayList;

import game.field.Field;
import game.field.Square;

public class Path {
	
	private Square startSquare;
	private Square destinationSquare;
	private int movementCost;
	private PathNode[] path;
	
	public Path(){
	}
	
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
	
	public Path findPath(Field field,Square startSquare,Square destinationSquare){
		
		boolean foundPath = false;
		
		PathNode start = new PathNode(startSquare);
		PathNode destination = new PathNode(destinationSquare);
		PathNode current = start;
		start.setGoCost(0);
		start.setHeuristic(Math.sqrt(Math.pow((start.getSquare().getX() - destination.getSquare().getX()), 2) + Math.pow((start.getSquare().getY() - destination.getSquare().getY()), 2)));
		//System.out.print("Start full cost : " + start.getFullCost());
		
		ArrayList<PathNode> openList = new ArrayList<PathNode>();
		ArrayList<PathNode> closedList = new ArrayList<PathNode>();
		
		openList.add(start);
		
		while(!foundPath && openList.size() > 0) {
			
			for(PathNode node : openList){
				if(node.getFullCost() < current.getFullCost()){
					current = node;
				}
			}
			
			if(current == destination){
				foundPath = true;
			}
			else {
				
				for(PathNode node : openList){
					if(node == current){
						closedList.add(node);
					}
				}
				
				for(int x = -1; x <2 ; x++){
					for(int y = -1; y < 2; y++){
						
						boolean done = false;
						
						if((x == 0) && (y == 0)) {
							continue;
						}
						
						int xp = current.getSquare().getX() + x;
						int xy = current.getSquare().getY() + y;
						
						Square neighbourSquare = field.getSquare(xp, xy);
						PathNode neighbourNode = new PathNode(neighbourSquare);
						
						for(PathNode node : closedList){
							if((node.getSquare().getX() == neighbourNode.getSquare().getX()) && (node.getSquare().getY() == neighbourNode.getSquare().getY())){
								if(neighbourNode.getGoCost() < node.getGoCost()){
									node.setGoCost(neighbourNode.getGoCost());
									node.setParentNode(current);
									done = true;
								}
							}
						}
						
						for(PathNode node : openList){
							if((node.getSquare().getX() == neighbourNode.getSquare().getX()) && (node.getSquare().getY() == neighbourNode.getSquare().getY())){
								if(neighbourNode.getGoCost() < node.getGoCost()){
									node.setGoCost(neighbourNode.getGoCost());
									node.setParentNode(current);
									done = true;
								}
							}
						}
						
						if(!done){
							if(x==y){
								neighbourNode.setGoCost(150);
							} else {
								neighbourNode.setGoCost(100);
							}
							neighbourNode.setHeuristic(Math.sqrt(Math.pow((neighbourNode.getSquare().getX() - destination.getSquare().getX()), 2) + Math.pow((neighbourNode.getSquare().getY() - destination.getSquare().getY()), 2)));
							openList.add(neighbourNode);
						}
					
					}
				}
			}
		}
		
		
		if(destination.getParentNode()==null){
			return null;
		}
		
		ArrayList<PathNode> path = new ArrayList<PathNode>();
		
		PathNode target = destination;
		while (target != start) {
			Square s = new Square(target.getSquare().getX(), target.getSquare().getY());
			path.add(0,new PathNode(s));

			target = target.getParentNode();
		}
		Square s = new Square(startSquare.getX(), startSquare.getY());
		path.add(0,new PathNode(s));
		PathNode[] pathA = (PathNode[]) path.toArray();
		
		Path finalPath = new Path(pathA,startSquare,destinationSquare, destination.getGoCost());

		return finalPath;
		
	}
	
}
