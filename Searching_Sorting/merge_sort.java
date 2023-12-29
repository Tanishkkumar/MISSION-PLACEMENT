package Searching_Sorting;

import java.util.Scanner;

public class merge_sort {
	public static void pri(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void merge(int[] arr, int st, int end) {
		int mid = st + (end - st) / 2;
		int len1 = mid - st + 1;
		int len2 = end - mid;
		int[] ptr = new int[len1];
		int[] ctr = new int[len2];
		int mainindex = st;
		for (int i = 0; i < len1; i++) {
			ptr[i] = arr[mainindex++];
		}
		mainindex = mid + 1;
		for (int i = 0; i < len2; i++) {
			ctr[i] = arr[mid + 1 + i];
		}
		int index1 = 0;
		int index2 = 0;	
		mainindex = st;
		while (index1 < len1 && index2 < len2) {
			if (ptr[index1] < ctr[index2]) {
				arr[mainindex++] = ptr[index1++];
			} else {
				arr[mainindex++] = ctr[index2++];
			}
		}
		while (index1 < len1) {
			arr[mainindex++] = ptr[index1++];
		}
		while (index2 < len2) {
			arr[mainindex++] = ctr[index2++];
		}
		ptr=null;
		ctr=null;	

	}

	public static void mergesorting(int[] arr, int s, int end) {
		if (s >= end) {
			return;
		}
		int mid = s + (end - s) / 2;
		mergesorting(arr, s, mid);
		mergesorting(arr, mid + 1, end);
		merge(arr, s, end);
	}

	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array in the field");
		a = sc.nextInt();
		int[] arr = new int[a];
		System.out.println("enter the array element in the field\n");
		for (int i = 0; i < a; i++) {
			System.out.println(i + "::");
			int b = sc.nextInt();
			arr[i] = b;
		}
		System.out.println("\nBefore	\n");
		pri(arr);
		mergesorting(arr, 0, a - 1);
		System.out.println("\nAfter\n");
		pri(arr);
		sc.close();
	}
}

//1 15 8 4 11 20 3 7 19 10 12 2 17 5 9 13 6 16 14 18
