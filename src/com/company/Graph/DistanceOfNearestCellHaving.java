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

public class DistanceOfNearestCellHaving{


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

		int[][] ansMat = Ans(mat);

		System.out.println("Ans _______________");

		printMatrix(ansMat);

	}

	static int[][] Ans(int mat[][]){
		int rowMain = mat.length;
		int colMain = mat[0].length;

		// create a mat for ANS 

		int[][] ansMat = new int[rowMain][colMain];

		// intitlize with Intger.MAX_VALUE;

		for(int i=0; i<rowMain; i++){
			for(int j=0; j<colMain; j++){
				ansMat[i][j] = 0;
			}
		}

		// create boolean visited matrix 
		boolean[][] visited = new boolean[rowMain][colMain];

		Queue<Pair> queue = new LinkedList<Pair>();

		// traverse the the matrix and push with value 1 to queue amd make the visisted true for them 
		for(int i=0; i<rowMain; i++){
			for(int j=0; j<colMain; j++){
				if(mat[i][j] == 1){
					queue.add(new Pair(i,j));
					ansMat[i][j] = 8;
					visited[i][j] = true;
				}
			}
		}

		int level = 1;
		int[][] dist = {{-1,0}, {1,0}, {0,-1},{0,1}};

		while(!queue.isEmpty()){


			System.out.println("Start" + queue);
			for(int q = 0; q<=queue.size(); q++){

				Pair pair = queue.remove();
				int row = pair.row;
				int col = pair.col;

				// ansMat[row][col] = level;

				System.out.println("Main" + row + "+" + col);

				// System.out.println(visited[row][col]);

				
					// System.out.println("inside ");

					for(int i=0; i<4; i++){
						int new_row = row + dist[i][0];
						int new_col = col + dist[i][1];

						System.out.println("before" + new_row + "^" + new_col);

						if(new_row >=0 && new_col >=0 &&
						 new_row < rowMain && new_col < colMain && (!visited[new_row][new_col]) ){
							System.out.println("After" + new_row + " " + new_col);
							ansMat[new_row][new_col] =  level;
							queue.add(new Pair(new_row, new_col));
							visited[new_row][new_col] = true;
							// System.out.println(new_row + ">" + new_col);
						}
					}
					

			}
			System.out.println("end" + queue);
			System.out.println("___ A " + level);
					printMatrix(ansMat);
			level++;
		}
		return ansMat;
	}
}