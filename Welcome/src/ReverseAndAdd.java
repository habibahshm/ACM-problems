import java.util.*;
import java.io.*;

public class ReverseAndAdd {
	public static long reverse(long a){
		String output = "";
		while(a!=0){
			output +=a%10;
			a/=10;
		}
		return Long.parseLong(output);
	}
	public static boolean isPalindorme(String x){
		for(int i=0; i<x.length()/2; i++){
			if(x.charAt(i)!=x.charAt(x.length()-1-i))
				return false;
		}
		return true;
	}
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  int n = Integer.parseInt(bf.readLine());
	  while(n-->0){
		  long a = Long.parseLong(bf.readLine());
		  long b = reverse(a);
		  long total = a+b;
		  int count =1;
		  while(!isPalindorme(total+"")){
			  a=total;
			  b=reverse(a);
			  total=a+b;
			  count++;
		  }
		  System.out.println(count+" "+total);
	  }
  }
}
