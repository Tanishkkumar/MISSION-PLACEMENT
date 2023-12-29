package Tree;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class update {
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

	public int count = 0;

	public node make(Scanner sc) {
		int a;
		node ptr = null;
		if (count == 0) {
			System.out.println("enter the main root value in the field");
			count = -2;
		}
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		ptr = new node(a);
		System.out.println("enter the left child of :" + a);
		ptr.left = make(sc);
		System.out.println("enter the right child of:" + a);
		ptr.right = make(sc);
		return ptr;
	}

//	public void inorder(node ptr) {
//		if (ptr == null) {
//			return;
//		}
//		inorder(ptr.left);
//		System.out.print(ptr.data + " ");
//		inorder(ptr.right);
//	}
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

	public int ht(node ptr) {
		if (ptr == null) {
			return 0; // is case mai node 0 return karega kyuki null nde ki koi height nahi hoti hai.
		}
		int l = ht(ptr.left);
		int r = ht(ptr.right);
		return Math.max(l, r) + 1;
	}

	public int num(node ptr) {
		if (ptr == null) {
			return 0; // null ka koi count nhi hota
		}
		int l = num(ptr.left);
		int r = num(ptr.right);
		return l + r + 1;
	}

	public int dia(node ptr) {   //O(n^2)
		if (ptr == null) {
			return 0;
		}
		int leftdia = dia(ptr.left);
		int rightdia = dia(ptr.right);
		int lht = ht(ptr.left);
		int rht = ht(ptr.right);
		int selfdia = lht + rht + 1;
		return Math.max(selfdia, Math.max(leftdia, rightdia));
	}


	public static void main(String[] args) {
		update ob = new update();
		Scanner sc = new Scanner(System.in);
		node root = ob.make(sc);
		System.out.println("the level order traversal of the tree is as follows");
		ob.level(root);
		System.out.println("\nthe height of the tree is -->" + ob.ht(root));
		System.out.println("\nthe total number of nodes in the tree is:" + ob.num(root));
		System.out.println("\nthe diameter of the tree is ::" + ob.dia(root));
	}
}
