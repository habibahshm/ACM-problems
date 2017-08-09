import java.io.*;
import java.util.*;

public class Vitosfamily {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int l = Integer.parseInt(st.nextToken());
			int[] streets = new int[l];
			for (int i = 0; st.hasMoreTokens(); i++) {
				streets[i] = Integer.parseInt(st.nextToken());
			}
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < l; i++) {
				int sum = 0;
				int candidate = streets[i];
				for (int j = 0; j < l; j++)
					sum += Math.abs(candidate - streets[j]);
				ans = Math.min(ans, sum);
			}
			System.out.println(ans);
		}
	}
}
