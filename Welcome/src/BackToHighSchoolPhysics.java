import java.io.*;
import java.util.*;

public class BackToHighSchoolPhysics {
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  while(bf.ready()){
		  st=new StringTokenizer(bf.readLine());
		  int v = Integer.parseInt(st.nextToken());
		  int t = Integer.parseInt(st.nextToken());
		  System.out.println(v*t*2);
	  }
  }
}
