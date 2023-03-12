import java.util.*;
import java.io.*;


class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class FindWhetherPathExist {


	public static boolean isValid(int x, int y, int row, int col) {
		return x > -1 && y > -1 && x < row && y < col;
	}


	public static boolean is_Possible(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;

		int dx[] = { -1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};

		Queue <Pair> queue = new LinkedList<Pair>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					queue.add(new Pair(i, j));
					break;
				}
			}
		}

		while (!queue.isEmpty()) {

			Pair temp = queue.remove();

			for (int i = 0; i < 4; i++) {
				int new_x = temp.x + dx[i];
				int new_y = temp.y + dy[i];

				if (isValid(new_x, new_y, row, col) && grid[new_x][new_y] != 0) {

					if (grid[new_x][new_y] == 2) {
						return true;
					} else {
						queue.add(new Pair(new_x, new_y));
						z
					}

				}

			}

		}

		return false;

	}




	public static void main(String[] args) {
		ReadFromFile.readFromFile();
		System.out.println("Hi");
	}
}