
import java.io.*;
public class WordCaptalization {
   public static void main(String[]args)throws IOException{
	   BufferedReader bf = new BufferedReader (new InputStreamReader (System.in));
	   String s = bf.readLine();
	  if(s.charAt(0)>=97 && s.charAt(0)<=122)
		  System.out.println( s.toUpperCase().charAt(0) + s.substring(1, s.length()));
	  else 
		  System.out.println(s);
		  
   }
}
