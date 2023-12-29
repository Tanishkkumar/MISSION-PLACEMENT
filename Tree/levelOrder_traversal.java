package Tree;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrder_traversal {
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
		System.out.println("Enter the value in the field");
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

	public int ht(node ptr) {
		if (ptr == null) {
			return 0;
		}
		return Math.max(ht(ptr.left), ht(ptr.right)) + 1;
	}

	// using recursion
	public void level(node root, int l) {
		if (root == null) {
			return;
		}
		if (l == 1) {
			System.out.print(root.data + " ");
		} else if (l > 1) {
			level(root.left, l - 1);
			level(root.right, l - 1);
		}
	}

	public void give(node ptr) {
		int h = ht(ptr);
		// System.out.println("\nht of the tree is as follows-->" + h);
		for (int i = 1; i <= h; i++) {
			level(ptr, i);
			System.out.println();
		}
	}

	// using queue
	public void levqueue(node ptr) {
		Queue<node> q = new LinkedList<>();
		q.add(ptr);
		q.add(null);
		while (!q.isEmpty()) {
			node cu = q.poll();
			if (cu == null) {
				if (q.isEmpty()) {
					return;
				}
				q.add(null);
				System.out.println(); // to print new line
				// continue;
			} else {
				System.out.print(cu.data + " ");
				if (cu.left != null) {
					q.add(cu.left);
				}
				if (cu.right != null) {
					q.add(cu.right);
				}
			}
		}
	}
   /////   Input-->      4 5 7 -1 -1 8 -1 -1 10 -1 1 -1 -1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		levelOrder_traversal ob = new levelOrder_traversal();
		node ptr = ob.make(sc);
		System.out.println("inorder traversal of tree is as follows");
		ob.pri_inorder(ptr);
		System.out.println("\nLevel order traversal of tree is");
		ob.give(ptr);
		System.out.println("\nLevel order traversal of tree Using Queue");
		ob.levqueue(ptr);
	}
}
