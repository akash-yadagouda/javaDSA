import java.util.*;
import java.io.*;


public class ArticulationPoint {


	public static void APUtil(int u, int children, int time,
							  boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap,
							  ArrayList<ArrayList<Integer>> adj){

		children = 0;

		disc[u] = low[u] = ++time;


		Iterator<Integer> i = adj.get(u).iterator();

		while(!i.hasNext()){

			int v = i.next();

			children++;
			parent[v] = u;

			APUtil(v, children, time, visited, disc, low, parent, ap, adj);

			low[u] = Math.min(low[u], low[v]);


			// verify the parent condition 
			if(parent[u] == -1 && children > 1){
				ap[u] = true;
			}

			// verify using the disc and low 
			if(parent[u] != -1 && low[v] >= disc[u]){
				ap[u] = true;
			}


		}


	}


	public static void AP(int V){
		// declare the all the arrays 
		int[] disc = new int[V];
		int[] low = new int[V];
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		boolean[] ap = new boolean[V];

		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for(int i=0; i<V; i++){
			adj.add(new ArrayList<Integer>());
		}

		

		Arrays.fill(parent, -1);

		int children = 0;
		int time = 0;

		// Trvaserse thriugh the DFS 
		for(int i=0; i<V; i++){
			APUtil(i, children, time, visited, disc, low, parent, ap, adj);
		}

		System.out.println("These are the AP vertexs");
		for(int i=0; i<V; i++){
			if(ap[i] == true){
				System.out.println(i);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("hi");
	}

}