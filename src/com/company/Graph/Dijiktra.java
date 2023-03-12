import java.util.*;
import java.io.*;


public class Dijiktra {


	public static void convertListToMatrix(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V, int graph[][]) {

		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				int w = adj.get(i).get(j).get(0);
				int to = adj.get(i).get(j).get(1);
				int from = k;
				graph[from][to] = w;
				graph[to][from] = w;

			}
		}
	}

}


public static int[] dijiktraAlgo(int graph[][], int V) {

	// distnace matrix
	int[] dist = new int[V];

	Arrays.fill(dist, Integer.MAX_VALUE);

	// source vertex
	int source = 0;

	boolean[] fin = new boolean[V];

	fin[0] = true;
	dist[0] = 0;

	for (int count = 0; count < V; count++) {

		int u = -1;

		// select the minimum distance vertex which are not non final ( fin[i] != true )
		for (int i = 0; i < V; i++) {
			if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
				u = i;
			}
		}

		fin[u] = true;

		// relaxtion of the neighbour vertex of u

		for (int v = 0; v < V; v++) {
			if (!fin[v] && (graph[u][v] != 0)) {
				dist[v] = dist[v] > (dist[u] + graph[u][v]) ? (dist[u] + graph[u][v]) :
				          dist[v];
			}
		}

	}

	return dist;
}




public static void main(String[] args) {
	System.out.println("hi");
}
}