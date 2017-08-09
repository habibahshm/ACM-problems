import java.io.*;
import java.util.*;

public class MoviePolice {
	public static int hammingDist(String m, String c){
		int len = c.length();
		int dist=0;
		int global_dist=Integer.MAX_VALUE;
		for(int i=0; i<m.length()-len+1; i++){
			for(int j=i; j<i+len; j++){
				if(m.charAt(j)!=c.charAt(j-i))
						dist++;
			}
			global_dist=Math.min(global_dist, dist);
			dist=0;
		}
		return global_dist;
	}
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  String n= bf.readLine();
	  StringTokenizer st= new StringTokenizer(n);
	  int m = Integer.parseInt(st.nextToken());
	  int c = Integer.parseInt(st.nextToken());
	  String[]movies=new String[m];
	  String[]clips= new String[c];
	  for(int i=0; i<m; i++){
		  movies[i]=bf.readLine();
	  }
	  for(int i=0; i<c; i++){
		  clips[i]=bf.readLine();
	  }
	
	  int dist =0;
	  int j;
	 
	  for(int i=0; i<c; i++){
		  int idx=-1;
		  int min_dist=Integer.MAX_VALUE;
		   for(j=0; j<m; j++){
			  if(movies[j].length()<clips[i].length())
				  continue;
			  dist = hammingDist(movies[j],clips[i]);
			  if(dist<min_dist){
				  min_dist=dist;
				  idx=j+1;
			  }
		  }
		  System.out.println(idx);
	  }
	  
  }
}
