import java.io.*;

public class WhoseSentence{
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String t = bf.readLine();
	 int n = Integer.parseInt(t);
	 String r;
	 String f;
	 for(int i=1; i<=n; i++){
		String s = bf.readLine();
		if(s.length()<5){
			 System.out.println("OMG>.< I don't know!");
			continue;
		}
		
		
		 r=s.substring(0,5);
		 f=s.substring(s.length()-5);
		 if(r.equals("miao.") && f.equals("lala."))
			 System.out.println("OMG>.< I don't know!");
		 else{
		    if(r.equals("miao."))
			 System.out.println("Rainbow's");
		   else
			  if(f.equals("lala."))
				 System.out.println("Freda's");
			  else
				 System.out.println("OMG>.< I don't know!");
		 }
		 
		 
	 }
	
  }
	
}

