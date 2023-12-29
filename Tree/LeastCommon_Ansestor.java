package Tree;

import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;

public class LeastCommon_Ansestor {
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

	public static void main(String[] args) {
		LeastCommon_Ansestor ob = new LeastCommon_Ansestor();
		Scanner sc = new Scanner(System.in);
		node root = ob.make(sc);
		int a,b;
		
	}
}
