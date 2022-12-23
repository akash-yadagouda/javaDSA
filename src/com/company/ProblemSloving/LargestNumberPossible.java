
import java.util.*;

public class LargestNumberPossible{

	public static void main(String[] args) {
		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); // digits
		int S = scan.nextInt(); // sum

		String nine = "9";

		int[] arrayofnine = new int[N];

		Arrays.fill(arrayofnine, 9);

		System.out.println(Arrays.toString(arrayofnine));

		Arrays.sort(arrayofnine


	}

}