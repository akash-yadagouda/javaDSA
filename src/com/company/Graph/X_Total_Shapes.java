import java.util.*;
import java.io.*;


class Pair{
	int x;
	int y;

	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class X_Total_Shapes{


	public static void printArray(boolean[][] a){
		for(int i=0; i<a.length; i++){
			System.out.println(Arrays.toString(a[i]));
		}
	}

	public static int[] xpos = {0,-1,0,1};
	public static int[] ypos = {-1,0,1,0};


	public static boolean isvalidcell(int x, int y, int row, int col){

		boolean local = (x > -1 && x < row && y > -1 && y < col);

		System.out.println(x +"," + y + "isvalid :" + local);

		return (x > -1 && x < row && y > -1 && y < col);
	}


	public static void multiSourceBfs(char[][] grid, int posx, int posy, int row, int col, boolean[][] visited){


		Queue<Pair> queue = new LinkedList<>();
		int newx ;
		int newy ;

		queue.add(new Pair(posx, posy));
		visited[posx][posy] = true;

		while(!queue.isEmpty()){

			// System.out.println("new poll :");

			Pair pair = queue.poll();


			// System.out.println(pair.x + "," + pair.y);





			for(int i =0; i<4; i++){

				newx = pair.x;
				newy = pair.y;

				newx = newx + xpos[i];
				newy = newy + ypos[i];

				// System.out.println("________________");
				// System.out.println("newx :" + newx);
				// System.out.println("newy :" + newy);


				if(isvalidcell(newx, newy, row, col) && !visited[newx][newy]){
					// System.out.println("I am in for " + newx + "," + newy);
					visited[newx][newy] = true;
					if(grid[newx][newy] == 'X'){
						queue.add(new Pair(newx, newy));
					}
					
				}
				// System.out.println("________________");
				
			}


		}

	}



 	public static int xShape(char[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        int numberOfXshapes = 0;

        boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row ; i++){
        	for(int j=0; j<col; j++){

        		// printArray(visited);

        		if(visited[i][j] == false && grid[i][j] == 'X'){
        			multiSourceBfs(grid, i, j, row, col, visited);
        			numberOfXshapes++;
        		}

        	}
        }

        return numberOfXshapes;
    }


	public static void main(String[] args) {

		ReadFromFile.readFromFile();

		int n;
		int m;
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		m = scan.nextInt();

		System.out.println("n :" + n +"," + "m :" + m);

		char[][] mat = new char[n][m];

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				mat[i][j] = scan.nextChar();	
			}
		}


		for(int i=0; i<n; i++){
			System.out.println(Arrays.toString(mat[i]));
		}

		int ans =  xShape(mat);
		System.out.println("Ans :" + ans);

	}
}