import java.io.*;



public class Bit {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String s = bf.readLine();
	 int n = Integer.parseInt(s);
	 String line;
	 int x=0;
	 for(int i=1; i<=n; i++){
		 line = bf.readLine();
		 if(line.charAt(1)=='+')
			 x++;
		 else
			 x--;
	 }
	 System.out.println(x);
	 
 }
}
