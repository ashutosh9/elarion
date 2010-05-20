package game.core;

import java.util.ArrayList;

import game.field.Field;
import game.field.Square;

public class Path {
	
	private Square startSquare;
	private Square destinationSquare;
	private ArrayList<PathNode> path;
	
	public Path(){
	}
	
	public Path(ArrayList<PathNode> path2,Square startSquare,Square destinationSquare){
		this.path = path2;
		this.destinationSquare = destinationSquare;
		this.startSquare = startSquare;
	}
	
	public PathNode getNode(int x) {
		return path.get(x);
	}
	
	public Square getSquare(int x) {
		return path.get(x).getSquare();
	}
	
	public Square getStartSquare() {
		return startSquare;
	}
	
	public Square getDestinationSquare() {
		return destinationSquare;
	}
	
	public ArrayList<PathNode> getSquares(){
		return path;
	}
	
	public Path findPath(Field field,Square startSquare,Square destinationSquare){
		
		boolean foundPath = false;
		
		PathNode start = new PathNode(startSquare);
		PathNode destination = new PathNode(destinationSquare);
		PathNode current = start;
		start.setGoCost(0);
		start.setHeuristic(Math.sqrt(Math.pow((start.getSquare().getX() - destination.getSquare().getX()), 2) + Math.pow((start.getSquare().getY() - destination.getSquare().getY()), 2)));
		
		ArrayList<PathNode> openList = new ArrayList<PathNode>();
		ArrayList<PathNode> closedList = new ArrayList<PathNode>();
		
		openList.add(start);
		
		while(!foundPath && openList.size() > 0 && openList.size() < 1000) {
			
			for(PathNode node : openList){
				if(node.getFullCost() < current.getFullCost()){
					current = node;
				}
			}
			
			if((current.getSquare().getX() == destination.getSquare().getX()) && (current.getSquare().getY() == destination.getSquare().getY())) {
				foundPath = true;
				destination = current;
			}
			else {
				
				int i = 32000;
				
				for(PathNode node : openList){
					if(node == current){
						closedList.add(node);
						i = openList.indexOf(node);
					}
				}
				
				if(i!=32000){
					openList.remove(i);
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
						if(neighbourNode.getSquare().isPassable()){
							
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
									neighbourNode.setGoCost(current.getGoCost() + 150);
								} else {
									neighbourNode.setGoCost(current.getGoCost() + 100);
								}
								neighbourNode.setParentNode(current);
								neighbourNode.setHeuristic(Math.sqrt(Math.pow((neighbourNode.getSquare().getX() - destination.getSquare().getX()), 2) + Math.pow((neighbourNode.getSquare().getY() - destination.getSquare().getY()), 2)));
								openList.add(neighbourNode);
							}
						
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
		while((target.getSquare().getX() != startSquare.getX()) || (target.getSquare().getY() != startSquare.getY())) {
			Square s = new Square(target.getSquare().getX(), target.getSquare().getY());
			path.add(0,new PathNode(s));
			target = target.getParentNode();
		}
		//PathNode[] pathA = (PathNode[]) path.toArray();
		
		Path finalPath = new Path(path,startSquare,destinationSquare);

		return finalPath;
		
	}
	
}
