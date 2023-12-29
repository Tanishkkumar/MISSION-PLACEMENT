package Collections;

public class Hashing {
	public static void main(String[] args) {
		//int[] arr = { 1, 2, 3, 4, 5, 2, 2, 2 };
		char []arr= {'a','b','a','c','c'};
		int[] hash = new int[26];
		// hash[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			hash[arr[i]-'a']+=1;
		}
		for(int i=0;i<hash.length;i++) {
			System.out.println((char)(i+97)+"::"+hash[i]);
		}
		//int []ctr=new int[100000000];

	}
}
