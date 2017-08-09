import java.io.*;
public class MCLB {
	
	public static String change(String s){
		if(s.charAt(s.length()-1)==82)
			return change(s.substring(0, s.length()-1))+"B";
		else{
			return s.substring(0,s.length()-1)+"R"; 
		 }
		}
	
 public static void main(String[]args)throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String s = bf.readLine();
	int n = Integer.parseInt(s);
	int count=0;
	 for(int i=1; i<=n; i++){
		 String in = bf.readLine();
		 String req = bf.readLine();
		 String in1=in;
		 while(!(in.equals(req))){
			 in =change(in);
			 count++;
			 if(in.equals(in1)){
				 System.out.println("Case "+i+": the goal state will never be reached");
				 break;
			 }
		  }
		 if(in.equals(req))
			 System.out.println("Case "+i+": the goal state could be reached after"+count+" laser beams");
		 count=0; 
		
	 }
  } 
 }

