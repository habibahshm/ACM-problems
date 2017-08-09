import java.io.*; 
import java.util.*;


public class Welcome {
  public static void main (String[]args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
	  int i;
      int[] sequence;
      do{
	   
	   String s = bf.readLine(); 
	   StringTokenizer st = new StringTokenizer(s);
	   sequence = new int[st.countTokens()];
	   
	   for(i=0; st.hasMoreTokens() ; i++){
		   sequence[i] = Integer.parseInt(st.nextToken());
		   } 
	   
	   if (sequence[0]==0 && sequence[1] ==0 && sequence[2]==0)
		   break;
	  
	   
	   int next;
	   if((sequence[2]-sequence[1])==(sequence[1]-sequence[0])){
	    	  next = ( sequence[1]-sequence[0])+sequence[2];
		         System.out.println("AP "+ next);
	   }else{
	         if(sequence[1]!=0 && sequence[0]!=0)
	          if((sequence[2]/sequence[1])==(sequence[1]/sequence[0])){
    		   next = sequence[2]*(sequence[1]/sequence[0]);
    		   System.out.println("GP "+ next );
    	    }
	   }	      
   
  
    } while(true);
	  }
	  
  }

