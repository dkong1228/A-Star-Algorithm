package mk1;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchRunner {

    public static void main(String args[]){

        /**Create our nodes
         * Old Map
        Node NYC = new Node("New York City", null,0);
        Node CHI = new Node("Chicago", null,1);
        Node DEN = new Node("Denver", null,2);
        Node MIA = new Node("Miami", null,3);
        Node DAL = new Node("Dallas", null,4);
        Node SD = new Node("San Diego", null,5);
        Node LA = new Node("Los Angeles", null,6);
        Node SF = new Node("San Francisco", null,7);
        **/
    	
    	Node Boston = new Node ("Boston", null, 0);
    	Node NewYork = new Node ("New York", null, 1);
    	Node WashDC = new Node ("Washington DC", null, 2);
    	Node Chicago = new Node ("Chicago", null, 3);
    	Node Miami = new Node ("Miami", null, 4);
    	Node Minneapolis = new Node ("Minneapolis", null, 5);
    	Node Dallas = new Node ("Dallas", null, 6);
    	Node Denver = new Node ("Denver", null, 7);
    	Node LasVegas = new Node ("Las Vegas", null, 8);
    	Node Seattle = new Node ("Seattle", null, 9);
    	Node SanFran = new Node ("San Francisco", null, 10);
    	Node LA = new Node ("Los Angeles", null, 11);

        /**
        NYC.setChildren(new ArrayList<Node>(Arrays.asList(CHI,DEN,MIA,DAL)));
        CHI.setChildren(new ArrayList<Node>(Arrays.asList(NYC,SF,DEN)));
        DEN.setChildren(new ArrayList<Node>(Arrays.asList(CHI,NYC,LA,SF)));
        MIA.setChildren(new ArrayList<Node>(Arrays.asList(NYC,DAL)));
        DAL.setChildren(new ArrayList<Node>(Arrays.asList(NYC,SD,MIA,LA)));
        SD.setChildren(new ArrayList<Node>(Arrays.asList(LA,DAL)));
        LA.setChildren(new ArrayList<Node>(Arrays.asList(SD,SF,DEN,DAL)));
        SF.setChildren(new ArrayList<Node>(Arrays.asList(LA,DEN,CHI)));
        **/
    	
    	Boston.setChildren(new ArrayList<Node>(Arrays.asList(NewYork, WashDC, Chicago)));
    	NewYork.setChildren(new ArrayList<Node>(Arrays.asList(Boston, WashDC, Miami)));
    	WashDC.setChildren(new ArrayList<Node>(Arrays.asList(Boston, NewYork, Miami, Chicago, Dallas)));
    	Chicago.setChildren(new ArrayList<Node>(Arrays.asList(Boston, WashDC, Minneapolis)));
    	Miami.setChildren(new ArrayList<Node>(Arrays.asList(NewYork, WashDC, Dallas)));
    	Minneapolis.setChildren(new ArrayList<Node>(Arrays.asList(Chicago, Dallas, Denver, Seattle)));
    	Dallas.setChildren(new ArrayList<Node>(Arrays.asList(WashDC,Miami, Minneapolis, Denver, LasVegas)));
    	Denver.setChildren(new ArrayList<Node>(Arrays.asList(Dallas, Minneapolis, Seattle, LasVegas)));
    	LasVegas.setChildren(new ArrayList<Node>(Arrays.asList(Dallas, Denver, SanFran, LA)));
    	Seattle.setChildren(new ArrayList<Node>(Arrays.asList(Minneapolis, Denver, SanFran)));
    	SanFran.setChildren(new ArrayList<Node>(Arrays.asList(Seattle, LasVegas, LA)));
    	LA.setChildren(new ArrayList<Node>(Arrays.asList(LasVegas, SanFran)));
   
        //The Edges between cities. So adjMat[0][1] represents the distance between Boston and NYC.
        int[][] adjMat = new int[][]{
        	{0,338,725,1613,0,0,0,0,0,0,0,0},//Boston
        	{338,0,383,0,2145,0,0,0,0,0,0,0},//New York
        	{725,383,0,1145,1709,0,2113,0,0,0,0,0},//DC
        	{1613,0,1145,0,0,661,0,0,0,0,0,0},//Chicago
        	{0,2145,1709,0,0,0,2161,0,0,0,0,0},//Miami
        	{0,0,0,661,0,0,1532,1483,0,2661,0,0},//Minneapolis
        	{0,0,2113,0,2161,1532,1258,0,1983,0,0,0},//Dallas
        	{0,0,0,0,0,1483,1258,0,1225,2161,0,0},//Denver
        	{0,0,0,0,0,0,1983,1225,0,0,919,435},//LasVegas
        	{0,0,0,0,0,2661,0,2161,0,0,1306,0},//Seattle
        	{0,0,0,0,0,0,0,0,919,1306,0,629},//SanFran
        	{0,0,0,0,0,0,0,0,435,0,629,0}//LA
    };

        /**Test our Old Search Methods
        AbstractClass bfs = new BreadthFirstSearch(NYC, SD);
        AbstractClass dfs = new DepthFirstSearch(NYC,SD);

        if(bfs.search())
            System.out.println("Breadth First Path Found!");
        else
        {
            System.out.println("No Path Found");
        }
        if (dfs.search())
        {
        	System.out.println("Depth First Path Found!");
        }
        else
        {
        	System.out.println("No DFS Path");
        }
        **/
        	
        AbstractSearch dijkstra = new AStar(Boston,LasVegas,adjMat);
        	
        //Dijkstra prints the path after finding the goal node
        dijkstra.search();
    }
}