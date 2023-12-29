package Linked_List;

import java.util.*;

public class Singlelinkedlist_insertionAtanypos {
	public static  int counter=0;
	static  class node {
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
		int c = 0;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("enter the node in the field");
			a = s.nextInt();
			node ptr = new node(a);
			if (head == null) {
				head = ptr;
			} else {
				ptr.next = head;
				head = ptr;
			}
			System.out.println("do you want to continue 1 for y and -1 for N");
			c = s.nextInt();
		} while (c != -1);

	}

	public void pri() {
		node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\ntotal nodes in the list is-->"+counter);
	}

	public void front(int z) {
		node kp = new node(z);
		kp.next = head;
		head = kp;
	}

	public void end(int a) {
      node temp=head;
      node ptr=new node(a);
      while(temp.next!=null) {
    	  temp=temp.next;
      }
      temp.next=ptr;
      
	}
	
	
	public void any(int a,int pos) {
		int count=2;
		node ptr=new node(a);
		node temp=head;
		node pre=head;
		temp=temp.next;
		while(count!=pos) {
			pre=pre.next;
			temp=temp.next;
			count++;
		}
		ptr.next=pre.next;
		pre.next=ptr;
		
	}

	public static void main(String[] args) {
		Singlelinkedlist_insertionAtanypos pt = new Singlelinkedlist_insertionAtanypos();
		pt.cre();
		pt.pri();

		// at the beginig of the linke list.
		System.out.println("\nenter the node u want to  insert at the begining of the linked list");
		Scanner a = new Scanner(System.in);
		int ptr = a.nextInt();
		pt.front(ptr);
		pt.pri();
		System.out.println("\nthe head node in the linked list is -->" + pt.head.data);
       
		
		//insert at the end of the linked list .
		System.out.println("\nenter the node u want to  insert at the end of the linked list");
		ptr = a.nextInt();
		pt.end(ptr);
		pt.pri();
		System.out.println("\nthe head node in the linked list is -->" + pt.head.data);
		
		
		//insert at the any specific position  in the linked list .
				System.out.println("\nenter the node u want to  insert in the linked list");
				int pos;
				ptr = a.nextInt();
				System.out.println("enter the pos of the entered node");
				pos=a.nextInt();
				pt.any(ptr,pos);
				pt.pri();
				System.out.println("\nthe head node in the linked list is -->" + pt.head.data);

	}
}
