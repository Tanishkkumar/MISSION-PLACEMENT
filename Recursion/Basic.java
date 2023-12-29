package Recursion;

public class Basic {
	public static void fun(int a,int b) {
		if(a>b-1) {
			return ;
		}
		fun(++a,b);
		System.out.println(a);
	}
	public static void main(String[] args) {
         fun(0,5);
	}
}
