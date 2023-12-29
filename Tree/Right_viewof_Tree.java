package Tree;

import java.util.*;
import java.util.Queue;
import java.util.ArrayList;

public class Right_viewof_Tree {
	class node {
		int data;
		node left;
		node right;

		node(int val) {
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}

	public node make(Scanner sc) {
		int a;
		node root = null;
		System.out.println("enter the value in the field");
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		root = new node(a);
		System.out.println("enter the left child of->" + a);
		root.left = make(sc);
		System.out.println("enter the right child of->" + a);
		root.right = make(sc);
		return root;
	}

	public void inorder(node ptr) {
		if (ptr == null) {
			return;
		}
		inorder(ptr.left);
		System.out.print(ptr.data + " ");
		inorder(ptr.right);
	}

	public int height(node ptr) {
		if (ptr == null) {
			return 0;
		}
		return Math.max(height(ptr.left), height(ptr.right)) + 1;
	}

	public int total(node ptr) {
		if (ptr == null) {
			return 0;
		}
		return total(ptr.left) + total(ptr.right) + 1;
	}

	public int max(node ptr) {
		if (ptr == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(ptr.data, Math.max(max(ptr.left), max(ptr.right)));
	}

	public int min_val(node ptr) {
		if (ptr == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(ptr.data, Math.min(min_val(ptr.left), min_val(ptr.right)));
	}

	public void level(node ptr) {
		Queue<node> q = new LinkedList<>();
		q.add(ptr);
		q.add(null);
		while (!q.isEmpty()) {
			node cu = q.poll();
			// System.out.println("adasd->" + cu);
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

	// Left view code
	public void look(node ptr, ArrayList<node> a, int level) {
		if (ptr == null) {
			return;
		}
//		System.out.println("\n\nsize of the list is->" + a.size()); // === 1
		if (a.size() == level) {
			a.add(ptr);
		}
		look(ptr.left, a, level + 1);
		look(ptr.right, a, level + 1);
	}

	public void leftview(node ptr) {
		ArrayList<node> c = new ArrayList<>();
		look(ptr, c, 0);
		for (node ct : c) {
			System.out.print(ct.data + " ");
		}
	}

	// Right view code
	public void look2(node ptr, ArrayList<node> a, int level) {
		if (ptr == null) {
			return;
		}
		if (a.size() <= level) {
			a.add(ptr);
		} else {
			a.set(level, ptr);
		}
		look2(ptr.left, a, level + 1);
		look2(ptr.right, a, level + 1);
	}

	public void rightview(node ptr) {
		ArrayList<node> c = new ArrayList<>();
		// c.add(null);
		look2(ptr, c, 0);
		for (node ct : c) {
			System.out.print(ct.data + " ");
		}
	}

	/////// Input--> 4 5 7 -1 -1 8 -1 -1 10 -1 1 -1 -1

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Right_viewof_Tree ob = new Right_viewof_Tree();
		node ptr = ob.make(sc);
		System.out.println("\nthe inorder traversal of the tree isw as follows");
		ob.inorder(ptr);
		System.out.println("\nthe height of the tree is-->" + ob.height(ptr));
		System.out.println("\ntotal number of nodes in  the tree is-->" + ob.total(ptr));
		System.out.println("\nMaximum value node in  the tree is-->" + ob.max(ptr));
		System.out.println("\nMinimum value node in  the tree is-->" + ob.min_val(ptr));
		System.out.println("\nLevel order traversal of the tree is-->");
		ob.level(ptr);
		System.out.println("\nLeft view of the tree is-->");
		ob.leftview(ptr);
		System.out.println("\nRight view of the tree is-->");
		ob.rightview(ptr);
		

	}
}
