package Array;
import java.util.Map;
import java.util.HashMap;
public class longestSubArrayUsingHASHING {
  public static void main(String[] args) {
	  int []arr= {2,0,0,3};
	  int key=3;
	  Map<Integer,Integer> m=new HashMap<>();
	  int sum=0;
	  int length=0;
	  for(int i=0;i<arr.length;i++) {
		  sum+=arr[i];
		  if(sum==key) {
			  length=Math.max(length, i+1);
		  }
		  if(m.containsKey(sum)==false) {  //ye if block negatice or zeroes agar array mai hai to code ko sahi chalayega
		  m.put(sum,i);
		  }
		  int diff=0;
		  int index=0;
		  if(sum>=key) {
			   diff=sum-key;
			   if(m.containsKey(diff)) {
				    index=i-m.get(diff);
				    if(length<index) {
				    	length=index;
				    }
			   }
		  }
	  }
	  System.out.println("the longest subarray length is::"+length);
}
}
