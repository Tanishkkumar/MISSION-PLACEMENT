package Tree;

import java.util.*;

public class max_and_min {
	class node {
		int data;
		node left;
		node right;

		node(int val) {
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}

	public node make(Scanner sc) {
		int a;
		node root = null;
		System.out.println("enter the value in the field");
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		root = new node(a);
		System.out.println("enter the left child of --" + a);
		root.left = make(sc);
		System.out.println("enter the right child of --" + a);
		root.right = make(sc);
		return root;
	}

	public void pri_inorder(node arr) {
		if (arr == null) {
			return;
		}
		pri_inorder(arr.left);
		System.out.print(arr.data + " ");
		pri_inorder(arr.right);
	}

	public int pri_ht(node ptr) {
		if (ptr == null) {
			return 0;
		}
		return Math.max(pri_ht(ptr.left), pri_ht(ptr.right)) + 1;
	}

	public int pri_si(node ptr) {
		if (ptr == null) {
			return 0;
		}
		return pri_si(ptr.left) + pri_si(ptr.right) + 1;
	}

	public int max(node ptr) {
		if (ptr == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(ptr.data, Math.max(max(ptr.left), max(ptr.right)));
	}

	public int min(node ptr) {
		if (ptr == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(ptr.data, Math.min(min(ptr.left), min(ptr.right)));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		max_and_min ob = new max_and_min();
		node ptr = ob.make(sc);
		System.out.println("inorder traversal of tree is as follows");
		ob.pri_inorder(ptr);
		System.out.println("\nheight of the tree is--" + ob.pri_ht(ptr));
		System.out.println("\nSize of the tree(total number of nodes) is--" + ob.pri_si(ptr));
		System.out.println("\nMAX node in the tree is--" + ob.max(ptr));
		System.out.println("\nMIN node in the tree is--" + ob.min(ptr));

	}
}
