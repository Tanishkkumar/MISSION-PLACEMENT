package Searching_Sorting;

import java.util.Scanner;

//**Remember array should be in monotonic order(incresing or decreasig)
public class Binary_search {

	public static boolean fun(int[] arr, int key) {
		int st = 0;
		int end = arr.length - 1;
		int mid = st + (end - st) / 2;
		while (st <= end) {
			if (key == arr[mid]) {
				return true;
			}
			if (key > arr[mid]) {
				st = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = st + (end - st) / 2;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b = 0;
		int key;
		System.out.println("enter the size of the array in the field");
		a = sc.nextInt();
		int[] arr = new int[a];
		System.out.println("\nenter the array element in the field");
		for (int i = 0; i < a; i++) {
			System.out.print(i + "::");
			b = sc.nextInt();
			arr[i] = b;
		}
		System.out.println("enter the key u want to  search in the array");
		key = sc.nextInt();
		if (fun(arr, key) == true) {
			System.out.println("founded");
		} else {
			System.out.println("not founded");
		}
		sc.close();
	}
}
