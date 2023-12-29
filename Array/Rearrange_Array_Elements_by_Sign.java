package Array;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;   //TIME COMPLEXITY O(N) 

public class Rearrange_Array_Elements_by_Sign {
	public static void fun(int[] arr, ArrayList<Integer> ptr, AtomicInteger a, AtomicInteger b) {
		// int a = arr.length;
		int cnt = 0;
		a.set(cnt);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				ptr.add(arr[i]);
				cnt++;
				// a.set(i);
			}
		}
		b.set(cnt);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				ptr.add(arr[i]);
				// ptr[cnt++] = arr[i];
				cnt++;
			}
		}

	}

	public static void main(String[] args) {
		int[] arr = {  -12, 9, -7, 14, -2, 8, -5, 11, -15, 4, -10, 18, -3, 6, -20, 13, -1, 17, -9, 22, -6, 16, -4, 7,
				-11, 25, -8, 19, -13, 29, -16, 23, -14, 31, -18, 26, -21, 35, -24, 28, -22, 38, -27, 32, -30, 41, -33,
				37, -36, 44, -39, 40, -42, 47, -45, 43, -48, 50 };
		System.out.println("the length of original array is:" + arr.length);
		ArrayList<Integer> ctr = new ArrayList<>();
		AtomicInteger a = new AtomicInteger(-1);
		AtomicInteger b = new AtomicInteger(-1);
		fun(arr, ctr, a, b);
		System.out.println("the length of the array list is as follows" + ctr.size());
		System.out.println(
				"the separating point between positive and negative values are::" + a.get() + " and " + b.get());
		for (int i = 0; i < ctr.size(); i++) {
			int p = ctr.get(i);
			System.out.print(p + " ");
		}
		int i = 0;
		int cnt1 = a.get();
		int cnt2 = b.get();
		while (i < ctr.size()) {
			if (cnt1 < cnt2) {
				arr[i++] = ctr.get(cnt1++);
			}
			if (cnt2 < ctr.size()) {
				arr[i++] = ctr.get(cnt2++);
			}
		}
		System.out.println("\n\nafter the array conversion::\n\n");
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n\narray length is::" + arr.length);

	}
}
