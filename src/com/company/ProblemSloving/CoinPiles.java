import java.util.*;


public class CoinPiles{


	static int minSteps(int[] pileArray, int size, int k) {

		int coinsToRemove = 0;

		int start = 0;
		int end = size - 1;
		
		for(int i =0; i<size; i++){

			int diff = pileArray[i+1] - pileArray[i];
			if(diff > k ){
				coinsToRemove += diff - k;
			} 
		}


		return coinsToRemove;
    }





	public static void main(String[] args) {

		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int K = scan.nextInt();

		int[] pileArray = new int[size];

		for(int i=0; i<size; i++){
			pileArray[i] = scan.nextInt();
		}
		System.out.println("input :" + Arrays.toString(pileArray));

		// sort the arry 

		Arrays.sort(pileArray);

		System.out.println(Arrays.toString(pileArray));

		int coinsToRemove = 0;

		int start = 0;
		int end = size - 1;

		while(start < end){
			int diff = pileArray[end] - pileArray[start];

			if(diff > K){
				coinsToRemove = coinsToRemove + (diff - K);
				start++;
				end--;
			}
			else{
				break;
			}
		}

		System.out.println("coinsToRemove :" + coinsToRemove);


	}
}