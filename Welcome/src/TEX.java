import java.io.*;
import java.util.*;
class TEX {
 public static void main(String[]args)throws IOException{
	 Scanner x = new Scanner(System.in);
	 int count =1;
	 String input;
	while(x.hasNextLine()){
	 input = x.nextLine();
	 for(int i=0; i<input.length(); i++){
		 if(input.charAt(i)=='\u001a')
			 break;
		 
		 if(input.charAt(i)=='"' && count%2!=0){
			 System.out.print("``");
			 count++;}
		 else
			 if(input.charAt(i)=='"' && count%2==0){
				 System.out.print("''");
				 count++;}
			 else
				 System.out.print(input.charAt(i));
	  }
	 System.out.println();
	}
  }
}
 

