import java.util.*;

public class EcologicalBinPacking {
	public static char[] nextPerm(char[]arr){
		int len = arr.length;
		int prev = arr[len-1];
		int i;
		for(i=len-2; i>=0; i--){
			if(arr[i]<prev)
				break;
			prev=arr[i];
		}
		for(int j=len-1; j>i && i>=0; j--){
			if(arr[j]>arr[i]){
			    char temp = arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				break;
			}
		}
		int s=i+1;
		int e=len-1;
		while(s<e){
			char temp=arr[s];
			arr[s]=arr[e];
			arr[e]=temp;
			s++;
			e--;
		}
		return arr;
	}
	public static int[][] convert(String[]s){
		int[][]n=new int[3][3];
		int i=0;
			for(int j=0; j<3; j++){
		     for(int k=0; k<3; k++){
			n[j][k]=Integer.parseInt(s[i]);
			i++;
		     }	
		    }
		   
		return n;
	}
	
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
	   while(s.hasNextLine()){
		String in = s.nextLine();
		String[]bottels = in.split("\\s");
		int[][]b=convert(bottels);
		char[]c={'B','C','G'};
		char[]res={'B','C','G'};
		int min_moves=Integer.MAX_VALUE;
		int moves=0;
		for(int i=1; i<=6; i++){
			for(int j=0; j<c.length; j++){
				if(c[j]=='B')
					moves+=b[j][1]+b[j][2];
				else
					if(c[j]=='G')
						moves+=b[j][0]+b[j][2];
					else
							moves+=b[j][0]+b[j][1];
			}
			if(moves<min_moves){
				min_moves=moves;
				res=(char[])c.clone();
			}
			moves=0;
			if(i<6)
			c=nextPerm(c);
		}
		for(int i=0; i<res.length; i++)
			System.out.print(res[i]);
		System.out.print(" "+min_moves);
		System.out.println();
	}
  }
}
		
		
	


