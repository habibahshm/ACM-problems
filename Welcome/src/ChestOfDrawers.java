import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChestOfDrawers {
	static int s;
	static long[][][] dp;

	public static long state(int idx, int securedSoFar, boolean topSecured) {
		if (securedSoFar > s)
			return 0;
		if (idx == -1)
			return securedSoFar == s ? 1 : 0;
		long lock;
		if (topSecured) {
			if (dp[idx][securedSoFar][1] != -1)
				return dp[idx][securedSoFar][1];
			lock = state(idx - 1, securedSoFar + 1, true);
		} else {
			if (dp[idx][securedSoFar][0] != -1)
				return dp[idx][securedSoFar][0];
			lock = state(idx - 1, securedSoFar, true);
		}
		long unlock = state(idx - 1, securedSoFar, false);
		if (topSecured)
			return dp[idx][securedSoFar][1] = lock + unlock;
		else
			return dp[idx][securedSoFar][0] = lock + unlock;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if (n < 0 && s < 0)
				break;
			dp = new long[n][s + 1][2];
			for (int i = 0; i < n; i++)
				for (int j = 0; j <= s; j++)
					Arrays.fill(dp[i][j], -1);
			long ways = state(n - 1, 0, true);
			System.out.println(ways);
		}
	}
}
