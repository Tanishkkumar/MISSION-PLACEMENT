package Array;

public class Sort_an_array_of_zero_one_and_two {
	
  public static void main(String[] args) {
	  int[] arr = {1,1,2,2,0,0,0,1};
      int a=0,b=0,c=0;
      for(int i=0;i<arr.length;i++) {
    	  if(arr[i]==0) {
    		  a++;
    	  }
    	  else if(arr[i]==1) {
    		  b++;
    	  }
    	  else {
    		  c++;
    	  }
      }
      int i=0;
      while(a>0) {
    	  arr[i++]=0;
    	  a--;
      }
      while(b>0) {
    	  arr[i++]=1;
    	  b--;
      }
      while(c>0) {
    	  arr[i++]=2;
    	  c--;
      }
      for(int j=0;j<arr.length;j++) {
    	  System.out.print(arr[j]+" ");
      }
      
}
}
