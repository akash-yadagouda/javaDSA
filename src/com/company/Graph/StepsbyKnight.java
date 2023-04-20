import java.util.*;
import java.io.*;


class Pair{
	int row;
	int col;

	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}

	public String toString(){
		return "{" + row + "," + col+ "}";
	}
}

public class StepsbyKnight{

	public static boolean isValidPos(int i, int j, int N){
		if( i >=0 && i<N && j>=0 && j<N ) {
			return true;
		}
		return false;
	}

	public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {

    	KnightPos[0]--;
    	KnightPos[1]--;

    	TargetPos[0]--;
    	TargetPos[1]--;

    	// int dist[][] = {{1,-2},{-1,-2},
    	// 			{2,-1},{-2,-1},
    	// 			{2, 1},{-2, 1},
    	// 			{1, 2},{-1, 2}};

    	int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

    	boolean[][] visited = new boolean[N][N];

    	Queue<Pair> queue = new LinkedList<Pair>();

    	queue.add(new Pair(KnightPos[0],KnightPos[1]));

    	visited[KnightPos[0]][KnightPos[1]] = true;

    	int steps = 0;

    	while (!queue.isEmpty()) {


    		// System.out.println("Start");
    		int size = queue.size();
    		for(int ii=0; ii<size; ii++){

	    		Pair pair = queue.remove();
	    		int row = pair.row;
	    		int col = pair.col;

	    		// System.out.println(row + "," + col);

	    		if(row == TargetPos[0] && col == TargetPos[1]){
	    			// System.out.println("Ans got");
	    			return steps;
	    		}

	    		for(int i=0; i<8; i++){

	    			int nbr_row = row + dx[i];
	    			int nbr_col = col + dy[i];

	    			if(isValidPos(nbr_row, nbr_col, N) && !visited[nbr_row][nbr_col]){
	    				queue.add(new Pair(nbr_row, nbr_col));
	    				visited[nbr_row][nbr_col] = true;
	    			}

	    		}
    		}
    		// System.out.println("End");
    		steps++;
    	}

    	return -1;
       
    }



	public static void main(String[] args) {
		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int k0 = scan.nextInt();
		int k1 = scan.nextInt();
		int t0 = scan.nextInt();
		int t1 = scan.nextInt();

		int[] knight = {k0, k1};
		int[] target = {t0, t1};

		int ans = minStepToReachTarget(knight, target, N);
		System.out.println("ans " + ans);
	}
}