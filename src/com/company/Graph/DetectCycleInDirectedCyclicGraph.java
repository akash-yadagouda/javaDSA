import java.util.*;

public class DetectCycleInDirectedCyclicGraph {


	public static boolean topologicalSortToDetectTheCycleInTheDiretedGrapgh(int V, ArrayList<ArrayList<Integer>> adj, int[] arr){

		Queue<Integer> queue = new LinkedList<>();

		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0){
				queue.add(i);
			}
		}

		int count = 0;

		while(!queue.isEmpty()){

			int u = queue.poll();
			System.out.print(u + "->");

			for(int v : adj.get(u)){
				arr[v]--;
				if(arr[v] == 0){
					queue.add(v);
				}
				count++;
			}
		}

		if(count == V-1){
			return false;
		}
		return true;


	}

	


	public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adlist, int[] indegree) {
		adlist.get(u).add(v);
		indegree[v]++;
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

		int[] indegree = new int[V];

		ArrayList<ArrayList<Integer>> adList = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V ; i++) {
			adList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < E  ; i++) {
			addEdge(scan.nextInt(), scan.nextInt(), adList, indegree);
		}

		printGraph(adList);
		System.out.println("indegree :" + Arrays.toString(indegree));

		System.out.println("Is there a cycle in the directed graph :" +
			topologicalSortToDetectTheCycleInTheDiretedGrapgh(V,adList,indegree));

	}
}