import java.util.*;

public class DFS {


	public static ArrayList<Integer> DFS(int s, ArrayList<ArrayList<Integer>> adj,
	                                     boolean[] visited, ArrayList<Integer> ans) {

		// System.out.print("->" + s);
		ans.add(s);
		visited[s] = true;

		for (int i : adj.get(s)) {
			if (visited[i] == false)
				DFS(i, adj, visited, ans);
		}
		return ans;
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

		boolean[] visited = new boolean[V];

		System.out.println("DFS of a graph");

		ArrayList<Integer> ans = new ArrayList<Integer>();

		ans = DFS(0, adList, visited, ans);

		System.out.println("Ans :");
		System.out.println(ans);


	}
}