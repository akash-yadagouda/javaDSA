import java.util.*;

public class CountTheNumberOfConnectedComponentInTheGraph {


	public static ArrayList<Integer> BFS(int V,
	                                     ArrayList<ArrayList<Integer>> adj,
	                                     boolean[] visited,
	                                     ArrayList<Integer> ans) {
		// boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();

		// ArrayList<Integer> ans = new ArrayList<>();

		visited[V] = true;

		queue.add(V);
		ans.add(V);

		while (!queue.isEmpty()) {
			int v = queue.poll();
			//System.out.print(v);
			for (int i = 0; i < adj.get(v).size(); i++) {
				int adjv = adj.get(v).get(i);
				if (visited[adjv] != true) {
					visited[adjv] = true;
					//System.out.print(adjv);
					queue.add(adjv);
					ans.add(adjv);
				}

			}
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

		// ArrayList<Integer> ans = BFS(V, adList);

		boolean[] visited = new boolean[V];
		ArrayList<Integer> ans = new ArrayList<Integer>();

		int numberOfDisjointGraphs = 0;

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				ans = BFS(i, adList, visited, ans);
				numberOfDisjointGraphs++;
			}
		}

		System.out.println("Ans :");
		System.out.println(ans);
		System.out.println("number of graphs :" + numberOfDisjointGraphs);
	}


}