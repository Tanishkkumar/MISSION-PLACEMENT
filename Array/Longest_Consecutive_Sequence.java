package Array;

public class Longest_Consecutive_Sequence {
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int quick(int[] arr, int st, int end) {
		int pivot = arr[end];
		int i = st - 1;
		for (int j = st; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, end);
		return i + 1;

	}

	public static void fun(int[] arr, int st, int end) {
		if (st < end) {
			int p = quick(arr, st, end);
			fun(arr, st, p - 1);
			fun(arr, p + 1, end);
		}
	}

	public static int sequence(int[] arr) {
		int curr = 0;
		int l = 1;
		int cnt = 0;
		int lastsmaller = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - 1 == lastsmaller) {
				cnt = cnt + 1;
				lastsmaller = arr[i];
			} else if (arr[i] != lastsmaller) {
				cnt = 1;
				lastsmaller = arr[i];
			}
			l = Math.max(l, cnt);
		}
		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2 };
		fun(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int longest = sequence(arr);
		System.out.println("\nthe longest subsequnce is::" + longest);
	}
}
