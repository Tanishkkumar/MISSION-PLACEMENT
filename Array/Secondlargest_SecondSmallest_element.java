package Array;

public class Secondlargest_SecondSmallest_element {
	public static void main(String[] args) {
		int[] arr = {29, 47, 12, 86, 53, 71, 64, 91, 6, 18};
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		int a = 0, b = 0;
		int max2 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max - arr[i] < max2 && arr[i]!=max) {
				max2 = max - arr[i];
				a = arr[i];
//				System.out.println("the value of max2 is::"+max2);
//				System.out.println("the value of a is::"+a);
			}
			if (max - arr[i] > min2 && arr[i]!=min) {
				min2 = max -arr[i];
				b = arr[i];
//				System.out.println("the value of max2 is::"+min2);
//				System.out.println("the value of a is::"+b);
			}
		}
		System.out.println("the second largest element in the array is::"+a);
		System.out.println("the second smallest element in the array is::"+b);

	}
}
