import java.util.*;
import java.io.*;


class Node {
	int key;
	Node left;
	Node right;

	public Node(int key) {
		this.key = key;
	}
	public Node(int key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
}


public class TreeTraversal {
//  left -> root -> right
	public static void inoredr(Node root) {

		if (root == null) {
			return;
		}

		if (root.left != null) inoredr(root.left);
		System.out.println(root.key + ",");
		if (root.right != null) inoredr(root.right);
	}

//  root -> left -> right
	public static void preOredr(Node root) {

		if ( root == null ) {
			return;
		}

		System.out.println(root.key + ",");
		if (root.right != null) preOredr(root.right);
		if (root.left != null) preOredr(root.left);

	}

// left -> right -> root

	public static void postOredr(Node root) {

		if (root == null) {
			return;
		}

		if ( root.left != null ) preOredr(root.left);
		if ( root.right != null) preOredr(root.right);
		System.out.println(root.key + ",");

	}

	public static void main(String[] args) {

	}
}