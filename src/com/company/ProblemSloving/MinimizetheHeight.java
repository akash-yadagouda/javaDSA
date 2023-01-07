import java.util.*;


public class MinimizetheHeight {
	public static void main(String[] args) {

		// int[] arr = {1, 2, 3};

		// int max = Arrays.stream(arr).max().getAsInt();

		// System.out.println(max);


		ReadFromFile.readFromFile();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println(Arrays.toString(arr));


		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));


		int max_ = Arrays.stream(arr).max().getAsInt();
		int min_ = Arrays.stream(arr).min().getAsInt();

		System.out.println("min & max :" + min_ + " " + max_);

		int ans = (max_ - k) - (min_ + k);

		System.out.println("Ans :" + ans);


	}
}