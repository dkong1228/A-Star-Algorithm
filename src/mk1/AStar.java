package mk1;
/*
 * Darren Kong 
 * AP-Java 
 * Mr.Levin
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.PriorityQueue;

public class AStar extends AbstractSearch{
	/**
	 * Fields
	 */
	private Node [][] grid;
	private int [][] graph;
	private int size;
	
	/**
	 * Constructs the A-StarAlgorithmn
	 * @param start - Start node
	 * @param goal - Goal Node
	 * @param adjMatrix - The array of distances between any two adjacent cities
	 */	
	public AStar(Node start, Node goal, int[][] graph, int size){
		super(start, goal);
		this.graph = graph;
		this.grid = new Node [size][size];
		this.grid[start.getPosX()][start.getPosY()] = start;
		this.grid[goal.getPosX()][goal.getPosY()] = goal;
		this.size = size;
		
		//Populates the Grid with Nodes
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(grid[i][j] != start && grid[i][j] != goal){
					grid[i][j] = new Node(i,j);
					grid[i][j].setCost(calcDist(grid[i][j]));
				}
			}
		}
	}
	/**
	 * Uses our grid to determine the children
	 * we have from our current node.
	 * @param current Node
	 * @return a list of the children nodes
	 */
	private ArrayList<Node> getChildren(Node current){
		int x = current.getPosX();
		int y = current.getPosY();
		ArrayList<Node> children = new ArrayList<Node>();
		//Makes sure the current Node position is not on the "edges" of the Array.
		if (y < size-1){
			if (graph[x][y+1]!=0){
				children.add(grid[x][y+1]);
			}
		}
		if (x < size-1){
			if (graph[x+1][y] != 0){
				children.add(grid[x+1][y]);
			}
		}
		if (x > 0){
			if (graph[x-1][y] != 0){
				children.add(grid[x-1][y]);
			}
		}
		if (y > 0){
			if (graph[x][y-1] != 0){
				children.add(grid[x][y-1]);
			}
		}
		return children;
	}
	
	/**
	 * Distance Formula
	 * @param current Node
	 * @return Euclidean/Heuristic distance from current to goal Node
	 */
	private double calcDist(Node current){
		double x = (current.getPosX()-this.goalNode.getPosX())*(current.getPosX()-this.goalNode.getPosX());
		double y = (current.getPosY()-this.goalNode.getPosY())*(current.getPosY()-this.goalNode.getPosY());
		return Math.sqrt(x + y);
	}

	@Override
	public boolean search() {
		System.out.println("AStar Algorithmn:");
		this.startNode.setDistance(0);
		if(this.startNode.equals(goalNode))
		{
			System.out.println("Goal Node Found!");
			System.out.println(startNode);
		}
		
		PriorityQueue<Node> unexplored = new PriorityQueue<Node>();
		unexplored.add(startNode);
		ArrayList<Node> explored = new ArrayList<Node>();
		
		while (!unexplored.isEmpty()){
			Node current = unexplored.remove();
			if (current.equals(this.goalNode)){
				explored.add(current);
				printPath(current);
				return true;
			}
			else{
				for (Node x : getChildren(current)){
					if (!explored.contains(x) && !unexplored.contains(x))
					{
						x.setDistance(current.getDistance() + 1);
						x.setCost(x.getDistance() + calcDist(x));
						x.setParent(current);
						unexplored.add(x);
					}
					else if (x.getDistance() > current.getDistance() + 1)
					{
						x.setDistance(current.getDistance() + 1);
						x.setCost(x.getDistance() + calcDist(x));
						x.setParent(current);
					}
				}
				explored.add(current);
			}
		}
		return false;
	}

	private void printPath(Node goal) {
		while (goal.getParent() != null){
			System.out.print(goal + " <--- ");
			goal = goal.getParent();
		}
		System.out.println(goal);
	}
	
}
