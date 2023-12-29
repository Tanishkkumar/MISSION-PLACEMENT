package Searching_Sorting;

import java.util.Scanner;
     //************here arr[i]>arr[j]  but i must be less than j**************
public class Inversion_count_usingMergeSort {

	public static int mergesort(int[] arr, int st, int end) {
		int mid = (st + end) / 2;
		int left = mid - st + 1;
		int right = end - mid;
		int mainindex = st;
		int[] ptr = new int[left];
		int[] ctr = new int[right];
		for (int i = 0; i < left; i++) {
			ptr[i] = arr[mainindex++];
		}
		mainindex = mid + 1;
		for (int i = 0; i < right; i++) {
			ctr[i] = arr[mainindex++];
		}
		int index1 = 0, index2 = 0;
		mainindex = st;
		int cnt = 0;
		while (index1 < left && index2 < right) {
			if (ptr[index1] < ctr[index2]) {
				arr[mainindex++] = ptr[index1++];
			} else {
				cnt += mid - index1 + 1;  //this will count the inversion pairs
				arr[mainindex++] = ctr[index2++];
			}
		}
		while (index1 < left) {
			arr[mainindex++] = ptr[index1++];
		}
		while (index2 < right) {
			arr[mainindex++] = ctr[index2++];
		}
		return cnt;
	}

	public static int merging(int[] arr, int st, int end) {
		int cnt = 0;
		if (st >= end) {
			return cnt;
		}
		int mid = (st + end) / 2;
		cnt += merging(arr, st, mid);
		cnt += merging(arr, mid + 1, end);
		cnt += mergesort(arr, st, end);
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.println("enter the size of the array in the field\n");
		a = sc.nextInt();
		int arr[] = new int[a];
		System.out.println("enter the array in the field\n");
		for (int i = 0; i < a; i++) {
			int b = sc.nextInt();
			arr[i] = b;
		}
		System.out.println("\nBefore sorting\n");
		for (int i = 0; i < a; i++) {
			System.out.print(arr[i] + " ");
		}
		int inversionCount = merging(arr, 0, a - 1);
		System.out.println("\nAfter sorting\n");
		for (int i = 0; i < a; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nTotal number of inversion count is::"+inversionCount);


	}
}
