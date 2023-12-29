package Array;

public class Set_Matrix_Zero {
	public static void markrow(int[][] arr, int row) {
		int b = 0;
		while (b < arr[0].length) {
			if (arr[row][b] != 0) {
				arr[row][b] = -1;
			}
			b++;
		}
	}

	public static void markcol(int[][] arr, int col) {
		int a = 0;
		while (a < arr.length) {
			if (arr[a][col] != 0) {
				arr[a][col] = -1;
			}
			a++;
		}
	}

	public static void makezero(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == -1) {
					arr[i][j] = 0;
				}
			}
		}
	}

	public static void fun(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = -1;
					markrow(arr, i);
					markcol(arr, j);
				}
			}
		}

		// make them zero
		makezero(arr);
	}

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		// the array traversal is as follows.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// main operation
		fun(arr);
		System.out.println("\nafter the conversion");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
