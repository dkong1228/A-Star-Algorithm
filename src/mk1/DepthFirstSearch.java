package mk1;
/*
 * Darren Kong 
 * AP-Java 
 * Mr.Levin
 */
import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends AbstractSearch {
	
	/*
	 * Constructor
	 */
	public DepthFirstSearch(Node start, Node goal){
		super(start, goal);
	}

	public boolean search(){
		System.out.println("DepthFirst Search:");
		if (this.startNode.equals(this.goalNode)){
			System.out.println("Goal Node Found!");
			System.out.println(startNode);
		}
		Stack<Node> nodeStack = new Stack<>();
		ArrayList<Node> vistedNodes = new ArrayList<>();
		nodeStack.add(startNode);
		while (!nodeStack.isEmpty()){
			Node current = nodeStack.pop();
			if (current.equals(goalNode)){
				vistedNodes.add(current);
				System.out.println(vistedNodes);
				System.out.println("Goal Node Found!");
				return true;
			}
			else{
				vistedNodes.add(current);
				for (Node x : current.getChildren()){
					if (!vistedNodes.contains(x)&&(!nodeStack.contains(x))){
						nodeStack.add(x);
					}
				}
			}
		}
		System.out.println("No Path Found!");
		System.out.println(vistedNodes);
		return false;
	}
	
}
