package Array;

import java.util.Scanner;

public class demoDASH {
	public static void fun(StringBuffer arr) {
		for (int i = 0; i < arr.length(); i++) {
			if (arr.charAt(i) == ' ') {
				arr.setCharAt(i, '_');
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ptr;
		System.out.println("enter the string in the field");
		ptr = sc.nextLine();
		StringBuffer arr = new StringBuffer(ptr);
		fun(arr);
		System.out.println(arr);
		sc.close();
	}
}
