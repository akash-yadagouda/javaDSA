import java.util.*;
import java.io.*;


public class threedArray {
	public static void main(String[] args) {
		ArrayList<ArrayList<ArrayList<Integer>>> array = new
		ArrayList<ArrayList<ArrayList<Integer>>>(3);

		for (int i = 0; i < 3; i++) {
			array.add(new ArrayList<ArrayList<Integer>>(3));
			for (int j = 0; j < 3; j++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(2);
				temp.add(1);
				temp.add(2);
				array.get(i).add(temp);
			}
		}

		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.get(i).size(); j++) {
				for (int k = 0; k < array.get(i).get(j).size(); k++) {
					int a = array.get(i).get(j).get(k);
					int b = array.get(i).get(j).get(k);

					System.out.println(a + " " + b);
				}
			}
		}
	}
}