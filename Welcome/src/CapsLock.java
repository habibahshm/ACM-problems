import java.io.*;

public class CapsLock {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String s = bf.readLine();
	 boolean flag = true;
	 int i;
	 for(i=1; i<s.length() && flag ==true; i++){
		if( s.charAt(i)>=97 && s.charAt(i)<=122)
			flag=false;
	  }
	 if(flag==true && s.charAt(0)>=97 && s.charAt(0)<=122)
		 System.out.println(s.toUpperCase().charAt(0)+s.toLowerCase().substring(1, s.length()));
	 else
		 if(s.equals(s.toUpperCase()))
			 System.out.println(s.toLowerCase());
		 else
		     System.out.println(s);
 }
}
