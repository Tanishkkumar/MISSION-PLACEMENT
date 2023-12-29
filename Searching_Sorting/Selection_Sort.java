package Searching_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Selection_Sort {
	public static void selection(ArrayList<Integer> arr) {
		int a=0;
		while(a<arr.size()) {
			int min=a;
			for(int i=a;i<arr.size();i++) {
				if(arr.get(i)<arr.get(min)) {
					min=i;
				}
			}
			Collections.swap(arr,a,min);
			a++;		
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int a, b = 0;
		System.out.println("enter the size of the array");
		a = sc.nextInt();
		for (int i = 0; i < a; i++) {
			System.out.print(i + "::");
			b = sc.nextInt();
			arr.add(b);
		}
		System.out.println("\nBefore Selection sort");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		selection(arr); // sorting method
		System.out.println("\nAfter Selection sort");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		sc.close();
	}
}
