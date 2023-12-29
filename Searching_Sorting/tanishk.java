package Searching_Sorting;

import java.util.*;

public class tanishk {
	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		String arr = "this is an amazing program";
		// System.out.println(arr);
		String ptr = "";
		for (int i = 0; i < arr.length(); i++) {
			if (arr.charAt(i) == ' ') {
				st.push(ptr);
				ptr = "";
			} else {
				ptr += arr.charAt(i);
			}
		}
		String ans = "";
		while (st.size() != 1) {
			ans += st.peek() + " ";
			st.pop();
		}
		ans += st.peek();
		System.out.println(ans);
	}
}
