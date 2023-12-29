package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lowest_common_ansestor_inBinarytree {
	class treenode {
		int data;
		treenode left;
		treenode right;

		treenode(int val) {
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}

	// making treemethod
	public treenode make(Scanner sc) {
		int a;
		treenode root = null;
		System.out.println("enter the value in the field");
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		root = new treenode(a);
		System.out.println("enter the left child of->" + a);
		root.left = make(sc);
		System.out.println("enter the right child of->" + a);
		root.right = make(sc);
		return root;
	}

	// printing tree using queue level
	public void level(treenode ptr) {
		Queue<treenode> q = new LinkedList<>();
		q.add(ptr);
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

	public treenode lowest(treenode ptr, int a, int b) {
		if (ptr == null) {
			return null;
		}
		if (ptr.data == a || ptr.data == b) {
			return ptr;
		}
		treenode left = lowest(ptr.left, a, b);
		treenode right = lowest(ptr.right, a, b);
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return ptr;
	}
	/*
	 * condition ye hai ki dono nodes present hone chahiye tree mai ya dono not
	 * present hone chahiye tree mai
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lowest_common_ansestor_inBinarytree ob = new Lowest_common_ansestor_inBinarytree();
		treenode ptr = ob.make(sc);
		System.out.println("level order traversal of the tree is as follows");
		ob.level(ptr);
		treenode ctr = ob.lowest(ptr, 4, 6);
		System.out.println("\nThe lowest common ansestor of 7 and 3 is:" + ctr.data);
		sc.close();
	}
}
