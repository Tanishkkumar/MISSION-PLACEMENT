package Array;

public class MaxOccurence_MOORE_Algo {
	public static int fun(int[]arr) {
		int cnt=0;
		int ele=arr[0];
		int i=0;
		while(i<arr.length) {
			if(arr[i]==ele) {
				cnt++;
				i++;
			}
			else if(arr[i]!=ele) {
				cnt--;
				i++;
			}
			if(cnt==0 && (i+1)<arr.length) {
				ele=arr[i+1];
			}
		}
		return ele;
	}
	
	public static boolean check(int []arr,int ele) {
		int size=arr.length/2;
		int cnt=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==ele) {
				cnt++;
			}
		}
		if(cnt>size) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[] arr = { 7, 7, 5, 7, 5, 1, 5, 7, 5, 7,7 };
		int maxnumber=fun(arr);
		if(check(arr,maxnumber)) {
		System.out.println("The element occured more than size/2 times in the array is::"+maxnumber);
	}
		else {
			System.out.println("The max occured number is::"+maxnumber+"\nBut does not occured more than size/2 times in the array");
		}
	}
}
