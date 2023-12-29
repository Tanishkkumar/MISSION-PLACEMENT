package Tree;

import java.util.Scanner;

public class sizeof_BinaryTree {
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
		System.out.println("enter the value u want");
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		root = new node(a);
		System.out.println("enter the left child of--" + a);
		root.left = make(sc);
		System.out.println("enter the right child of--" + a);
		root.right = make(sc);
		return root;
	}

	public void inorder(node ptr) {
		if (ptr == null) {
			return;
		}
		inorder(ptr.left);
		System.out.print(ptr.data + " ");
		inorder(ptr.right);
	}

	//number of nodes method
	public int numberofnodes(node ptr) {
		if (ptr == null) {
			return 0;
		}
		return numberofnodes(ptr.left) + numberofnodes(ptr.right) + 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sizeof_BinaryTree ob = new sizeof_BinaryTree();
		node ptr = ob.make(sc);
		System.out.println("tree is as follows");
		ob.inorder(ptr);
		System.out.println("\nnumber of nodes in the tree is-->" + ob.numberofnodes(ptr));

	}

}
