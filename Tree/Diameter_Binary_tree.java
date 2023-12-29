package Tree;

import java.util.*;

//Number of nodes in the largest path b/w the two leaf nodes.  --Time Complexity-O(n*n); 
public class Diameter_Binary_tree {
	class node {
		int data;
		node left;
		node right;

		node(int a) {
			data = a;
			this.left = null;
			this.right = null;
		}
	}

	public int count = 0;

	public node make(Scanner sc) {
		int a = 0;
		node ptr = null;
		if (count != -1) {
			System.out.println("enter the node value in the field");
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

	public void level(node ptr) {
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
				System.out.println();
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

	public int height(node ptr) {
		if (ptr == null) {
			return 0;
		}
		return Math.max(height(ptr.left), height(ptr.right)) + 1;
	}

	public int diameter(node ptr) {
		if (ptr == null) {
			return 0;
		}
		int dl = diameter(ptr.left);
		int rr = diameter(ptr.right);
		int cu = height(ptr.left) + height(ptr.right) + 1;
		return Math.max(cu, Math.max(dl, rr));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Diameter_Binary_tree ob = new Diameter_Binary_tree();
		node root = ob.make(sc);
		System.out.println("the  level order traversal of the tree is as follows");
		ob.level(root);
		System.out.println("\nThe Diameter of the tree is :" + ob.diameter(root));
	}
}
