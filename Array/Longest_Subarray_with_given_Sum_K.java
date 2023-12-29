package Array;

import java.util.Scanner;

public class Longest_Subarray_with_given_Sum_K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int key;
		System.out.println("please enter the key in the field");
		key = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int a = 0, b = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == key) {
					if (j - i + 1 > max) {
						max = j - i + 1;
						a = i;
						b = j;
					}
				}
			}
		}
		System.out.println("the longest sub array is::");
		for (int i = a; i <= b; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}
}
