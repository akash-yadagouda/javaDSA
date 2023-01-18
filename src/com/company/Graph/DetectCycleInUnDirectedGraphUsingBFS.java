import java.util.*;

public class DetectCycleInUnDirectedGraphUsingBFS {


	public static void topologicalSortToDetectTheCycleInTheUnDiretedGrapgh(int V, ArrayList<ArrayList<Integer>> adj){

		boolean[] visited = new boolean[V];
		int[] dist = new int[V];

		dist[0] = 0;

		Queue<Integer> q = new LinkedList<>();

		int s = 0;

		q.add(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int u = q.poll();

			for(int v : adj.get(u)){
				if(visited[v] == false){
					dist[v] = dist[u] + 1;
					visited[v] = true;
					q.add(v);
				}
			}
		}

		for(int v : adj.get(u)){
					int temp = dist[u] + dist(u,v);
					if(temp < dist[v]){
						dist[v] = temp;
					}
					
					if(!q.isPresent(v)){
						q.add(v);
					}
					
			}

		System.out.println("Shorttest distance from the vertex zero to all " + Arrays.toString(dist));


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

		topologicalSortToDetectTheCycleInTheUnDiretedGrapgh(V,adList);

	}
}