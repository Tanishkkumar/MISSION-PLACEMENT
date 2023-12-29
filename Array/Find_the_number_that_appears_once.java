package Array;

import java.util.Map;
import java.util.HashMap;

public class Find_the_number_that_appears_once {
	public static void main(String[] args) {
		int[] arr = { 4,1,2,1,2};
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
             if(m.containsKey(arr[i])) {
            	 m.put(arr[i], m.get(arr[i])+1);
             }
             else {
            	 m.put(arr[i], 1);
             }
		}
		int min=Integer.MAX_VALUE;
		int ans=0;
		for(Map.Entry<Integer, Integer>m1 :m.entrySet()) {
			int key=m1.getKey();
			int val=m1.getValue();
			if(val<min) {
				min=val;
				ans=key;
			}
		}
		System.out.println("the element that appears only once is::"+ans);
	}
}
