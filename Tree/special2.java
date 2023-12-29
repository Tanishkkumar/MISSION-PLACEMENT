package Tree;

import java.util.*;
import java.util.Queue.*;

public class special2 {
	class treenode {
		int data;
		treenode left;
		treenode right;

		treenode(int val) {
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}

	int count = 0;

	public treenode make(Scanner sc) {
		int a;
		treenode root = null;
		if (count <= 0) {
			System.out.println("enter the value of node in the field");
		}
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		count++;
		root = new treenode(a);
		System.out.println("enter the left child of:" + a);
		root.left = make(sc);
		System.out.println("enter the right child of:" + a);
		root.right = make(sc);
		return root;

	}

	public void level(treenode root) {
		Queue<treenode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			treenode c = q.poll();
			if (c == null) {
				if (q.isEmpty()) {
					return;
				}
				q.add(null);
				System.out.println();
			} else {
				System.out.print(c.data + " ");
				if (c.left != null) {
					q.add(c.left);
				}
				if (c.right != null) {
					q.add(c.right);
				}
			}
		}
	}

	public int ht(treenode ptr) {
		if (ptr == null) {
			return 0;
		}
		return Math.max(ht(ptr.left), ht(ptr.right)) + 1;
	}

	public int total(treenode ptr) {
		if (ptr == null) {
			return 0;
		}
		return total(ptr.left) + total(ptr.right) + 1;
	}

	// Max Element in the tree
	public int maximum(treenode ptr) {
		if (ptr == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(ptr.data, Math.max(maximum(ptr.left), maximum(ptr.right)));
	}

	// Min element in the tree.
	public int minimum(treenode ptr) {
		if (ptr == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(ptr.data, Math.min(minimum(ptr.left), minimum(ptr.right)));
	}

	// left view code
	public void priv(treenode ptr, List<Integer> a, int level) {
		if (ptr == null) {
			return;
		}
		if (a.size() == level) {
			a.add(level, ptr.data);
		}
		priv(ptr.left, a, level + 1);
		priv(ptr.right, a, level + 1);
	}

	public void le(treenode ptr) {
		List<Integer> a = new ArrayList<>();
		priv(ptr, a, 0);
		for (int cu : a) {
			System.out.print(cu + " ");
		}
	}

	// right view of a tree
	public void privalue(treenode ptr, List<Integer> a, int level) {
		if (ptr == null) {
			return;
		}
		if (a.size() <= level) {
			a.add(ptr.data);
		} else {
			a.set(level, ptr.data);
		}
		privalue(ptr.left, a, level + 1);
		privalue(ptr.right, a, level + 1);
	}

	public void ri(treenode ptr) {
		List<Integer> a = new ArrayList<>();
		privalue(ptr, a, 0);
		for (int cu : a) {
			System.out.print(cu + " ");
		}
	}

	// top view of a tree
	class Pair {
		int horizontal_distance;
		treenode node;

		public Pair(int hd, treenode a) {
			this.horizontal_distance = hd;
			this.node = a;
		}
	}

	public void top(treenode ptr) {
		Queue<Pair> q = new ArrayDeque<>();
		Map<Integer, Integer> m = new TreeMap<>();
		q.add(new Pair(0, ptr));
		while (!q.isEmpty()) {
			Pair cu = q.poll();
			// System.out.println("cu.hd value::"+cu.horizontal_distance);
			if (!m.containsKey(cu.horizontal_distance)) {
				m.put(cu.horizontal_distance, cu.node.data);
			}
			if (cu.node.left != null) {
				q.add(new Pair(cu.horizontal_distance - 1, cu.node.left));
			}
			if (cu.node.right != null) {
				q.add(new Pair(cu.horizontal_distance + 1, cu.node.right));
			}
		}
		ArrayList<Integer> a = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
			a.add(entry.getValue());
		}
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
	}

	public void bottom(treenode ptr) {
		Queue<Pair> q = new ArrayDeque<>();
		Map<Integer, Integer> m = new TreeMap<>();
		q.add(new Pair(0, ptr));
		while (!q.isEmpty()) {
			Pair cu = q.poll();
			m.put(cu.horizontal_distance, cu.node.data);
			if (cu.node.left != null) {
				q.add(new Pair(cu.horizontal_distance - 1, cu.node.left));
			}
			if (cu.node.right != null) {
				q.add(new Pair(cu.horizontal_distance + 1, cu.node.right));
			}

		}
		ArrayList<Integer> arr = new ArrayList<>();
		for (Map.Entry<Integer, Integer> ct : m.entrySet()) {
			arr.add(ct.getValue());
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		special2 ob = new special2();
		treenode ptr = ob.make(sc);
		System.out.println("The level order traversal of the tree is");
		ob.level(ptr);
		System.out.println("\nHeight of the tree is:" + ob.ht(ptr));
		System.out.println("\nTotal number of node in the tree is:" + ob.total(ptr));
		System.out.println("\nMax element in the tree is:" + ob.maximum(ptr));
		System.out.println("\nMin element in the tree is:" + ob.minimum(ptr));
		System.out.println("\nLeft view of the tree is as follows");
		ob.le(ptr);
		System.out.println("\nRight view of the tree is as follows");
		ob.ri(ptr);
		System.out.println("\nTop view of the tree is as follows");
		ob.top(ptr);
		System.out.println("\nBottom view of a tree is as follows");
		ob.bottom(ptr);

	}
}
