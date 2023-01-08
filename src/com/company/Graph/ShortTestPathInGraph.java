import java.util.*;

public class ShortTestPathInGraph {


	public static void BFSToGetTheShortestPaths(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];

		// source vertex
		int s = 0;
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(s);

		dist[0] = 0;

		visited[s] = true;

		while (!queue.isEmpty()) {
			int u = queue.poll();

			for (int v : adj.get(u)) {
				if (visited[v] == false) {
					dist[v] = dist[u] + 1;
					visited[v] = true;
					queue.add(v);
				}
			}
		}

		System.out.println(Arrays.toString(dist));
	}


	public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adlist) {
		adlist.get(u).add(v);
		adlist.get(v).add(u);
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

		BFSToGetTheShortestPaths(V, adList);

		// System.out.println("Ans :");
		// System.out.println(ans);


	}
}