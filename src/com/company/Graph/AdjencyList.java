import java.util.*;

public class AdjencyList {


	public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adlist) {
		adlist.get(u).add(v);
		adlist.get(v).add(u);
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> adlist) {
		for (int i = 0; i < adlist.size(); i++) {
			System.out.println(adlist.get(i));
		}
	}

	public static void main(String[] args) {

		System.out.println("Hi");

		Scanner scan = new Scanner(System.in);

		int size;

		size = 4;

		ArrayList<ArrayList<Integer>> adList = new ArrayList<ArrayList<Integer>>(size);

		for (int i = 0; i < size; i++) {
			adList.add(new ArrayList<Integer>());
		}

		addEdge(0, 1, adList);
		addEdge(0, 2, adList);
		addEdge(1, 2, adList);
		addEdge(2, 3, adList);

		printGraph(adList);


	}
}