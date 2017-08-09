import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Pasha {
	public static char[] reverse(char[] c, int a){
		int i=a-1;
		int j=c.length-a;
		char temp =c[i];
		c[i]=c[j];
		c[j]=temp;
		return c;
	}
	
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String p = bf.readLine();
	 char[]p1=p.toCharArray();
	 boolean[]rev=new boolean[(p.length()/2)+1];
	 bf.readLine();
	 StringTokenizer st = new StringTokenizer(bf.readLine());
	 while(st.hasMoreTokens()){
		 int i=Integer.parseInt(st.nextToken());
		 rev[i]=!rev[i];
	 }
	 boolean reverse=false;
	 for(int i=0; i<rev.length; i++){
		 if(rev[i])
			 reverse=!reverse;
		 if(reverse)
			p1= reverse(p1,i);
		 
	 }
	 System.out.println(p1);
 }
}
