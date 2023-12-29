  package Tree;

import java.util.*;

public class top_viewof_Tree {
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

	// making treemethod
	public treenode make(Scanner sc) {
		int a;
		treenode root = null;
		System.out.println("enter the value in the field");
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		root = new treenode(a);
		System.out.println("enter the left child of->" + a);
		root.left = make(sc);
		System.out.println("enter the right child of->" + a);
		root.right = make(sc);
		return root;
	}

	// printing tree using queue level
	public void level(treenode ptr) {
		Queue<treenode> q = new LinkedList<>();
		q.add(ptr);
		q.add(null);
		while (!q.isEmpty()) {
			treenode cu = q.poll();
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

	public void topView(treenode root) {
		if (root == null) {
			return;
		}

		class QueueNode {
			treenode key;
			int horizontalDistance;

			public QueueNode(treenode node, int horizontalDistance) {
				this.key = node;
				this.horizontalDistance = horizontalDistance;
			}
		} 
		Map<Integer, Integer> topViewMap = new TreeMap<>();
		Queue<QueueNode> queue = new LinkedList<>();
		queue.offer(new QueueNode(root, 0));

		while (!queue.isEmpty()) {
			QueueNode qNode = queue.poll();
			treenode arr = qNode.key;
			int horizontalDistance = qNode.horizontalDistance;

			if (!topViewMap.containsKey(horizontalDistance)) {
				topViewMap.put(horizontalDistance, arr.data);
			}

			if (arr.left != null) {
				queue.offer(new QueueNode(arr.left, horizontalDistance - 1));
			}
			if (arr.right != null) {
				queue.offer(new QueueNode(arr.right, horizontalDistance + 1));
			}
		}
		for (int val : topViewMap.values()) {
			System.out.print(val + " ");
		}
	}

	// 7 6 5 -1 -1 1 4 -1 -1 -1 2 8 -1 -1 3 -1 -1
	// 6 2 -1 3 -1 4 -1 -1 1 -1 5 -1 -1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		top_viewof_Tree ob = new top_viewof_Tree();
		treenode ptr = ob.make(sc);
		System.out.println("level order traversal of the tree is as follows");
		ob.level(ptr);
		System.out.println("\ntop view of the tree is");
		ob.topView(ptr);

	}
}
