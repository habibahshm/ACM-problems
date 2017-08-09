import java.io.*;
import java.util.*;

public class Team {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		int count = 0;
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			String binary="";
			while(st.hasMoreTokens())
				binary+=st.nextToken();
			int b = Integer.parseInt(binary, 2);
			if (b == 3 || b > 4)
				count++;
		}
		System.out.println(count);
	}
}
