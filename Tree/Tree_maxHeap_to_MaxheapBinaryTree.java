package Tree;
              //****************************important point -->inorder array mai karna compulsory hai...
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class maxheap {
	public int[] arr;
	public int size;

	maxheap(int v) {
		arr = new int[v + 1];
		arr[0] = -1;
		size = 0;
	}

	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public void insert(int val) {
		size = size + 1;
		System.out.println("size is::"+size);
		int index = size;
		arr[index] = val;
		while (index > 1) {
			int parent = index / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
			}
			index = parent;
		}
	}

	// 4 5 7 -1 -1 8 -1 -1 10 -1 1 -1 -1
	public void print(ArrayList<Integer> ptr) {
		ptr.clear();
		System.out.println("\nMax heap is as follows");
		for (int i = 0; i <= size; i++) {
			System.out.print(arr[i] + " ");
			ptr.add(arr[i]);
		}
	}

}

public class Tree_maxHeap_to_MaxheapBinaryTree {
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

	public int counter = 0;

	public node make(Scanner sc) {
		int a;
		node ptr = null;
		if (counter != -1) {
			System.out.println("enter the main root value in  the field");
			counter = -1;
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

	public void enter(node ptr, ArrayList<Integer> arr) {
		if (ptr == null) {
			return;
		}
		enter(ptr.left, arr);
		arr.add(ptr.data);
		enter(ptr.right, arr);
	}

	public node maxtree(ArrayList<Integer> ctr, int index) {
		if (index < ctr.size()) {
			node cu = new node(ctr.get(index));
			cu.left = maxtree(ctr, 2 * index);
			cu.right = maxtree(ctr, 2 * index + 1);
			return cu;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tree_maxHeap_to_MaxheapBinaryTree ob = new Tree_maxHeap_to_MaxheapBinaryTree();

		node ptr = ob.make(sc);
		System.out.println("level oreder traversal of the tree is sa follows");
		ob.level(ptr);
		ArrayList<Integer> arr = new ArrayList<>();
		ob.enter(ptr, arr);
		System.out.println("\nThe list is as follows");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		maxheap pt = new maxheap(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			pt.insert(arr.get(i));
		}
		pt.print(arr);
		System.out.println("\nThe Updated  list is as follows");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		node temp = ob.maxtree(arr, 1);
		System.out.println("\nThe new level order traversal of the tree is sa follows");
		ob.level(temp);
		sc.close();

	}
}
