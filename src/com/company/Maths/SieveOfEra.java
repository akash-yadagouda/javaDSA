import java.util.*;
import java.io.*;

public class SieveOfEra{


	public static boolean[] primeNumberLessThenN(int n){ //25
		boolean[] arr = new boolean[n+1]; // boolean[26] {4,6,8,10,12,14,16,17,18,19,20,22,24}
		// {6,9,12,15,18,21,24,}
		// {}

		int start = 2; 
		int innerstart = 0;

		while(start < n+1){ // start = 5
			// arr[start] = true;

		if(arr[start] == false){
			// System.out.println("start =" + start);
			innerstart = start;
			while(innerstart < n+1){ // 5 < 26

				// System.out.println("innerstart " + innerstart + "+" + start);
				innerstart = innerstart + start; // 25
				// System.out.println("innerstart =" + innerstart);

				if(innerstart < n+1)
				arr[innerstart] = true;
			}
		}
			start++;
		}

		return arr;
	}

	

	// public static boolean isPrime(int n){

	// 	if(n==1 || n==2){
	// 		return true;
	// 	}

	// 	for(int i=2; i<Math.sqrt(n); i++){
	// 		if(n%i == 0){ // 
	// 			return false;
	// 		}
	// 	}
	// 	return true;


	// better approch O(n*sqrt(n))
	public static boolean[] primeNumberLessThenNV2(int n){
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		for(int i=2; i*i <= n; i++){
			if(prime[i]){
				for(int j=i+i; j<n+1; j=j+i){
					prime[j] = false;
				}
			}
		}
		return prime;
	}


	public static void main(String[] args) {

		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		boolean[] ans = primeNumberLessThenN(n);
		// boolean[] ansV2 = primeNumberLessThenNV2(n);
		// System.out.println("hi");
		// System.out.println(Arrays.toString(ans));


		// for(int i=2; i<ans.length; i++){

		// 	if(ans[i] == false){
		// 		System.out.print(i+ ",");
		// 	}

		// }

		// System.out.println(Arrays.toString(ansV2));
		// for(int i=2; i<ansV2.length; i++){

		// 	if(ansV2[i] == true){
		// 		System.out.print(i+ ",");
		// 	}

		// }

	}
}