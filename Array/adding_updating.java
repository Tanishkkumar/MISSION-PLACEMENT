package Array;

import java.util.*;

public class adding_updating {

	public static void printarray(int[] ptr) {
		System.out.println("the array from method is as follows");
		for (int i = 0; i < ptr.length; i++) {
			System.out.print(ptr[i] + " ");
		}

		System.out.println("the length of array is-->" + ptr.length);
	}

	public static void main(String[] args) {
		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array in the field");
		a = sc.nextInt();
		int[] arr = new int[a];
		System.out.println("enter the array element in the field");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + "::");
			arr[i] = sc.nextInt();
		}
		System.out.println("the array is as follows");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		arr[2] = 45;
		System.out.println(arr[2]);

		// if we try to print arr[10] which is greater than than the allocated size .
		try {
			System.out.println(arr[10]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		printarray(arr);
	}
}
