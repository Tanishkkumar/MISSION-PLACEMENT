package Tree;

public class heapsort_in_Arrayform {
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public void heapify(int[] arr, int size, int index) {
		int largest = index;
		int left = 2 * index;
		int right = 2 * index + 1;
		if (left <= size && arr[largest] < arr[left]) {
			largest = left;
		}
		if (right <= size && arr[largest] < arr[right]) {
			largest = right;
		} 
		if (largest != index) {
			swap(arr, largest, index);
			heapify(arr, size, largest);
		}
	}

	public void pri(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		heapsort_in_Arrayform ob = new heapsort_in_Arrayform();
		int[] arr = { -1, 54, 53, 55, 52, 50 };
		int a = 5;
		for (int i = a / 2; i > 0; i--) {
			ob.heapify(arr, a, i);
		}
		System.out.println("Array After heapify is as follows");
		ob.pri(arr);
	}
}
