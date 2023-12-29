package Array;

public class left_rotate {
	public static void fun(int[] arr, int a) {
		//int temp = arr[arr.length - 1];
//		for (int i = 1; i <= arr.length; i++) {
//			int ptr = arr[i - 1];
//			arr[i - 1] = temp;
//			temp = ptr;
//		}
		int temp=arr[0];
		for(int i=1;i<arr.length;i++) {
			int ptr=arr[i];
			arr[i-1]=ptr;
		}
		arr[arr.length-1]=temp;
		
		
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// before shifting
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		fun(arr, arr.length - 1); // function to left shift
		System.out.println();
		// after
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
