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
	private int [][] adjMatrix;
	private Node [][] grid;
	private int [][] graph;
	private int size;
	/**
	 * Constructs the A-StarAlgorithmn
	 * @param start - Start node
	 * @param goal - Goal Node
	 * @param adjMatrix - The array of distances between any two adjacent cities
	 */
	public AStar(Node start, Node goal, int[][] adjMatrix){
		super(start, goal);
		this.adjMatrix = adjMatrix;
	}
	
	public AStar(Node start, Node goal, int[][] graph, int size){
		super(start, goal);
		this.graph = graph;
		this.grid = new Node [size][size];
		this.grid[start.getPosY()][start.getPosX()] = start;
		this.grid[goal.getPosY()][goal.getPosX()] = goal;
		this.size = size;
		
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
	 * Uses our grid to determine which
	 * directions we can move from our current node
	 * @param current Node
	 * @return a list of those nodes
	 */
	public ArrayList<Node> getChildren(Node current){
		return null;
	}
	
	/**
	 * 
	 * @param current Node
	 * @return Euclidean distance from current to goal Node
	 */
	private double calcDist(Node current){
		double x = (current.getPosX()-this.goalNode.getPosX())*(current.getPosX()-this.goalNode.getPosX());
		double y = (current.getPosY()-this.goalNode.getPosY())*(current.getPosY()-this.goalNode.getPosY());
		return Math.sqrt(x + y);
	}

	@Override
	public boolean search() {
		System.out.println("AStar Algorithmn:");
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
				//Fix get children to reflect d-Pad in graph
				for (Node x : current.getChildren()){
					if (calcDist(x) < calcDist(current) && !(graph[x.getPosY()][x.getPosX()]==0)){
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
