package Array;

public class move_ZeroestoEnd {    //time complexity==O(n)
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int[] fun(int[] arr, int n) {
		int j = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				j = i;
				break;
			}
		}

		for (int i = j + 1; i < n; i++) {
			if (arr[i] != 0) {
				swap(arr, j, i);
				j++;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 0, 0, 0, 6, 7, 8, 9, };
		int[] ptr = fun(arr, arr.length);
		for (int i = 0; i < ptr.length; i++) {
			System.out.print(ptr[i] + " ");
		}
	}
}
