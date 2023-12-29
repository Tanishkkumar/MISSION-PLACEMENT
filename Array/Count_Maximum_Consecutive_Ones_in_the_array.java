package Array;

public class Count_Maximum_Consecutive_Ones_in_the_array {
	public static void main(String[] args) {
		int[] arr = { 0,1,1,1,0,0,0,1,1,1,1,0,0};
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				cnt = 0;
			}
			if (arr[i] == 1) {
				cnt++;
			}
			if (cnt > max) {
				max = cnt;
			}
		}
		System.out.println("the maximum count is::"+max);
	}
}
