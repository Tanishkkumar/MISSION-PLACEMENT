package Array;

public class Find_the_missing_number_in_an_array {
	
	public static void main(String[] args) {
		int[] arr = { 11,12,14,15 };
		int k = 0;
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int b = Math.abs(arr[i] - arr[i + 1]);
			if (b > min) {
				min = b;
				k = i;
			}	
		}
      int ptr=arr[k]+(min-1);
      System.out.println(ptr);
	}
}
