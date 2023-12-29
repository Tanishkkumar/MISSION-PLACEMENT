package Linked_List;

import java.util.*;

public class CircularLinkedList {

	public class node {
		int data;
		node next;

		node(int val) {
			this.data = val;
			this.next = null;
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
				new_node.next=head;
			} else {
				new_node.next = head;
				head = new_node;
				tail.next = head;

			}
			System.out.println("do you want to continue if yes enter 1 if no enter -1");
			count = s.nextInt();
		} while (count != -1);
	}

	public void pri() {
		node temp = head;
		System.out.print(temp.data + " ");
		temp = temp.next;
		while (temp != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}
	

	public static void main(String[] args) {
		CircularLinkedList ob = new CircularLinkedList();
		ob.creation();
		ob.pri();

	}

}
