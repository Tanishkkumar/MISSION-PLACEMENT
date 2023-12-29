package Array;

public class remove_duplicatefrom_sortedArray {
	public static void swap(int []arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static int quick(int[] arr, int st, int end) {
		int pivot = arr[st];
		int cnt = 0;
		for (int i = st + 1; i <= end; i++) {
			if (arr[i] < pivot) {
				cnt++;
			}
		}
		int pivotindex = cnt + st;
		swap(arr,st,pivotindex);
		int i = st;
		int j = end;
		while (i < pivotindex && j > pivotindex) {
			while (arr[i] <= pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i < pivotindex && j > pivotindex) {
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		return pivotindex;
	}

	public static void fun(int[] arr, int st, int end) {
		if (st >= end) {
			return;
		}
		int pivotindex = quick(arr, st, end);
		fun(arr, st, pivotindex - 1);
		fun(arr, pivotindex + 1, end);
	}

	public static void main(String[] args) {
		int arr[] = { 29, 47, 12, 86, 53, 71,29,29, 64, 91, 6, 18 };
		fun(arr, 0, arr.length - 1);
		System.out.println("array after sorting");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int i=0;
		for(int j=1;j<arr.length;j++) {
			 if(arr[i]!=arr[j]) {
				i++;
				arr[i]=arr[j];
			 }
		}
		System.out.println();
		for(int k=0;k<i+1;k++) {
			System.out.print(arr[k]+" ");
		}
	}
}
