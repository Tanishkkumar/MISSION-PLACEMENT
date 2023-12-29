package Collections;

import java.util.Map;
import java.util.HashMap;

public class count_frequejcy_pairs {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4,4, 5,5, 1, 1, 1, 2, 2, 3, 3, 3, 10 };
		Map<Integer, Integer> ptr = new HashMap<>();
		int max = Integer.MIN_VALUE, maxelement = 0;
		int min = Integer.MAX_VALUE, minelement = 0;
		for (int i = 0; i < arr.length; i++) {
			if (ptr.containsKey(arr[i])) {
				ptr.put(arr[i], ptr.get(arr[i]) + 1);
			} else {
				ptr.put(arr[i], 1);
			}
		}
		// printing of the map in the field.
		for (Map.Entry<Integer, Integer> m : ptr.entrySet()) {
			int key = m.getKey();
			int value = m.getValue();
			if (value > max) {
				max = value;
				maxelement = key;
			}
			if (value < min) {
				min = value;
				minelement = key;
			}
		}
      //printing of the minimum and the maximum value;
		System.out.println("the max occured element is::"+maxelement);
		System.out.println("the min occured element is::"+minelement);
	}
}
