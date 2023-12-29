package Tree;

import java.util.Scanner;

public class Kth_traversal__Recursive {
	class node {
		int data;
		node left;
		node right;

		node(int a) {
			data = a;
			left = null;
			right = null;
		}
	}

	public static void fun(int a) {
		System.out.println();
		for (int i = 0; i < a; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public int count = 0;

	public node make(Scanner sc) {
		int a;
		node ptr = null;
		if (count == 0) {
			System.out.println("enter the main root value in the field");
			count = -1;
		}
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		ptr = new node(a);
		System.out.println("enter the left child of:" + a);
		ptr.left = make(sc);
		System.out.println("enter the right child of:" + a);
		ptr.right = make(sc);
		return ptr;
	}

	// Recursive approach time complexity[O(n)]
	public void trav(node ptr, int level, int k) {
		if (ptr == null) {
			return;
		}
		if (level == k) {
			System.out.print(ptr.data + " ");
			return;
		}
		trav(ptr.left, level + 1, k);
		trav(ptr.right, level + 1, k);
	}

	public static void main(String[] args) {
		Kth_traversal__Recursive ob = new Kth_traversal__Recursive();
		Scanner sc = new Scanner(System.in);
		node root = ob.make(sc);
		int k;
		System.out.println("enter the value of k in the field");
		k = sc.nextInt();
		ob.trav(root, 1, k);
		sc.close();
		// 4 5 7 -1 -1 8 -1 -1 10 -1 1 -1 -1
	}
}
