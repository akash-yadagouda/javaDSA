
import java.util.*;

public class LargestNumberPossible {


	public static String findLargest(int N, int S) {
		// code here
		int[] arr = new int[N];
		int i = 0;


		if (S > N * 9) {
			return "-1";
		}

		if (N == 1 && S == 0) {
			return "0";
		}

		if (N > 1 && S == 0) {
			return "-1";
		}

		while (S > 0) {
			if (S >= 9) {
				arr[i] = 9;
				S = S - 9;
				i++;
			} else {
				arr[i] = S;
				S = S - arr[i];
				i++;
			}
		}

		System.out.println(Arrays.toString(arr));

		StringBuilder st = new StringBuilder();

		for (int k = 0; k < N; k++) {
			st.append(String.valueOf(arr[k]));
		}

		return st.toString();
	}

	public static void main(String[] args) {
		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // digits
		int S = scan.nextInt(); // sum
		System.out.println("num :" + findLargest(N, S));

	}

}