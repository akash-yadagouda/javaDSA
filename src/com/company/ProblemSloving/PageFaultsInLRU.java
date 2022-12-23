
import java.util.*;

public class PageFaultsInLRU {


	static int pageFaults(int N, int C, int pages[]){

		Queue<Integer> queue = new LinkedList<>();

		int pagemiss = 0;


		for(int i =0; i < N; i++){

			if(queue.contains(pages[i])){
				queue.remove(pages[i]);
				queue.add(pages[i]);
				continue;
			}

			if(queue.size() < C ){
					queue.add(pages[i]);
					pagemiss++;
			}else{
				queue.remove();
				queue.add(pages[i]);
				pagemiss++;
			}


		}

		return pagemiss;
        
    }



	public static void main(String[] args) {

		ReadFromFile.readFromFile();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int C = scan.nextInt();

		int[] pages = new int[N];

		for(int i=0; i<N; i++){
			pages[i] = scan.nextInt();
		}
		System.out.println("Pages :" + Arrays.toString(pages));

		System.out.println("Ans : " + pageFaults(N, C, pages) );
		
	}
}