package Array;

public class one {

	public static void main(String[] args) {
       System.out.println("hello world");
       int []arr= {1,2,3,4,56,4};
       for (int i = 0; i < arr.length; i++) {
		System.out.print(arr[i]+" ");
	}
       
       
       System.out.println();
       int[] ptr = new int[4];  //dynamic allocation of array in the field
       //ptr[0]=45;
       for (int i = 0; i < ptr.length; i++) {
		System.out.print(ptr[i]+" ");
	}
       System.out.println();
      int []ctr;
      ctr=new int[8];
      for (int i = 0; i < ctr.length; i++) {
		System.out.print(ctr[i]+" ");
	}
       
	}

}
