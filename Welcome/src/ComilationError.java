import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ComilationError {
 public static void main(String[]args)throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int len = Integer.parseInt(bf.readLine());
	 int[]errors=new int[len];
	 int[]errors1=new int[len-1];
	 int[]errors2= new int[len-2];
	 StringTokenizer st = new StringTokenizer(bf.readLine());
	 for(int i=0; i<len; i++)
		 errors[i]=Integer.parseInt(st.nextToken());
	 
	 st = new StringTokenizer(bf.readLine());
	 for(int i=0; i<len-1; i++)
		 errors1[i]=Integer.parseInt(st.nextToken());
	 
	 st = new StringTokenizer(bf.readLine());
	 for(int i=0; i<len-2; i++)
		 errors2[i]=Integer.parseInt(st.nextToken());
	 Arrays.sort(errors);
	 Arrays.sort(errors1);
	 Arrays.sort(errors2);
	 for(int i=0; i<len; i++){
		if(i<len-1){
		 if(errors[i]!=errors1[i]){
			 System.out.println(errors[i]);
			 break;
		 }
		}else
			System.out.println(errors[i]);
	  }
	 for(int i=0; i<len-1; i++){
		if(i<len-2){
		 if(errors1[i]!=errors2[i]){
			 System.out.println(errors1[i]);
			 break;
		 }
		}else
			System.out.println(errors1[i]);
			 
	 }
 }
}
