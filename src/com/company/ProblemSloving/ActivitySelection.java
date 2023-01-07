import java.io.*;
import java.util.*;

class Pair {
  public int startTime;
  public int endTime;

  public Pair(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }


  public String toString() {
    return startTime + "," + endTime;
  }

}



public class ActivitySelection {

  public static int activitySelection(int start[], int end[], int n) {

    List<Pair> pairs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      pairs.add(new Pair(start[i], end[i]));
    }

    Collections.sort(pairs, (a, b) -> (a.endTime - b.endTime));

    int prev = 0;
    int ans = 1;

    for (int i = 1; i < n; i++) {
      if (pairs.get(i).startTime > pairs.get(prev).endTime) {
        ans++;
        prev = i;
      }
    }

    return ans;

  }



  public static void main(String[] args) {

    ReadFromFile.readFromFile();

    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    int[] start = new int[n];
    int[] end = new int[n];
    int i = n;

    for (int st = 0; st < n ; st++) {
      start[st] = scan.nextInt();
    }

    i = n;

    for (int ed = 0; ed < n; ed++) {
      end[ed] = scan.nextInt();
    }

    System.out.println("start :" + Arrays.toString(start));
    System.out.println("end :" + Arrays.toString(end));

    int ans = activitySelection(start, end, n);

    System.out.println("ans :" + ans );

  }
}