package Array;

import java.util.*;

public class multidim_array {

	public static void main(String[] args) {
		int f=3;
		int t=2;
		int[] arr[] = new int[f][t];
		Scanner s = new Scanner(System.in);
		System.out.println("enter the aaray elementn in the field");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		System.out.println("the printing of the array is as follows");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
