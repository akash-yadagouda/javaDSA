import java.util.*;

public class DetectCycleInGraphInDirectedGraph {

	// for directed graph

	public static boolean IsThereACycleInGraph(int V,
	        ArrayList<ArrayList<Integer>> adj,
	        boolean[] visited,
	        int S,
	        boolean[] recSt) {

		// System.out.println("->" + S);
		visited[S] = true;
		recSt[S] = true;

		for (int u : adj.get(S)) {
			if (visited[u] == false) {
				if (IsThereACycleInGraph(V, adj, visited, u, recSt) == true) {
					return true;
				}
			} else if (recSt[u] == true) {
				return true;
			}
		}
		recSt[S] = false;
		return false;
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
		boolean[] recSt = new boolean[V];
		boolean ans = false;

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				ans = IsThereACycleInGraph(V, adList, visited, i, recSt);
				if (ans == true) {
					break;
				}
			}
		}

		System.out.println("Is there a Cycle in the graph :" + ans);

	}


}