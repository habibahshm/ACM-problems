import java.io.*;
public class Hajj {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String in = bf.readLine();
	 for(int i=1; !(in.equals("*")); i++){
		 if(in.equals("Hajj"))
			 System.out.println("Case "+ i + ": Hajj-e-Akbar");
		 else
			 System.out.println("Case "+ i + ": Hajj-e-Asghar");
		 in = bf.readLine();
	 }
		 
	 
 }
}
