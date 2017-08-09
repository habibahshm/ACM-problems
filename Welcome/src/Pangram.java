import java.io.*;
import java.util.*;

public class Pangram {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(bf.readLine());
		String input = bf.readLine();
		boolean[]present = new boolean[26];
		for(int i=0; i<l; i++){
			int curr = input.charAt(i);
			if(curr>90)
				curr-=32;
			present[curr%65]=true;
		}
		boolean pangram=true;
		for(int i=0; i<26; i++)
			if(!present[i]){
				pangram=false;
				break;
			}
		if(pangram)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
