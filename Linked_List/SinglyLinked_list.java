package Linked_List;

import java.util.*;

public class SinglyLinked_list {
	static class node {
		int data;
		node next;

		node(int val) {
			this.data = val;
			this.next = null; // here we use null instead of NULL.

		}
	}

	node head = null; // starting node

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
			} else {
				new_node.next = head;
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
		SinglyLinked_list ptr = new SinglyLinked_list();
		ptr.creation();
		ptr.trav();
	}
}
