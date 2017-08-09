import java.io.*;
import java.math.BigInteger;

public class Julka {
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
	  for(int i=1; i<=10; i++){
	  String s = bf.readLine();
	  String t = bf.readLine();
	  BigInteger total = new BigInteger(s);
	  BigInteger moreApples = new BigInteger(t);
	  BigInteger natila= total.subtract(moreApples).divide(new BigInteger("2"));
	  BigInteger klaudia = total.subtract(natila);
	  System.out.println(klaudia);
	  System.out.println(natila);
	  }
  }
}
