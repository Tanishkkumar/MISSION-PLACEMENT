package Linked_List;

import java.util.*;

import Linked_List.Deletion_SinglyLinkedList.node;

public class Deletion_CircularLinkedList {
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

	public int del() {
		int a = head.data;
		head = head.next;
		tail.next = head;
		return a;
	}

	public int del_last() {
		node pre = head;
		node temp = head.next;
		while (temp.next != head) {
			pre = temp;
			temp = temp.next;
		}
		int a = temp.data;
		pre.next = temp.next;
		tail = pre;
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
		Deletion_CircularLinkedList ob = new Deletion_CircularLinkedList();
		ob.creation();
		ob.pri();

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
