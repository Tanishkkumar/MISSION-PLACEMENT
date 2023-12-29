package Stack;    //need to change.

public class Infix_to_Postfix_Conversion_using_Stack {
    class node{
    	char data;
    	node next;
    	node(char val){
    		this.data=val;
    		this.next=null;
    	}
    }
    node top=null;
    int pri(char a) {
    	if(a=='*' || a=='/') {
    		return 3;
    	}
    	else if(a=='+' || a=='-') {
    		return 2;
    	}
    	return 0;
    }
   public  int checkop(char c) {
    	if(c=='+'|| c=='-'|| c=='*'|| c=='/' ) {
    		return 1;
    	}
    	return 0;
    }
    
    public void fun(String arr) {
    	 char[]ptr=new char[arr.length()];
    	 int ar=0;
    	 for(int i=0;i<arr.length();i++) {
    		 if(checkop(arr.charAt(i))!=1) {
    			 ptr[ar++]=arr.charAt(i);
    		 }
    		 else  {
    			 char t;
    			 if(top==null) {
    				 t='p';
    			 }
    			 else {
    				 t=top.data;
    			 }
    			 if(pri(arr.charAt(i)) > pri(t)) {
    				 node ctr=new node(arr.charAt(i));
        			 ctr.next=top;
        			 top=ctr;
    			 }
    			 else {
    				 while(top!=null) {
    				 ptr[ar++]=top.data;
    				 top=top.next;
    				 }
    				 node lp=new node(arr.charAt(i));
    				 lp.next=top;
    				 top=lp;
    			 }
    			 
    		 }
    	 }
    	 
    	 while(top!=null) {
    		 ptr[ar++]=top.data;
			 top=top.next;
    	 } 
    	 
    	 System.out.println("the post fix erpression is::");
    	 for(int i=0;i<ptr.length;i++) {
    		 System.out.print(ptr[i]+" ");
    	 }
    	 System.out.println("size of array is -->"+ptr.length);
    }
	public static void main(String[] args) {
		Infix_to_Postfix_Conversion_using_Stack ob= new Infix_to_Postfix_Conversion_using_Stack();
       String arr="K+L-M*N+O+P*W/U/V*T+Q";
       ob.fun(arr);
       
       
	}

}
