package Stack;

public class balanced_parenthesis {
	class node {
		char data;
		node next;

		node(char val) {
			this.data = val;
			this.next = null;
		}
	}

	node top = null;

	public int check(String arr) {

		for (int i = 0; i < arr.length(); i++) {
			if (arr.charAt(i) == '(' || arr.charAt(i) == '[' || arr.charAt(i) == '{') {
				node ptr = new node(arr.charAt(i));
				ptr.next = top;
				top = ptr;
			} else if (arr.charAt(i) == ')' || arr.charAt(i) == ']' || arr.charAt(i) == '}') {
				if (top == null) {
					return 0;
				}
				else if((arr.charAt(i) ==')' && top.data=='(') || (arr.charAt(i) ==']' && top.data=='[') || (arr.charAt(i) =='}' && top.data=='{')) {
				top = top.next;
				}
			}
		}

		if (top == null) {
			return 1;
		} else {
			return 0;
		}

	}

	public static void main(String[] args) {
		balanced_parenthesis ob = new balanced_parenthesis();
		String arr = "[((8)*(9))]";
		System.out.println(arr);
		if (ob.check(arr) == 1) {
			System.out.println("parenthesis matched");
		} else {
			System.out.println("not matched");
		}
	}
}
