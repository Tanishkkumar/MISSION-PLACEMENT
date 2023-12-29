package Linked_List;

import java.util.Scanner;

public class Deletion_DoublyLinkedList {
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
		System.out.println("\nthe doubly linked list is as follows");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public int del() {
		int a = head.data;
		head = head.next;
		head.pre = null;
		return a;
	}

	public int del_last() {
		int a = tail.data;
		tail.pre.next = null;
		return a;

	}

	public int pos_del(int pos) {
		int count = 2;
		node prev = head;
		node temp = head.next;
		while (count != pos) {
			prev = temp;
			temp = temp.next;
			count++;
		}
		int r = temp.data;
		prev.next = temp.next;
		temp.next.pre = prev;
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deletion_DoublyLinkedList ob = new Deletion_DoublyLinkedList();
		ob.creation();
		ob.pri();
		System.out.println("\nthe pre node of tail node is-->" + ob.tail.pre.data);

		// deletion form the starting node of the list.
		int y = ob.del();
		System.out.println("\nthe deleted node is-->" + y);
		ob.pri();

		// delete from the end of the list.
		int l = ob.del_last();
		System.out.println("\nthe deleted node is-->" + l);
		ob.pri();

		// delete from any specific position.
		int pos = 0;
		System.out.println("\nenter the position in the field");
		pos = sc.nextInt();
		int z = ob.pos_del(pos);
		System.out.println("\nthe deleted node is-->" + z);
		ob.pri();
	}
}
