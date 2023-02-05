import java.util.*;
import java.io.*;


public class PrimsMST {

	public static int primeMST(int graph[][], int V) {

		// the value inside the key indicates that ,
		// it is the minimum dist that we need to travel from the sourec vertex
		int[] key = new int[V];
		int res = 0;

		Arrays.fill(key, Integer.MAX_VALUE);

		key[0] = 0;

		boolean[] mSet = new boolean[V];

		for (int count = 0; count < V; count++) {

			int u = -1;

			// it will pick the vertex from the non mst group
			// as it is not in the mst and has minimum value
			for (int i = 0; i < V; i++) {

				if (!mSet[i] && (u == -1 || key[i] < key[u])) {
					u = i;
				}

			}

			mSet[u] = true;
			res = res + key[u];

			// here we are finding the minimun edge possibel from the vertex u
			// and which is not part of the mst.
			for (int k = 0; k < V; k++) {
				if (!mSet[k] && graph[u][k] != 0 && graph[u][k] < key[k]) {
					key[k] = graph[u][k];
				}
			}

		}

		return res;

	}
}