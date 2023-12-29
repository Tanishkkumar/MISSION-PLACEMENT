package Tree;

import java.util.*;

public class ConvertBinaryTree_intoDoublyLinkedlist {
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

	class doubly {
		int da;
		doubly next;
		doubly pre;

		doubly(int a) {
			this.da = a;
			this.next = null;
			this.pre = null;
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

	public doubly head = null;
	public doubly prev = null;

	public void inorder(node ptr) {
		if (ptr == null) {
			return;
		}
		inorder(ptr.left);
		doubly cu = new doubly(ptr.data);
		if (prev == null) {
			head = cu;
		} else {
			prev.next = cu;
			cu.pre = prev;
		}
		prev = cu;
		inorder(ptr.right);

	}

	public doubly linked(node ptr) {
		if (ptr == null) {
			return null;
		}
		inorder(ptr);
		return head;
	}

	public void display(doubly head) {
		doubly c = head;
		while (c != null) {
			System.out.print(c.da + " ");
			c = c.next;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConvertBinaryTree_intoDoublyLinkedlist ob = new ConvertBinaryTree_intoDoublyLinkedlist();
		node root = ob.make(sc);
		System.out.println("the  level order traversal of the tree is as follows");
		ob.level(root);
		doubly ptr = ob.linked(root);
		// System.out.println(ptr.da);
		System.out.println("\nThe doubly linked list is as follows");
		ob.display(ptr);

	}
}
