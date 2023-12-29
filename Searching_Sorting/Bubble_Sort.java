package Searching_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bubble_Sort {
	public static void bubblesort(ArrayList<Integer> arr) {
     int a=arr.size();
     int count;
     int i=1;
     while(a>i) {	
    	 count=0;    //ye isiliye agar array pehle se sorted hue ya iteration ke process mai kisi bhe round pe poori aray sort ho gyi 
    	 for(int j=0;j<a-1;j++) {   // to ye tabhi loop ko break kar dega or time bacha lega.
    		 if(arr.get(j)>arr.get(j+1)) {
    			 Collections.swap(arr,j,j+1);
    			 count++;
    		 }
    	 }
    	 if(count==0) {
    		 break;
    	 }
    	 a--;
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
		bubblesort(arr);
		System.out.println("\nAfter\n");
		for (int i = 0; i < a; i++) {
			System.out.print(arr.get(i) + " ");
		}
		sc.close();
	}
}
