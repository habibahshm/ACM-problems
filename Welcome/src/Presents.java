import java.io.*;
import java.util.*;
	
public class Presents {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(bf.readLine());
	 Integer[]p = new Integer[n];
	 StringTokenizer st = new StringTokenizer(bf.readLine());
	 TreeMap tm = new TreeMap<Integer,Integer>();
	 for(int i=0; st.hasMoreTokens(); i++){
		 p[i]=Integer.parseInt(st.nextToken());
		 tm.put(p[i],(i+1));
	 }
     Arrays.sort(p);
	 for(int i=0; i<p.length; i++){
		 System.out.print(tm.get(p[i]));
		 if(i<p.length-1)
			 System.out.print(" ");
	 }
	 System.out.println();
 }
}
