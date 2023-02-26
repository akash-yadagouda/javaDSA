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

public class RottenOranges{


	static int[][] createMatrix(int n, int m){

		Scanner scan = new Scanner(System.in);

		int[][] mat = new int[n][m];

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				mat[i][j] = scan.nextInt();
			}
		}

		return mat;
	}

	static void printMatrix(int[][] mat){
		int row = mat.length;
		int col = mat[0].length;

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();

		int[][] mat = new int[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				mat[i][j] = scan.nextInt();
			}
		}

		printMatrix(mat);

		// int[][] ansMat = Ans(mat);

		System.out.println("Ans _______________");

		int ans = ansV2(mat);

		System.out.println("Ans :" + ans);
	}


	public static int ansV2(int[][] grid){
		int n = grid.length;
		int m = grid[0].length;

		boolean[][] visited = new boolean[n][m];

		int ans[][] = new int[n][m];

		Queue<Pair> queue = new LinkedList<Pair>();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j] == 2){
					queue.add(new Pair(i,j));
					visited[i][j] = true;
				}
			}
		}

		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

		int days = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for(int i=0; i<size; i++){
				Pair pair = queue.remove();
				int row = pair.row;
				int col = pair.col;

				ans[row][col] = 2;
				grid[row][col] = 2;

				for(int j=0; j<4; j++){
					int nbr_row = row + dir[j][0];
					int nbr_col = col + dir[j][1];

					if(nbr_row >= 0 && nbr_row < n && nbr_col >= 0 && nbr_col < m && !visited[nbr_row][nbr_col]
						&& grid[nbr_row][nbr_col]!=0){
						queue.add(new Pair(nbr_row, nbr_col));
						visited[nbr_row][nbr_col] = true;
					}
				}
			}

			days++;
		}


		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j] == 1){
					return -1;
				}
			}
		}

		return days-1;

		// return ans;

	}
}