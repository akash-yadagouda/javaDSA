import java.util.*;
import java.io.*;

public class CalculateThepowerednumber{
	public static void main(String[] args) {
		ReadFromFile.readFromFile();
		// System.out.println("hi");
		Scanner scan = new Scanner(System.in);

		long n = scan.nextInt();
		long pow = scan.nextInt();

		long ans = calculatetheAns(n,pow);

		System.out.println("Ans :" + ans);


	}

	public static long calculatetheAns(long n, long pow){
		if(pow==0){
			return 1;
		}

		long temp = calculatetheAns(n, pow/2);

		temp = temp * temp;

		if(pow%2 == 0){
			return temp;
		}
		else {
			return temp*n;
		}
	}
}