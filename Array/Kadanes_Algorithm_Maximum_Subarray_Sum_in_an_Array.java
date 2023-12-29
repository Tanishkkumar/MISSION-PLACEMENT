package Array;

import java.util.concurrent.atomic.AtomicInteger;

public class Kadanes_Algorithm_Maximum_Subarray_Sum_in_an_Array {

	public static int fun(int[] arr, AtomicInteger a, AtomicInteger b) {
		int sum = 0; // -2,-3,4,-1,-2,1,5
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			
			if(sum>max) {
				b.set(i);
				max=sum;
			}
			if(sum<0) {
				sum=0;
				a.set(i+1);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5 };
		AtomicInteger a = new AtomicInteger(-1);
		AtomicInteger b = new AtomicInteger(-1);

		int maxsum = fun(arr, a, b);
		System.out.println("the max subarray sum is::" + maxsum);
		System.out.println("the value of a and b is->" + a + ":::" + b);
		System.out.println("\nthe sub array is");
		while (a.get() <= b.get()) {
			System.out.print(arr[a.get()] + " ");
			a.set(a.get() + 1);
		}
	}
}
