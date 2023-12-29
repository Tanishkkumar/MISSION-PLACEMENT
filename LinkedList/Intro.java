package LinkedList;

class node {
	int data;
	node next;

	node(int val) {
		this.data = val;
		this.next = null;
	}
}

public class Intro {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 7 };
		node y=new node(arr[0]);
		System.out.println(y.data  );
	}
}
