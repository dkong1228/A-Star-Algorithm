package mk1;
/*
 * Darren Kong 
 * AP-Java 
 * Mr.Levin
 */
public abstract class AbstractSearch{
	/*
	 * Fields
	 */
	Node startNode;
	Node goalNode;
	
	/*
	 * Constructor
	 */
	public AbstractSearch(Node start, Node goal){
		this.startNode = start;
		this.goalNode = goal;
	}
	
	/*
	 * Determines if a path can be found.
	 * @returns true if a path can be found.
	 */
	public abstract boolean search();

}
