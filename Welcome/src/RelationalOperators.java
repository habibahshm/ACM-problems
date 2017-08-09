import java.io.*;
import java.util.*;
public class RelationalOperators {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String s = bf.readLine();
	 int n = Integer.parseInt(s);
	 for(int i=1; i<=n; i++){
		 String t = bf.readLine();
		 StringTokenizer st = new StringTokenizer(t);
		 int n1=Integer.parseInt(st.nextToken());
		 int n2=Integer.parseInt(st.nextToken());
		 if((n1-n2)>0)
			 System.out.println(">");
		 else
			 if((n1-n2)<0)
				 System.out.println("<");
			 else
				 System.out.println("=");
		 
	 }
 }
 
}
