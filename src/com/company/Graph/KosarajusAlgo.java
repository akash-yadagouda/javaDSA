import java.util.*;
import java.io.*;


public class KosarajusAlgo{


	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
    	adj.get(u).add(v);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj){
    	int i = 0;
    	for(ArrayList list : adj){
    		System.out.println(i + "->" + list);
    		i++;
    	}
    }


    public static void DFSToGetTheVertexWithFinishTime(
    	int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> finishTime){

    	visited[source] = true;

    	for(int i : adj.get(source)){

    		if(visited[i] == false){
    			DFSToGetTheVertexWithFinishTime(i, adj, visited, finishTime);
    		}

    	}
    	finishTime.add(source);

    }

    public static void DFS(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited){

    	// System.out.print(source + "->");
    	visited[source] = true;

    	for(int i : adj.get(source)){
    		if(visited[i] == false){
    			DFS(i, adj, visited);
    		}
    	}

    }



	public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {

    	//Step 1: Use DFS sort and get the vertex with there finishing order , O(V+E) same as DFS
    	boolean[] visited = new boolean[V];
    	Stack<Integer> finishTime = new Stack<Integer>();

    	for(int i=0; i<V; i++){
    		if(visited[i]==false){
    			DFSToGetTheVertexWithFinishTime(i,adj,visited, finishTime);
    		}
    	}

    	// System.out.println(finishTime);

    	// Step 2 : invert the graph ,
    	int u =0;
    		// create new graph to store the inverted graph , O(V)
    	ArrayList<ArrayList<Integer>> newAdj = new ArrayList<ArrayList<Integer>>();
    	for(int i=0; i<V; i++){
    		newAdj.add(new ArrayList<Integer>());
    	}
    	
    	// O(V+E)
    	for(ArrayList<Integer> list : adj){

    		for(int v : list){
    			addEdge(newAdj, v, u);
    		}
    		u++;
    	}

    	// printGraph(newAdj);


    	//Step 3 : run the DFS on the newAdj to get the strongly conncted componets 
    	boolean[] newvisited = new boolean[V];

    	int numberOfStronglyConGraph = 0;

    	// O(V+E) same as DFS

    	// System.out.println("size :" + finishTime.size());
    		while(finishTime.empty() == false){
    	    int v = (int)finishTime.pop();
    		// System.out.println(i);
    		if(newvisited[v] == false){
    			DFS(v,newAdj, newvisited);
    			// System.out.println("--");
    			numberOfStronglyConGraph++;
    		}
    	}
    	return numberOfStronglyConGraph;
    	// total complexity : step1 + step2 + step3 
    	//                  : O(V+E) + [ O(V) + O(V+E) ] + O(V+E) = O(V+E)
        
    }


	public static void main(String[] args) {
		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);

		int V = scan.nextInt();

		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for(int i=0; i<V; i++){
			adj.add(new ArrayList<Integer>());
		}

		int E = scan.nextInt();

		for(int i=0; i<E; i++){
			int u = scan.nextInt();
			int v = scan.nextInt();

			addEdge(adj,u,v);
		}

		// printGraph(adj);

		int ans = kosaraju(V, adj);
		System.out.println("Ans :" + ans);


	}
}