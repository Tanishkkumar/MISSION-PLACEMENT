package Linked_List;

import java.util.Scanner;

public class Doubly_LinkedList {
	public class node {
		int data;
		node next;
		node pre;

		node(int val) {
			this.data = val;
			this.next = null;
			this.pre = null;
		}
	}

	node head = null;
	node tail = null;

	public void creation() {

		int a;
		int count = 1;
		do {
			Scanner s = new Scanner(System.in);
			System.out.println("enter the node in the field");
			a = s.nextInt();
			node new_node = new node(a);
			if (head == null) {
				head = new_node;
				tail = new_node;
			} else {
				new_node.next = head;
				head.pre = new_node;
				head = new_node;

			}
			System.out.println("do you want to continue if yes enter 1 if no enter -1");
			count = s.nextInt();
		} while (count != -1);

	}

	public void trav() { // traversal time O(n)
		node temp = head;
		System.out.println("the linked list is as follows");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Doubly_LinkedList ptr = new Doubly_LinkedList();
		ptr.creation();
		ptr.trav();
		System.out.println("the pre node of tail node is-->" + ptr.tail.pre.data);

	}

}
