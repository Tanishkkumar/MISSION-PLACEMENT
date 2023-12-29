package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;

public class Top_view_apniKAKSHA {
	class node {
		int data;
		node left;
		node right;

		node(int a) {
			data = a;
			left = null;
			right = null;
		}
	}

	public static void fun(int a) {
		System.out.println();
		for (int i = 0; i < a; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public int count = 0;

	public node make(Scanner sc) {
		int a;
		node ptr = null;
		if (count == 0) {
			System.out.println("enter the main root value in the field");
			count = -1;
		}
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		ptr = new node(a);
		System.out.println("enter the left child of:" + a);
		ptr.left = make(sc);
		System.out.println("enter the right child of:" + a);
		ptr.right = make(sc);
		return ptr;
	}

	public void level(node ptr) {
		Queue<node> q = new LinkedList<>();
		q.add(ptr);
		q.add(null);
		while (!q.isEmpty()) {
			node cu = q.poll();
			if (cu == null) {
				if (q.isEmpty()) {
					return;
				}
				q.add(null);
				System.out.println();
			} else {
				System.out.print(cu.data + " ");
				if (cu.left != null) {
					q.add(cu.left);
				}
				if (cu.right != null) {
					q.add(cu.right);
				}
			}
		}
	}

	class info {
		node ptr;
		int hd; // horizontal distance

		public info(node arr, int horidist) {
			this.ptr = arr;
			this.hd = horidist;
		}
	}

	public void top(node arr) {
		Queue<info> q = new LinkedList<>();
		HashMap<Integer, node> map = new HashMap<>();
		int min = 0, max = 0;
		q.add(new info(arr, 0));
		q.add(null);
		while (!q.isEmpty()) {
			info curr = q.remove();
			if (curr == null) {
				if (q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				if (!map.containsKey(curr.hd)) {
					map.put(curr.hd, curr.ptr);
				}
				if (curr.ptr.left != null) {
					q.add(new info(curr.ptr.left, curr.hd - 1));
					min = Math.min(min, curr.hd - 1);
				}
				if (curr.ptr.right != null) {
					q.add(new info(curr.ptr.right, curr.hd + 1));
					max = Math.max(max, curr.hd + 1);
				}
			}
		}
		for (int i = min; i <= max; i++) {
			System.out.print(map.get(i).data + " ");
		}
	}

	public static void main(String[] args) {
		Top_view_apniKAKSHA ob = new Top_view_apniKAKSHA();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the data for the first main tree");
		fun(32);
		node root = ob.make(sc);
		System.out.println("\nthe level order traversal of the tree is as follows");
		ob.level(root);
		fun(32);
		System.out.println("the top view of the tree is as follows");
		ob.top(root);

	}
}
