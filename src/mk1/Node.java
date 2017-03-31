package mk1;
/*
 * Darren Kong 
 * AP-Java 
 * Mr.Levin
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * The Node class represents a city,
 * as well as an ArrayList of nodes that will store
 * any instantiated nodes children.
 */
public class Node implements Comparable<Node>{
	
	public String name;
	private ArrayList<Node> children;
	private Node parent;
	private int minDistance = Integer.MAX_VALUE;
	private int index;
	private int cost;
	private int posX;
	private int posY;
	
	/*
	 * Creates a Node
	 */
	public Node(String name, ArrayList<Node> children){
		this.name = name;
		this.children = new ArrayList<>();
	}
	
	public Node(String name, ArrayList<Node> children, int index){
		this.name = name;
		this.children = children;
		this.setIndex(index);
	}
	
	public Node(int x , int y){
		this.posX = x;
		this.posY = y;
	}
	/*
	 * @return The children of the Node
	 */
    public ArrayList<Node> getChildren(){
		ArrayList<Node> childNodes = new ArrayList<>();
		for (Node x : this.children){
			if (x!=null){
				childNodes.add(x);
			}
		}
		return childNodes;
	}
	
    /*
     * Adds children/connecting Nodes to the Node.
     */
    public void setChildren(ArrayList<Node> arrayList){
    	this.children = arrayList;
    }
    /**
     * Sets the Parent of the Node
     * @param parent of the Node
     */
    public void setParent(Node parent){
    	this.parent = parent;
    }
    /**
     * Sets the distance of the Node
     * @param distance to parent Node
     */
    public void setDistance(int distance){
    	minDistance=distance;
    }
    public int getDistance(){
    	return this.minDistance;
    }
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Node other) {
		return this.cost - other.getCost();
	}

	private int getCost() {
		return this.cost;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Node getParent() {
		return this.parent;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
