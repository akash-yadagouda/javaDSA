import java.util.*;
import java.io.*;


class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class FindTheLevelOfNode {


	public static boolean isValid(int x, int y, int row, int col) {
		return x > -1 && y > -1 && x < row && y < col;
	}


	public int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
		// code here

		int root = 0;

		boolean visited[] = new boolean[V];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(root);
		visited[root] = true;

		int level = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {

				int v = queue.remove();

				for (int xx : adj.get(v)) {

					if (visited[xx] == false) {
						visited[xx] = true;
						queue.add(xx);
					}

					if ( xx == X ) {
						return level;
					}

				}

			}
			level++;
		}

		return -1;

	}




	public static void main(String[] args) {
		ReadFromFile.readFromFile();
		System.out.println("Hi");
	}
}