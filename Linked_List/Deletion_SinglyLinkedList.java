package Linked_List;

import java.util.*;

public class Deletion_SinglyLinkedList {
	public int counter = 0;

	public class node {
		int data;
		node next;

		node(int val) {
			this.data = val;
			this.next = null;
			counter++;
		}
	}

	node head = null;

	public void cre() {
		int a;
		int count = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the node val in the field");
			a = sc.nextInt();
			node temp = new node(a);
			if (head == null) {
				head = temp;
			} else {
				temp.next = head;
				head = temp;
			}
			System.out.println("press 1  to continue and -1 for exit");
			count = sc.nextInt();
		} while (count != -1);
	}

	public void pri() {
		node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	public int del() {
		int a = head.data;
		node temp = head;
		temp = temp.next;
		head = temp;
		return a;
	}

	public int del_last() {
		node pre = head;
		node temp = head.next;
		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		int a = temp.data;
		pre.next = temp.next;
		return a;
	}

	public int pos_del(int pos) {
		int count = 2;
		node pre = head;
		node temp = head.next;
		while (count != pos) {
			pre = temp;
			temp = temp.next;
			count++;
		}
		int r = temp.data;
		pre.next = temp.next;
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deletion_SinglyLinkedList ob = new Deletion_SinglyLinkedList();
		ob.cre();
		ob.pri();
		System.out.println("\nthe total node in the list is -->" + ob.counter);

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
