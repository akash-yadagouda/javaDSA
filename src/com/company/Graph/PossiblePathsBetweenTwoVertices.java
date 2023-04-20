import java.util.*;
import java.io.*;


public class PossiblePathsBetweenTwoVertices {

	public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int s,
	                      int target) {


		public static int DFS(int s, int target, ArrayList<ArrayList<Integer>> adj,
		                      boolean[] visited, int pathCount) {

			// System.out.print("->" + s);

			if (target == s ) {
				pathCount++;
				return;
			}

			ans.add(s);
			visited[s] = true;

			for (int i : adj.get(s)) {
				if (visited[i] == false)
					DFS(i, target, adj, visited, pathCount);
			}
			return pathCount;
		}


		public static void main(String[] args) {
			ReadFromFile.readFromFile();
			System.out.println("Hi");
		}

	}