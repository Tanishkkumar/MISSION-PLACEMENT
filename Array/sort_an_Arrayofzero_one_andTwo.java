package Array;

public class sort_an_Arrayofzero_one_andTwo {
	public static void swap(int []arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void fun(int []arr,int low,int mid,int high) {
		while(mid<=high) {
			if(arr[mid]==0) {
				swap(arr,mid,low);
				mid++;
				low++;
			}
			else if(arr[mid]==1) {
				mid++;
			}
			else {
				swap(arr,mid,high);
				high--;
			}
		}
	}
	public static void main(String[] args) {
	int []arr= {0,0,0,1,1,2,2,1,2,0,0,1,2,1,2,1,2,0};
	fun(arr,0,0,arr.length-1);
	System.out.println("array after being sorted on the basis of 0,1,2");
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+" ");
	}
}
}
