package Array;

import java.util.Map;
import java.util.HashMap;

public class Two_Sum {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 5, 8, 11 };
		int key = 14;
		int diff=0;
		int a=0,b=0;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
              diff=Math.abs(key-arr[i]);
              if(m.containsKey(diff)==true) {
            	  a=i;
            	  b=m.get(diff);
              }
              else {
            	  m.put(arr[i], i);
              }
		}
		System.out.println(a+"::"+b);
	}
}
