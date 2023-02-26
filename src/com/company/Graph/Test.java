import java.io.*;
import java.util.*;


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
public class Test {

	public static int[][] ans(int[][] grid){
		int n = grid.length;
		int m = grid[0].length;

		boolean[][] visited = new boolean[n][m];

		int ans[][] = new int[n][m];

		Queue<Pair> queue = new LinkedList<Pair>();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j] == 1){
					queue.add(new Pair(i,j));
					visited[i][j] = true;
				}
			}
		}

		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

		int level = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for(int i=0; i<size; i++){
				Pair pair = queue.remove();
				int row = pair.row;
				int col = pair.col;

				ans[row][col] = level;

				for(int j=0; j<4; j++){
					int nbr_row = row + dir[j][0];
					int nbr_col = col + dir[j][1];

					if(nbr_row >= 0 && nbr_row < n && nbr_col >= 0 && nbr_col < m && !visited[nbr_row][nbr_col]){
						queue.add(new Pair(nbr_row, nbr_col));
						visited[nbr_row][nbr_col] = true;
					}
				}
			}
			
		}

		return ans;

	}


	public static void main(String[] args) {
		System.out.println("hi");
	}
}
