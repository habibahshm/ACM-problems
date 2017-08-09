import java.io.*;
public class One_Two_Three {
	public static boolean closeEnough(String s){
		String t = "two";
		int count =0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)!=t.charAt(i))
				count++;
		}
		if(count>1)
			return false;
		else
			return true;
	}
  public static void main(String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
	  String s=bf.readLine();
	  int n = Integer.parseInt(s);
	  String in;
	  for(int i=1; i<=n; i++){
		  in = bf.readLine();
		  if(in.length()==5)
			  System.out.println(3);
		  else{
			  if(closeEnough(in))
				  System.out.println(2);
			  else
				  System.out.println(1);
		  }
	  }
  }
}
