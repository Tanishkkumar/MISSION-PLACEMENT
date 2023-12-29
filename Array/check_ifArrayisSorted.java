package Array;

public class check_ifArrayisSorted {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 8,6};
        int count=0;
        for(int i=0;i<arr.length-1;i++) {
        	if(arr[i]>arr[i+1]) {
        		count++;
        	}
        }
        if(count!=0) {
        	System.out.println("the array is not sorted");
        }
        else {
        	System.out.println("the array is sorted");
        }
	}
}
