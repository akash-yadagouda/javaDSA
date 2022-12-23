import java.util.*;


public class QueueTest{
	public static void main(String[] args) {

	ReadFromFile.readFromFile();

	 Queue<Integer> q
            = new LinkedList<>();

     q.add(10);
     q.add(200);

     System.out.println(q);

     q.add(120);

     System.out.println(q);

     q.remove(200);

     System.out.println(q);

     System.out.println(q.remove());

     System.out.println(q.contains(120));

     System.out.println(q.size());

    }
}