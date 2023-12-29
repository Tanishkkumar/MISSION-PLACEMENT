package Array;

public class longestsubarrayTwoPointerapproch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 1, 1, 1, 3, 3 };
		int key = 7;
		int st = 0, end = 0;
		int sum = 0;
		int len = 0;
		int diff;
		while (end < arr.length) {
			diff = 0;
			sum += arr[end++];
			if (sum > key) {
				while (sum >= key) {
					sum -= arr[st++];
				}
			} else if (sum == key) {
				diff = (end - st);
				if (len < diff) {
					len = diff;
				}
			}
		}
		System.out.println("the length of the longest subarray is::" + len);
	}
}
