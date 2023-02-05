import java.util.*;

public class DetectCycleInGraphInNonDirectedGraph {

	// for directed graph

	public static boolean IsThereACycleInGraph(int V,
	        ArrayList<ArrayList<Integer>> adj,
	        int parent,
	        boolean[] visited) {

		visited[parent] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(parent);

		while (!queue.isEmpty()) {
			int s = queue.poll();
			for (int u : adj.get(s)) {
				if (visited[u] == false) {

					visited[u] = true;
					queue.add(u);

				} else if ( s != parent) {
					System.out.println(u + " " + s);
					return true;
				}
			}
		}
		return false;
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

		boolean ans = false;

		boolean[] visited = new boolean[V];


		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				ans = IsThereACycleInGraph(V,
				                           adList,
				                           i - 1,
				                           i,
				                           visited);
			if (ans == true) {
				break;
			}
		}





		System.out.println("Is there a Cycle in the graph :" + ans);

	}


}