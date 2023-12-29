package Tree;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Subtree_of_Another_tree {
	class node {
		int data;
		node left;
		node right;

		node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	public void fun(int a) {
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

	public node check(node ptr, int a) {
		if (ptr == null) {
			return null;
		} else if (ptr.data == a) {
			// ctr=ptr;
			return ptr;
		} else {
			node left = check(ptr.left, a);
			if (left != null) {
				return left;
			}
			else {
			node right = check(ptr.right, a);
			return right;
			}
		}

	}

	public static int getter(node ptr) {
		if (ptr == null) {
			return 0;
		}
		int l = getter(ptr.left);
		int r = getter(ptr.right);
		return l + r + 1;

	}

	public static boolean result(node ptr, node sub) {
		if (ptr == null && sub == null) {
			return true;
		} else if (ptr == null || sub == null || ptr.data != sub.data) {
			return false;
		} else {
			if (!result(ptr.left, sub.left)) {
				return false;
			}
			if (!result(ptr.right, sub.right)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Subtree_of_Another_tree ob = new Subtree_of_Another_tree();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the data for the first main tree");
		ob.fun(32);
		node root = ob.make(sc);
		ob.count = 0;
		ob.fun(32);
		System.out.println("enter the data for the sub tree");
		ob.fun(32);
		node sub = ob.make(sc);
		ob.fun(32);
		System.out.println("\nthe first tree level order traversal  is::");
		ob.level(root);
		ob.fun(32);
		System.out.println("\nthe sub tree level order traversal  is::");
		ob.level(sub);
		node ctr = ob.check(root, sub.data);
		// System.out.println("\nresult is:::" + ob.check(root, sub.data, ctr));
		System.out.println("\nthe vlaue of new node is::" + ctr.left.data);
		// System.out.println("\nthe ht of the getted tree is as follows::" +
		// getter(ctr));
		if (getter(ctr) == getter(sub)) {
			if (result(ctr, sub)==true) {
				System.out.println("\npresent");
			} else {
				System.out.println("\nnot present");
			}
		} else {
			System.out.println("\nnot possible");
		}
	}
}

// 1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
// 2 4 -1 -1 5 -1 -1
