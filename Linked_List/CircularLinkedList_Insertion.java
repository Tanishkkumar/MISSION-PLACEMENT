package Linked_List;

import java.util.*;

public class CircularLinkedList_Insertion {
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
				new_node.next = head;
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

	public void front(int z) {
		node kp = new node(z);
		kp.next = head;
		head = kp;
		tail.next = head;
	}

	public void end(int a) {
		node ptr = new node(a);
		tail.next = ptr;
		tail = ptr;
		ptr.next = head;
	}

	public void any(int a, int pos) {
		int count = 2;
		node ptr = new node(a);
		node temp = head;
		node pre = head;
		temp = temp.next;
		temp = temp.next;
		while (count != pos) {
			pre = pre.next;
			temp = temp.next;
			count++;
		}
		ptr.next = pre.next;
		pre.next = ptr;

	}

	public static void main(String[] args) {
		CircularLinkedList_Insertion pt = new CircularLinkedList_Insertion();
		pt.creation();
		pt.pri();

		// at the beginig of the circular linked list.
		System.out.println("\nenter the node u want to  insert at the begining of the linked list");
		Scanner a = new Scanner(System.in);
		int ptr = a.nextInt();
		pt.front(ptr);
		pt.pri();
		System.out.println("\nthe head node in the linked list is -->" + pt.head.data);

		// insert at the end of the circular linked list .
		System.out.println("\nenter the node u want to  insert at the end of the linked list");
		ptr = a.nextInt();
		pt.end(ptr);
		pt.pri();
		System.out.println("\nthe head node in the linked list is -->" + pt.head.data);

		// insert at the any specific position in the circular linked list .
		System.out.println("\nenter the node u want to  insert in the linked list");
		int pos;
		ptr = a.nextInt();
		System.out.println("enter the pos of the entered node");
		pos = a.nextInt();
		pt.any(ptr, pos);
		pt.pri();
		System.out.println("\nthe head node in the linked list is -->" + pt.head.data);

	}

}
