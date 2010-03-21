package game.core;

import game.field.Field;
import game.field.Square;
import java.util.ArrayList;

public class PathfindingSystem {
	
	private int maxSearchDistance = 200;
	
	public Path findPath(Field field, Square startSquare, Square destinationSquare, Object maxDepth){
		
		ArrayList<PathNode> openList = new ArrayList<PathNode>(200);
		ArrayList<PathNode> closedList = new ArrayList<PathNode>(200);
		PathNode currentNode = new PathNode(startSquare);
		PathNode destinationNode = new PathNode(destinationSquare);
		PathNode startNode = new PathNode(startSquare);
		startNode.setGoCost(0);
		
		openList.add(startNode);
		
		while(!openList.isEmpty()){
			currentNode = openList.get(1);
			if(currentNode == destinationNode){
				break;
			}
			openList.remove(currentNode);
			closedList.add(currentNode);
			
			for(int x = -1; x <2 ; x++){
				for(int y = -1; y < 2; y++){
					if((x == 0) && (y == 0)) {
						continue;
					}
					
					int xp = currentNode.getSquare().getX() + x;
					int xy = currentNode.getSquare().getY() + y;
					
					Square neighbourSquare = field.getSquare(xp, xy);
					PathNode neighbourNode = new PathNode(neighbourSquare);
					
					if((!neighbourSquare.getTerrain().isWater()) && (neighbourSquare.isPassable())) {
						int nextStepCost = currentNode.getGoCost() + getMovementCost();
						neighbourNode.setVisited(true);
						if (nextStepCost < neighbourNode.getGoCost()) {
							if (openList.contains(neighbourNode)) {
								openList.remove(neighbourNode);
							}
							if (closedList.contains(neighbourNode)) {
								closedList.remove(neighbourNode);
							}
						}
								
						if ((!openList.contains(neighbourNode)) && (!closedList.contains(neighbourNode))) {
							neighbourNode.setGoCost(nextStepCost);
							neighbourNode.setParentNode(currentNode);
							neighbourNode.setHeuristic(Math.sqrt(Math.pow((startSquare.getX() - destinationSquare.getX()), 2) + Math.pow((startSquare.getY() - destinationSquare.getY()), 2)));
							openList.add(neighbourNode);
						}

					}
					
					
				}
			}
		}
		if (destinationNode.getParentNode() == null) {
			return null;
		}

		ArrayList<PathNode> path = new ArrayList<PathNode>(200);
		
		PathNode target = destinationNode;
		while (target != startNode) {
			Square s = new Square(target.getSquare().getX(), target.getSquare().getY());
			path.add(0,new PathNode(s));

			target = target.getParentNode();
		}
		Square s = new Square(startSquare.getX(), startSquare.getY());
		path.add(0,new PathNode(s));
		PathNode[] pathA = (PathNode[]) path.toArray();
		
		Path finalPath = new Path(pathA,startSquare,destinationSquare, destinationNode.getGoCost());

		return finalPath;
	}

	private int getMovementCost() {
		return 10; //move costs 10 points at all times may be modifies so there could be talents for reduction buffs or debuffs for curr player
	}
	
	public void setMaxSearchDistance(int i){
		maxSearchDistance = i;
	}
	
	public int getMaxSearchDistance() {
		return maxSearchDistance;
	}

}
	/*
	 //H = Math.sqrt(Math.pow((currentSquare.getX() - destinationSquare.getX()), 2) 
	//	+ Math.pow((currentSquare.getY() - destinationSquare.getY()), 2))
    //create the open list of nodes, initially containing only our starting node
    //create the closed list of nodes, initially empty

   //while (we have not reached our goal) {
       consider the best node in the open list (the node with the lowest f value)
       if (this node is the goal) {
           then we're done
       }
       else {
           move the current node to the closed list and consider all of its neighbors
           for (each neighbor) {
               if (this neighbor is in the closed list and our current g value is lower) {
                   update the neighbor with the new, lower, g value 
                   change the neighbor's parent to our current node
               }
               else if (this neighbor is in the open list and our current g value is lower) {
                   update the neighbor with the new, lower, g value 
                   change the neighbor's parent to our current node
               }
               else this neighbor is not in either the open or closed list {
                   add the neighbor to the open list and set its g value
               }
           }
       }
   } */

