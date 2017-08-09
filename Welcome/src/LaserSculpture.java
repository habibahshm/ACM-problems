import java.io.*;
import java.util.*;
public class LaserSculpture {
	public static int[] convert(String[]s){
		int[]z= new int[s.length];
		for(int i=0; i<s.length; i++){
			z[i]=Integer.parseInt(s[i]);
		}
		return z;
	}
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 do{
	  String s = bf.readLine();
	  StringTokenizer st = new StringTokenizer(s);
	  int l = Integer.parseInt(st.nextToken());
	   if(l==0)
		   break;
	  int w = Integer.parseInt(st.nextToken());
	  String t = bf.readLine();
	  String[]z=t.split(" ");
	  int[]h=convert(z);
	  int previous=h[0];
	  int lasers = l-h[0];
	  for(int i=1; i<h.length; i++){
		  if(h[i]<previous)
			  lasers+=(previous-h[i]);
		  previous=h[i];
	  }
	  System.out.println(lasers);
	}while(true);
  }
}
