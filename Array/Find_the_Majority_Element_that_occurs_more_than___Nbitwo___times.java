package Array;

import java.util.Map;

import java.util.HashMap;

public class Find_the_Majority_Element_that_occurs_more_than___Nbitwo___times {
	public static int fun(int[] arr, int size) {
		Map<Integer, Integer> m = new HashMap<>();
		Map<Integer,Integer> arr=new HashMap<>();
		 for(int i=0;i<arr.length;i++) {
	        	int a=arr[i];
	        	if(m.containsKey(a)) {
	        		int cnt=m.get(a);
	        		m.put(a,cnt+1);
	        	}
	        	else {
	        		m.put(a,1);
	        	}
        }
		
		int z=size/2; 
        for(Map.Entry<Integer,Integer> ptr:m.entrySet()) {
        	if(ptr.getValue()>z) {
        		return ptr.getKey();
        	}
        }
        return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 1, 3,1,1,3,1,1};
		int a=0;
		 a = fun(arr, arr.length);
		System.out.println("the number which occur more than array size/2 is::" + a);
	}
}
