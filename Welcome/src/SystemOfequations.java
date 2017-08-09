import java.io.*;
import java.util.*;

public class SystemOfequations {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count=0;
		for(int b=0; b<=n; b++){
			for(int a=0; a<=m; a++){
				if((a*a)+b==n && a+(b*b)==m)
					count++;
			}
		}
		System.out.println(count);
 	}
}
