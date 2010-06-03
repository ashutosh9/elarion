package game.core;

import java.util.ArrayList;

import game.field.Field;
import game.field.Square;

public class Path {
	
	private Square startSquare;
	private Square destinationSquare;
	private ArrayList<PathNode> path;
	private boolean autoMoving;
	
	public Path(){
	}
	
	public Path(ArrayList<PathNode> path2,Square startSquare,Square destinationSquare){
		this.path = path2;
		this.destinationSquare = destinationSquare;
		this.startSquare = startSquare;
		autoMoving = false;
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
		
		while(!foundPath && openList.size() > 0 && openList.size() < 2000) {
//			System.out.print("SIZE   :   " + openList.size() + "\n");
			double lowestCost = openList.get(0).getFullCost();
			int index = 0;
//			for(PathNode node : openList){
//				if(node.equals(current)){
//					node = current;
//					break;
//				}
//			}
			for(PathNode node : openList){

				//System.out.print("GO COST : " + node.getGoCost() + "\n");
				if(node.getFullCost() < lowestCost){
					lowestCost = node.getFullCost();
					index = openList.indexOf(node);
//					current = new PathNode(node.getSquare());
//					//System.out.print("NODE GO cost : " + node.getGoCost() + "  ");
//					current.setGoCost(node.getGoCost());
//					//System.out.print("Current GO cost : " + current.getGoCost() + "  ");
//					current.setHeuristic(node.getHeuristicCost());
//					current.setParentNode(node.getParentNode());
					//current = node;
				}
			}
			current = openList.get(index);
			
//			current = new PathNode(openList.get(0).getSquare());
//			current.setGoCost(openList.get(0).getGoCost());
//			current.setHeuristic(openList.get(0).getHeuristicCost());
//			current.setParentNode(openList.get(0).getParentNode());
			
			if((current.getSquare().getX() == destination.getSquare().getX()) && (current.getSquare().getY() == destination.getSquare().getY())) {
				foundPath = true;
				destination = current;
				break;
			}
			else {
				
				for(PathNode node : openList){
					if((node.getSquare().getX() == current.getSquare().getX()) && (node.getSquare().getY() == current.getSquare().getY())){
//						System.out.print("Removed node");
						closedList.add(node);
						openList.remove(node);
//						System.out.print("SIZE   :   " + openList.size() +"and working with : " + current.getFullCost() +  "\n");
						break;
					}
				}
				
				for(int x = -1; x <2 ; x++){
					for(int y = -1; y < 2; y++){
						
						if((x == 0) && (y == 0)) {
							continue;
						}
						
						int xp = current.getSquare().getX() + x;
						int xy = current.getSquare().getY() + y;
						
						Square neighbourSquare = field.getSquare(xp, xy);
						PathNode neighbourNode = new PathNode(neighbourSquare);
						if(neighbourNode.getSquare().isPassable()){
							
							int goCost = 0;
							if(Math.abs(x)==Math.abs(y)){
								goCost = current.getGoCost();
								goCost += 20;
							} else {
								goCost = current.getGoCost();
								goCost += 15;
							}
							double nextStepCost = goCost + current.getHeuristicCost();
//							neighbourNode.setGoCost(goCost);
//							neighbourNode.setHeuristic(Math.sqrt(Math.pow((neighbourNode.getSquare().getX() - destination.getSquare().getX()), 2) + Math.pow((neighbourNode.getSquare().getY() - destination.getSquare().getY()), 2)));
							if(nextStepCost < neighbourNode.getFullCost()){
								if(openList.contains(neighbourNode)){
									openList.remove(neighbourNode);
								}
								
								if(closedList.contains(neighbourNode)){
									closedList.remove(neighbourNode);
								}
							}
							
//							for(PathNode node : closedList){
//								if((node.getSquare().getX() == neighbourNode.getSquare().getX()) && (node.getSquare().getY() == neighbourNode.getSquare().getY())){
//									if(neighbourNode.getFullCost() < node.getFullCost()){
////										node.setGoCost(neighbourNode.getGoCost());
////										node.setParentNode(current);
//										indexOfNode = closedList.indexOf(node);
//										done = true;
//									}
//								}
//							}
//
//							if(done) {
//								closedList.remove(indexOfNode);
//							}
//							
//							for(PathNode node : openList){
//								if((node.getSquare().getX() == neighbourNode.getSquare().getX()) && (node.getSquare().getY() == neighbourNode.getSquare().getY())){
//									if(neighbourNode.getFullCost() < node.getFullCost()){
////										node.setGoCost(neighbourNode.getGoCost());
////										node.setParentNode(current);
//										indexOfNode2 = openList.indexOf(node);
//										done2 = true;
//									}
//								}
//							}
//							if(done2){
//								openList.remove(indexOfNode2);
//							}
							
							if(!(openList.contains(neighbourNode)) && !(closedList.contains(neighbourNode))){
							
						//	if(((!done) && (!done2))){
								//neighbourNode.setHeuristic(Math.sqrt(Math.pow((neighbourNode.getSquare().getX() - destination.getSquare().getX()), 2) + Math.pow((neighbourNode.getSquare().getY() - destination.getSquare().getY()), 2)));
							//	System.out.print("added node with GO cost : " + neighbourNode.getGoCost() + "   " + "\n");
								openList.add(neighbourNode);
								openList.contains(neighbourNode);
								int i = openList.indexOf(neighbourNode);
								openList.get(i).setParentNode(current);
								openList.get(i).setHeuristic(15*(Math.sqrt(Math.pow((neighbourNode.getSquare().getX() - destination.getSquare().getX()), 2) + Math.pow((neighbourNode.getSquare().getY() - destination.getSquare().getY()), 2))));
								openList.get(i).setGoCost(goCost);
//								System.out.print("\n  added with GO cost : "+ openList.get(i).getGoCost() + " and current FULL cost : " + openList.get(i).getFullCost() + "\n");
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

	public void setAutoMoving(boolean autoMoving) {
		this.autoMoving = autoMoving;
	}

	public boolean isAutoMoving() {
		return autoMoving;
	}
	
}
