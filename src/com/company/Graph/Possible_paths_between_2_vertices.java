import java.util.*;
import java.io.*;


/*
It is nothing but dfs without making the vistsed array use. We will get the all the paths count to the dest
*/


public class Possible_paths_between_2_vertices{


	public static int countPathsBetweenSourceAndDest(ArrayList<ArrayList<Integer>> adj,
													  int v, int dest, boolean visited[], int paths){

		if(v == dest){
			paths = paths + 1;
			System.out.println(paths);
		}

		for(int u : adj.get(v)){
				paths = countPathsBetweenSourceAndDest(adj,u,dest,visited,paths);
		}

		return paths;

	}

	public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adlist) {
		adlist.get(u).add(v);
		// adlist.get(v).add(u);
	}
	public static void printGraph(ArrayList<ArrayList<Integer>> adlist) {
		for (int i = 0; i < adlist.size(); i++) {
			System.out.print(i + "->" );
			System.out.println(adlist.get(i));
		}
	}


	public static void main(String[] args) {
		ReadFromFile.readFromFile();

		System.out.println("Hi");

		Scanner scan = new Scanner(System.in);

		int V, E;

		V = scan.nextInt();
		E = scan.nextInt();

		ArrayList<ArrayList<Integer>> adList = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V ; i++) {
			adList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < E  ; i++) {
			addEdge(scan.nextInt(), scan.nextInt(), adList);
		}

		printGraph(adList);

		boolean[] visited = new boolean[V];

		System.out.println("DFS of a graph");

		int paths = 0;

		paths  = countPathsBetweenSourceAndDest(adList,0,4,visited, paths);

		System.out.println("Ans :");
		System.out.println(paths);
	}
}