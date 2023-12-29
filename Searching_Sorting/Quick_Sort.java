package Searching_Sorting;

public class Quick_Sort {
	public static void swap(int []arr,int a,int b) {
		int t=arr[a];
		arr[a]=arr[b];
		arr[b]=t;
	}
	public static int quick(int []arr,int st,int end) {
		 int pivot=arr[end];
		 int i=st-1;
		 for(int j=st;j<end;j++) {
			 if(arr[j]<pivot) {
				 i++;
				 swap(arr,i,j);
			 }
		 }
		 swap(arr,i+1,end);
		 return i+1;
		 
	}
	 public static void fun(int arr[],int st,int end) {
		 if(st<end) {
			 int p=quick(arr,st,end);
			 fun(arr,st,p-1);
			 fun(arr,p+1,end);
		 }
	 }

	public static void main(String[] args) {
		int []arr= {1,1,2,0,0,0,6,5};
		fun(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
