package Tree;
//****************************important point -->inorder array mai karna compulsory hai...

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Tree_minHeap_to_MinheapBinaryTree {
	class node {
		int data;
		node left;
		node right;

		node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	public int counter = 0;

	public node make(Scanner sc) {
		int a;
		node ptr = null;
		if (counter != -1) {
			System.out.println("Enter the main root value in the field");
			counter = -1;
		}
		a = sc.nextInt();
		if (a == -1) {
			return null;
		}
		ptr = new node(a);
		System.out.println("Enter the left child of:" + a);
		ptr.left = make(sc);
		System.out.println("Enter the right child of:" + a);
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

	public void pri(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}

	public int size = 0;

	public void min(int val, int[] ptr) {
		size = size + 1;
		int index = size;
		ptr[index] = val;
		while (index > 1) {
			int parent = index / 2;
			if (ptr[parent] > ptr[index]) {
				int temp = ptr[parent];
				ptr[parent] = ptr[index];
				ptr[index] = temp;
			}
			index = parent;
		}
	}

	public node mintree(int[] arr, int level) {
		if (level < arr.length) {
			node cu = new node(arr[level]);
			cu.left = mintree(arr, 2 * level);
			cu.right = mintree(arr, 2 * level + 1);
			return cu;
		}
		return null;
	}

	public void heapify(ArrayList<Integer> arr, int size, int index) {
		int largest = index;
		int left = 2 * index;
		int right = 2 * index + 1;
		if (left <= size && arr.get(largest) < arr.get(left)) {
			largest = left;
		}
		if (right <= size && arr.get(largest) < arr.get(right)) {
			largest = right;
		}
		if (largest != index) {
			Collections.swap(arr, index, largest);
			heapify(arr, size, largest);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		Tree_minHeap_to_MinheapBinaryTree ob = new Tree_minHeap_to_MinheapBinaryTree();
		node ptr = ob.make(sc);
		System.out.println("\nThe Level order traversal of the tree is as follows");
		ob.level(ptr);
		ob.enter(ptr, arr);
		System.out.println("\nThe array list is as follows");
		ob.pri(arr);

		// heapify
		System.out.println("\nThe heapify traversal to max heap is:");
		for (int i = arr.size() / 2 - 1; i >= 0; i--) {
			ob.heapify(arr, arr.size(), i);
		}
		ob.pri(arr);

		int[] ctr = new int[arr.size() + 1];
		ctr[0] = -1;

		for (int i = 0; i < arr.size(); i++) {
			ob.min(arr.get(i), ctr);
		}

		System.out.println("\nThe Min heap array is ");
		for (int i = 1; i <= arr.size(); i++) {
			System.out.print(ctr[i] + " ");
		}
		node knn = ob.mintree(ctr, 1);
		System.out.println("\nThe minheapTree is");
		ob.level(knn);
	}
}
