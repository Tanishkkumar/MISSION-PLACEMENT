package Strings;

import java.util.Arrays;

public class anagram {
	public static String SortString(String arr) {
		char[] c = arr.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	public static boolean check(String arr, String ptr) {
		if (arr.length() != ptr.length()) {
			return false;
		}
		arr = SortString(arr);
		ptr = SortString(ptr);
		for (int i = 0; i < arr.length();i++) {
			if (arr.charAt(i) != ptr.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String arr = "cat";
		String ptr = "tac";
		if (check(arr, ptr)) {
			System.out.println("Present");
		} else {
			System.out.println("Not present");
		}
	}
}
