package Searching_Sorting;

import java.util.*;

public class DEMO {
	public static void  swap(int []arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void selection(int[] arr) {	
		    int a=0;
		    while(a<arr.length) {
		    	int min=999;
		    	for(int i=a;i<arr.length;i++) {
		    		if(arr[i]<min) {
		    			min=arr[i];
		    		}
		    	}
		    	swap(arr,a,min);
		    	a=a+1;
		    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.println("enter the size in the field\n");
		a = sc.nextInt();
		int[] arr = new int[a];
		System.out.println("enter the array in the field\n");
		for (int i = 0; i < a; i++) {
			int c = sc.nextInt();
			arr[i] = c;
		}	
		selection(arr);
		System.out.println("After sorting the array\n");
		for(int i=0;i<a;i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
