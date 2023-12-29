package Stack;

import java.util.*;

class stack {
	int top = -1;
	int n = 10;
	int[] arr = new int[n];

	public void push() {
		Scanner s = new Scanner(System.in);
		if (top == n - 1) {
			System.out.println("overflow condition");
		} else {
			int a;
			System.out.println("enter the data in the field");
			a = s.nextInt();
			top = top + 1;
			arr[top] = a;
		}
		s.close();
	}

	public int pop() {
		int b = -1;
		if (top == -1) {
			System.out.println("underflow condition");
		} else {
			b = arr[top];
			top--;

		}
		return b;
	}

	public void pri() {
		System.out.println("\nstack is as follows");
		for (int i = top; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
}

public class stack_usingArray {
	public static void main(String[] args) {
		stack st = new stack();
		st.push(); // O(1)
		System.out.println("pop element is-->" + st.pop()); // O(1)
		st.pri(); // O(N);
	}
}
