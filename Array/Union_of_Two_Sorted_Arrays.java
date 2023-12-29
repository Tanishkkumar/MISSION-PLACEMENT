package Array;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap; //10 111 12 13 14     1 2 12 14 105

public class Union_of_Two_Sorted_Arrays {
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int sorting(int[] arr, int st, int end) {
		int p = arr[st];
		int cnt = 0;
		for (int i = st+1; i <=end; i++) {
			if (arr[i] < p) {
				cnt++;
			}
		}
		int pivotindex = cnt + st;
		swap(arr, st, pivotindex);
		int i = st;
		int j = end;
		while (i < pivotindex && j > pivotindex) {

			while (arr[i] <= p) {
				i++;
			}

			while (arr[j] > p) {
				j--;
			}

			if (i < pivotindex && j > pivotindex) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		return pivotindex;
	}

	public static void quicksort(int[] arr, int st, int end) {
		if (st >= end) {
			return;
		}
		int pivot = sorting(arr, st, end);
		quicksort(arr, st, pivot - 1);
		quicksort(arr, pivot + 1, end);
	}

	public static Map<Integer, Integer> fun(int[] arr, int[] ptr, int a, int b) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < a + b; i++) {
			if (i < a) {
				if (m.containsKey(arr[i]) == false) {
					m.put(arr[i], 1);
				}
			}
			if (i < b) {
				if (m.containsKey(ptr[i]) == false) {
					m.put(ptr[i], 1);
				}
			}
		}
		return m;
	}

	public static void main(String[] args) {
		int a = 0, b = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the first array");
		a = sc.nextInt();
		System.out.println("enter the size of the secodn array");
		b = sc.nextInt();
		int[] arr = new int[a];
		int[] ptr = new int[b];
		System.out.println("\nenter the first array");
		for (int i = 0; i < a; i++) {
			int p = sc.nextInt();
			arr[i] = p;
		}
		System.out.println("\nenter the second array");
		for (int i = 0; i < b; i++) {
			int p = sc.nextInt();
			ptr[i] = p;
		}
		quicksort(arr, 0, a - 1);
		quicksort(ptr, 0, b - 1);
		Map<Integer, Integer> m = fun(arr, ptr, a, b);
		System.out.println("\nThe union of the  two sorted arrau is::");
		for (Map.Entry<Integer, Integer> m1 : m.entrySet()) {
			int k = m1.getKey();
			System.out.print(k + " ");
		}
		sc.close();
	}
}
