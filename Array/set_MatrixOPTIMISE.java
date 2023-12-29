package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class set_MatrixOPTIMISE {
	public static void fun(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> ptr, ArrayList<Integer> ctr) {
		// to display the 2d arraylist
		for (ArrayList<Integer> r : arr) {
			for(int val:r) {
			System.out.print(val + " ");
		}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of row in the field");
		int row = sc.nextInt();
		System.out.println("enter the number of col in the field");
		int col = sc.nextInt();
		System.out.println("enter the matric now ");
		for (int i = 0; i < row; i++) {
			ArrayList<Integer> mat = new ArrayList<>();
			for (int j = 0; j < col; j++) {
				System.out.println("arr[" + i + "]" + "[" + j + "]");
				mat.add(sc.nextInt());
			}
			arr.add(mat);
		}
		ArrayList<Integer> ptr = new ArrayList<>();
		ArrayList<Integer> ctr = new ArrayList<>();
		fun(arr, ptr, ctr);
	}
}
