package LinkedList;

class node1 {
	int data;
	node1 next;

	node1(int val) {
		this.data = val;
		this.next = null;
	}
}

public class InsertNode {
	public static node1 insertion(int a, node1 head) {
		node1 arr = new node1(a);
		arr.next = head;
		head = arr;
		return head;
	}

	public static void main(String[] args) {
		node1 head = null;
		head = insertion(10, head);
		head = insertion(20, head);
		head = insertion(30, head);
		head = insertion(40, head);
		System.out.println("printing the linked list");
		pri(head);
	}
}
