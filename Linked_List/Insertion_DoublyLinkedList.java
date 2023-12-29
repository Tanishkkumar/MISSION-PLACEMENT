package Linked_List;

import java.util.Scanner;


public class Insertion_DoublyLinkedList {
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
			System.out.println("enter the node in the field for doubly linked list");
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

	public void pri() {
		node temp = head;
		System.out.println("the doubly linked list is as follows");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void front(int z) {
		node kp = new node(z);
		kp.next = head;
		head.pre = kp;
		head = kp;
	}

	public void end(int a) {
		// node temp = head;
		node ptr = new node(a);
		tail.next = ptr;
		ptr.pre = tail;
		tail = ptr;
	}

	public void any(int a, int pos) {
		int count = 2;
		node ptr = new node(a);
		node temp = head;
		node prev = head;
		temp = temp.next;
		while (count != pos) {
			prev = prev.next;
			temp = temp.next;
			count++;
		}
		ptr.next = prev.next;
		temp.pre = ptr;
		prev.next = ptr;
		ptr.pre = prev;
	}

	public static void main(String[] args) {
		Insertion_DoublyLinkedList pt = new Insertion_DoublyLinkedList();
		pt.creation();
		pt.pri();
		System.out.println("\nthe pre node of tail node is-->" + pt.tail.pre.data);

		// at the beginig of the linke list.
		System.out.println("\nenter the node u want to  insert at the begining of the doubly linked list");
		Scanner a = new Scanner(System.in);
		int ptr = a.nextInt();
		pt.front(ptr);
		pt.pri();
		System.out.println("\nthe head node in the linked list is -->" + pt.head.data);

		// insert at the end of the linked list .
		System.out.println("\nenter the node u want to  insert at the end of the doubly linked list");
		ptr = a.nextInt();
		pt.end(ptr);
		pt.pri();
		System.out.println("\nthe head node in the linked list is -->" + pt.head.data);

		// insert at the any specific position in the linked list .
		System.out.println("\nenter the node u want to  insert in the doubly linked list");
		int pos;
		ptr = a.nextInt();
		System.out.println("enter the pos of the entered node");
		pos = a.nextInt();
		pt.any(ptr, pos);
		pt.pri();
		System.out.println("\nthe head node in the doubly linked list is -->" + pt.head.data);
	}
}
