package Tree;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Leftview_of_tree {
	class node {
		int data;
		node l;
		node r;

		node(int val) {
			data = val;
			l = null;
			r = null;
		}
	}

	public node make(Scanner sc) {
		int a;
		node root = null;
		System.out.println("enter the node in the field");
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		root = new node(a);
		System.out.println("enter the left child of->" + a);
		root.l = make(sc);
		System.out.println("enter the right child of->" + a);
		root.r = make(sc);
		return root;
	}

	public void lev(node root) {
		Queue<node> q = new LinkedList<>();
		q.add(root);
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
				if (cu.l != null) {
					q.add(cu.l);
				}
				if (cu.r != null) {
					q.add(cu.r);
				}
			}
		}
	}

	public void printval(node root, ArrayList<node> a, int level) {
		if (root == null) {
			return;
		}
//		if (a.get(level) == null) {
//			a.add(root);
//		}
		System.out.println("size->" + a.size());
		if (a.size() <= level) {
			a.add(root);
		} else {
			a.set(level, root);
		}
		printval(root.l, a, level + 1);
		printval(root.r, a, level + 1);
	}

	public void left(node root) {
		ArrayList<node> c = new ArrayList<>();
//		c.add(null);
		printval(root, c, 0);
		for (node cu : c) {
			System.out.print(cu.data + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Leftview_of_tree ob = new Leftview_of_tree();
		node root = ob.make(sc);
		System.out.println("level order traversal of the tree is as follows");
		ob.lev(root);
		System.out.println("\nleft view of the tree is-->");
		ob.left(root);
	}
}
