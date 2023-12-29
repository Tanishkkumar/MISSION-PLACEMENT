package Stack;

public class stack_LinkedList {
	class node {
		int data;
		node next;

		node(int a) {
			this.data = a;
			this.next = null;
		}
	}

	node top = null;

	public void insert(int val) {
		// Scanner sc=new Scanner(System.in);
		node ptr = new node(val);
		ptr.next = top;
		top = ptr;
	}

	public void dis() {
		node ptr = top;
		while (ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
	}

	public int pop() {
		int a = top.data;
		top = top.next;
		return a;
	}

	public static void main(String[] args) {
		stack_LinkedList ob = new stack_LinkedList();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		System.out.println("before pop operation");
		ob.dis();
		System.out.println("\npop element is-->" + ob.pop());
		System.out.println("\nafter  pop operation");
		ob.dis();

	}

}
