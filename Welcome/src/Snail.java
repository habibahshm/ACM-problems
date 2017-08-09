import java.io.*;
public class Snail {
   public static void main(String[]args)throws IOException{
	   BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	   do{
	   String in = bf.readLine();
	   String[]s=in.split("\\s");
	   int h = Integer.parseInt(s[0])*100;
	    if(h==0)
	    	break;
	   int d =  Integer.parseInt(s[1]);
	   int n =  Integer.parseInt(s[2])*100;
	   int f =  d*(Integer.parseInt(s[3]));
	   d*=100;
	   int climbed =0;
	   int day=1;
	   while(true){
		   if(day>1)
		   d-=f;
		   if(d>0)
		   climbed+=d;
		   if(climbed>h)
			   break;
		   else
			   climbed-=n;
		 
		   if(climbed<0)
			   break;
		   day++;
	   }
	   if(climbed >0)
		   System.out.println("success on day "+day);
	   else
		   System.out.println("failure on day "+day);
	   
	   }while(true);   
   }
}
