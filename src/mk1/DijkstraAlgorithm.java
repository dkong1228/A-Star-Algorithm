package mk1;
/*
 * Darren Kong 
 * AP-Java 
 * Mr.Levin
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.PriorityQueue;

public class DijkstraAlgorithm extends AbstractSearch{
	/**
	 * Fields
	 */
	private int [][] adjMatrix;
	/**
	 * Constructs the DijkstraAlgorithmn
	 * @param start - Start node
	 * @param goal - Goal Node
	 * @param adjMatrix - The array of distances between any two adjacent cities
	 */
	public DijkstraAlgorithm(Node start, Node goal, int[][] adjMatrix){
		super(start, goal);
		this.adjMatrix = adjMatrix;
	}

	@Override
	public boolean search() {
		System.out.println("Dijkrsta's Algorithmn:");
		this.startNode.setDistance(0);
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
				for (Node x : current.getChildren()){
					if (!unexplored.contains(x) && !explored.contains(x)){
						x.setDistance(current.getDistance() + this.adjMatrix[current.getIndex()][x.getIndex()]);
						x.setParent(current);
						unexplored.add(x);
					}
					else if (x.getDistance() > current.getDistance() + this.adjMatrix[current.getIndex()][x.getIndex()]){
						x.setDistance(current.getDistance() + this.adjMatrix[current.getIndex()][x.getIndex()]);
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
