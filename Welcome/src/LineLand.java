import java.io.*;
import java.util.*;

public class LineLand {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(bf.readLine());
	 int[]lands=new int[n];
	 String l = bf.readLine();
	 StringTokenizer st = new StringTokenizer(l);
	 for(int i=0; i<n; i++)
		 lands[i]=Integer.parseInt(st.nextToken());
	 System.out.println((lands[1]-lands[0])+" "+(lands[n-1]-lands[0]));
	 int min_diff;
	 int max_diff;
	 for(int i=1; i<n-1; i++){
		 if((lands[i]-lands[i-1])<(lands[i+1]-lands[i]))
			 min_diff=lands[i]-lands[i-1];
		 else
			 min_diff=lands[i+1]-lands[i];
		 
		 if((lands[n-1]-lands[i])>(lands[i]-lands[0]))
			 max_diff=lands[n-1]-lands[i];
		 else
			 max_diff=lands[i]-lands[0];
		 System.out.println(min_diff+" "+max_diff);
	 }
	 System.out.println((lands[n-1]-lands[n-2])+" "+(lands[n-1]-lands[0]));
		 
	 }
 }

