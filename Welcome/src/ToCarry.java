import java.io.*;
import java.util.*;

public class ToCarry {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st;
	 while(bf.ready()){
		 st = new StringTokenizer(bf.readLine());
		 int a = Integer.parseInt(st.nextToken());
		 int b = Integer.parseInt(st.nextToken());
		 System.out.println(a^b);
	 }
 }
}
