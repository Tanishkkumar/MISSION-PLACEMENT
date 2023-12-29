package Tree;

//flattened binary tree code(to Doubly linked list).
import java.util.Scanner;
import java.util.*;

public class Binary_tree_to_DLL {
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

	public node head = null;
	public node prev = null;

	public void inorder(node ptr) {
		if (ptr == null) {
			return;
		}
		node cu = new node(ptr.data);
		inorder(ptr.left);
		if (prev == null) {
			head = cu;
		} else {
			prev.right = cu;
			cu.left = prev;
		}
		prev = cu;
		inorder(ptr.right);
	}

	public node linked(node ptr) {
		if (ptr == null) {
			return null;
		}
		inorder(ptr);
		return head;
	}

	public void display(node hd) {
		node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.right;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Binary_tree_to_DLL ob = new Binary_tree_to_DLL();
		node root = ob.make(sc);
		System.out.println("the  level order traversal of the tree is as follows");
		ob.level(root);
		node ptr = ob.linked(root);
		System.out.println("\nThe doubly linked list is as follows");
		ob.display(ptr);
	}
}
