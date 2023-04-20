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


public class FindTheNumberOfIslands{

	public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++){
 
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

	public static boolean isValidPos(int x, int y, int row, int col){
		return x > -1 && y > -1 && x < row && y < col;
	}

	public static void BFS(int x, int y, int[][] grid, boolean[][] visited){

		int[] dirx = {-1,1,0,0,1,-1,1,-1};
		int[] diry = {-1,1,-1,1,-1,1,0,0};

		int row = grid.length;
		int col = grid[0].length;

		Queue<Pair> queue = new LinkedList<>();

		queue.add(new Pair(x,y));

		while(!queue.isEmpty()){
			System.out.println("queue :" + queue);

			Pair pair = queue.remove();

			
			System.out.println("out side queue" + pair.row + "," + pair.col);

				for(int i=0; i<8; i++){

					int calx = pair.row + dirx[i];
					int caly = pair.col + diry[i];

					if(isValidPos(calx, caly, row, col) && visited[calx][caly]==false && grid[calx][caly]==1){
						System.out.println(calx + "," + caly);
						visited[calx][caly] = true;
						queue.add(new Pair(calx,caly));
					}

					
				}
			}
		}


	public static int numIslands(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;
		int ans = 0;

		List<Pair> OnesList = new ArrayList<Pair>();

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(grid[i][j] == 1){
					OnesList.add(new Pair(i,j));
				}
			}
		}

		boolean[][] visited = new boolean[row][col];

		for(Pair pair : OnesList){
			int x = pair.row;
			int y = pair.col;

			if(visited[x][y] == false){
				System.out.println("calling BFS :" + x + "," + y);
				BFS(x,y, grid, visited);
				ans++;
			}
		}
		return ans;
	}


	public static void main(String[] args) {

		ReadFromFile.readFromFile();

		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();

		int[][] grid = new int[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				int temp = scan.nextInt();
				grid[i][j] = temp;
			}
		}

		print2D(grid);


		int ans = numIslands(grid);
		System.out.println("Ans =" + ans);

		
	}
}