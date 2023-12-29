package Tree;

import java.util.*;

public class traversal_inorder_preorder_postorder {
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

	public node cre(Scanner sc) {
		
		int d;
		node root = null;
		System.out.println("enter the value");
		d = sc.nextInt();
		if (d == -1) {
			return null;
		}
		root = new node(d);
		System.out.println("enter the left child of--"+d);
		root.left=cre(sc);
		System.out.println("enter the right child of--"+d);
		root.right=cre(sc);
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
	
	public void preorder(node ptr) {
		if (ptr == null) {
			return;
		}
		System.out.print(ptr.data + " ");
		preorder(ptr.left);
		preorder(ptr.right);
	}
	
	public void postorder(node ptr) {
		if (ptr == null) {
			return;
		}
		postorder(ptr.left);
		postorder(ptr.right);
		System.out.print(ptr.data + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		traversal_inorder_preorder_postorder ob = new traversal_inorder_preorder_postorder();
		node ptr = ob.cre(sc);
		System.out.println("inorder traversal of the tree is as follows");
		ob.inorder(ptr);
		System.out.println("\npreorder traversal of the tree is as follows");
		ob.preorder(ptr);
		System.out.println("\npostorder traversal of the tree is as follows");
		ob.postorder(ptr);
		sc.close();
	}

}
