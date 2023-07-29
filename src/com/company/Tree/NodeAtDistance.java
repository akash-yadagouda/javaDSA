import java.util.*;
import java.io.*;

public class NodeAtDistance{

	public static Set<Integer> setint = new HashSet<>();

	public static int inorder(Node root, int k){

		// inordere trvaresal 
		if(root != null){

			inorder(root.left, k);

			if(validteDepth(root, k)){
				set_int.add(root.key);
			}

			inorder(root.right, k);
		}

	}

	public static boolean validteDepth(Node root, int k){

		if(root == null){
			return false;
		}

		if(root.left == null && root.right == null){
			if(k ==0){
				return true;
			}
			return false;
		}

		validteDepth(root.left, k-1);
		validteDepth(root.right, k-1);

		return false;

	}



	public static void main(String[] args) {

		System.out.println("hi");
	}
}