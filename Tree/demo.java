package Tree;
import java.util.*;
public class demo {
	class node{
		int data;
		node left;
		node right;
		node (int val){
			this.data=val;
			this.left=null;
			this.right=null;
		}
	}
	
	public node cre(Scanner sc) {
		int a;
		node root=null;
		System.out.println("enter the data in the field");
		a=sc.nextInt();
		if(a==-1) {
			return null;
		}
		root=new node(a);
		System.out.println("enter the left child of--"+a);
		root.left=cre(sc);
		System.out.println("enter the right child of--"+a);
		root.right=cre(sc);
		return root;
	}
	
	public void inorder(node ptr) {
		if(ptr==null) {
			return ;
		}
		inorder(ptr.left);
		System.out.print(ptr.data+" ");
		inorder(ptr.right);
	}
   
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	demo ob=new demo();
	node ptr=ob.cre(sc);
	System.out.println("the inorder traversal of the tree is as follows");
	ob.inorder(ptr);
	sc.close();
}
}
