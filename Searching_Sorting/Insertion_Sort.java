package Searching_Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Insertion_Sort {
	public static void Insertionsort(ArrayList<Integer> arr) {
		 int a=arr.size();
		 for(int i=1;i<a;i++) {
			 int temp=arr.get(i);
			 int count=i-1;
			 while(count>=0) {
				 if(arr.get(count)>temp) {
					 arr.set(count+1, arr.get(count));
				 }
				 else {
					 break;	
				 }
				 count--;
			 }
			 arr.set(count+1	, temp);	
		 }
	}

	public static void main(String[] args) {
		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array in the field");
		a = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(a);
		System.out.println("enter the array element in the field\n");
		for (int i = 0; i < a; i++) {
			int b = sc.nextInt();
			arr.add(b);
		}
		System.out.println("\nBefore\n");
		for (int i = 0; i < a; i++) {
			System.out.print(arr.get(i) + " ");
		}
		Insertionsort(arr);
		System.out.println("\nAfter\n");
		for (int i = 0; i < a; i++) {
			System.out.print(arr.get(i) + " ");
		}
		sc.close();
	}
}
