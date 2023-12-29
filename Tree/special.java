package Tree;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

// 7 6 5 -1 -1 1 4 -1 -1 -1 2 8 -1 -1 3 -1 -1
// 6 2 -1 3 -1 4 -1 -1 1 -1 5 -1 -1
class special {
	class treenode {
		int data;
		treenode left;
		treenode right;

		treenode(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	int counter = 0;

	public treenode make(Scanner sc) {
		int a;
		treenode root = null;
		if (counter <= 0) {
			System.out.println("enter the node value in the field");
		}
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		counter++;
		root = new treenode(a);
		System.out.println("enter the left child of-->" + a);
		root.left = make(sc);
		System.out.println("enter the right child of-->" + a);
		root.right = make(sc);
		return root;

	}

	public void inorder(treenode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public void level(treenode root) {
		Queue<treenode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			treenode cu = q.poll();
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

	public int total(treenode root) {
		if (root == null) {
			return 0;
		}
		return total(root.left) + total(root.right) + 1;

	}

	public int ht(treenode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(ht(root.left), ht(root.right)) + 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		special ob = new special();
		treenode ptr = ob.make(sc);
		System.out.println("the inorder traversal of the tree is as follows");
		ob.inorder(ptr);
		System.out.println("\nlevel order traversal of the tree is as follows");
		ob.level(ptr);
		System.out.println("\ntotal number of the node are-->" + ob.total(ptr));
		System.out.println("\ntotal height of the tree is-->" + ob.ht(ptr));

	}
}
