import java.io.*;
import java.util.*;

public class DayOne {


  public static int activitySelection(int start[], int end[], int n)
    {
      int st , ed ;
      int ans = 1;

      st = start[0]; // 1
      ed = end[0]; // 2

      for(int i=0; i<n-1; i++){// i = 1

        if(ed < start[i+1]){ // 
          // System.out.println("end :" + ed);
          ans++;
          ed = end[i+1];
        }
      }
      return ans;
    }

     public static int activitySelectionV2(int start[], int end[], int n)
    {
      
    }int st , ed ;
      int ans = 1;

      st = start[0]; // 1
      ed = end[0]; // 2

      for(int i=0; i<n-1; i++){// i = 1

        if(ed < start[i+1]){ // 
          // System.out.println("end :" + ed);
          ans++;
          ed = end[i+1];
        }
      }
        return ans;





  public static void main(String[] args) {
   
    ReadFromFile.readFromFile();

    Scanner scan = new Scanner(System.in);

    List<Integer> start = new ArrayList<>();
    List<Integer> end = new ArrayList<>();
    int i = 4;

    while(i > 0){

      start.add(scan.nextInt());

      i--;
    }

    i = 4;

    while(i > 0){

      end.add(scan.nextInt());

      i--;
    }

    // System.out.println("start :" + start);
    // System.out.println("end :" + end);

    int ans = activitySelection( start.stream().mapToInt(a -> a).toArray(),
                                 end.stream().mapToInt(a -> a).toArray(),
                                 start.size());

    System.out.println(ans);



  }
}