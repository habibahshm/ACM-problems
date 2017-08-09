import java.io.*;
public class SumOfDigits {
	public static int sumofdigits(int x){
		int digit;
		int sum=0;
		while(x!=0){
			digit=x%10;
			sum+=digit;
			x/=10;
		}
		return sum;
	}
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	   String s = bf.readLine();
	   int n =Integer.parseInt(s);
	   int y = sumofdigits(n);
	  
	  while(n !=0 ){
	      while(y>=10){
	       y =sumofdigits(y);
	       }
	      System.out.println(y);
	     s = bf.readLine();
	     n =Integer.parseInt(s);
	     y=sumofdigits(n);
	  }
    
  }
           
 }

