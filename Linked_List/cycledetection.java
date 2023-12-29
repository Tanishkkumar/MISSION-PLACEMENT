package Linked_List;

import java.util.*;

public class cycledetection {
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

	public void cre() {
		int a;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		do {
			a = 0;
			System.out.println("enter the node in the field");
			a = sc.nextInt();
			node ptr = new node(a);
			if (head == null) {
				head = ptr;
				tail = ptr;
			} else {
				ptr.next = head;
				head = ptr;
			}
			System.out.println("if u want to continue enter 1 else if u want to  quite enter -1");
			count = sc.nextInt();
		} while (count != -1);
		node ctr = head.next.next.next;
		tail.next = ctr;
	}

	public void pri() {
		node temp = head;
		while (temp != tail) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
	}

	node detect() {
		node slow = head;
		node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

	node firstCyclicNode() {
       node meet=detect();
       node start=head;
       while(start!=meet) {
    	   start=start.next;
    	   meet=meet.next;
       }
       return start;
	}

	public static void main(String[] args) {
		cycledetection c = new cycledetection();
		c.cre();
		c.pri();
		node ptr = c.detect();
		if (ptr != null) {
			System.out.println("\nCycle Detected --(Meeting node value of slow and fast) is--->" + ptr.data);
			node first=c.firstCyclicNode();
			System.out.println("\nthe first node of the cycle is-->"+first.data);
		} else {
			System.out.println("\nCycle Not Detected");
		}
		
		

	}
}
