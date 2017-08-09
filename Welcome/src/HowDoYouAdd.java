import java.io.*;
import java.util.*;

public class HowDoYouAdd {
	static int[][] dp;

	public static int ways_no(int n, int k) {
		if (n ==0 || k == 1)
			return 1;
		if (dp[n][k] != -1)
			return dp[n][k];
		int ways = 0;
		for (int i = 0; i <= n; i++) {
			ways += ways_no(n - i, k - 1)%1000000;
			ways %= 1000000;
		}
		return dp[n][k] = ways;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String o;
		while (!(o = bf.readLine()).equals("0 0")) {
			int count = 0;
			st = new StringTokenizer(o);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			dp = new int[n + 1][k + 1];
			for (int i = 0; i < n + 1; i++)
				Arrays.fill(dp[i], -1);
			count = ways_no(n, k);
			System.out.println(count);
		}
	}
}
