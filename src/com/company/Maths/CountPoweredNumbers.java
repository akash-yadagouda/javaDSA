import java.util.*;
import java.io.*;


public class CountPoweredNumbers{

	public static void main(String[] args) {

		ReadFromFile.readFromFile();

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int pow = scan.nextInt();

		int ans = calculatethepowerofnumber(n, pow);
		System.out.println("Ans :"  + ans );

	}

	public static int calculatethepowerofnumber(int n,int pow){

		// this is the approach to find the pow of n with log(pow) complexity
		int res = 1;

		while(pow > 0){
			if(pow % 2 != 0){
				res = res * n;
			}
			n = n * n;
			pow = pow/2;
		}

		// on in c++ ( bitwise wont support in java )
		// while(pow > 0){
		// 	if(pow & 1){
		// 		res = res * n;
		// 	}
		// 	n = n * n;
		// 	pow = pow >> 1;
		// }
		return res;
	}

}