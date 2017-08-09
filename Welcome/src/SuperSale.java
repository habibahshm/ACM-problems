import java.io.*;
import java.util.*;

public class SuperSale {
	static int[] P;
	static int[] W;
	static int n;
	static int[] MW;
	static int[][] dp;

	public static int state(int idx, int remW) {
		if (idx == n || remW == 0)
			return 0;
		if (dp[idx][remW] != -1)
			return dp[idx][remW];
		if (W[idx] > remW)
			return dp[idx][remW] = state(idx + 1, remW);
		return dp[idx][remW] = Math.max(state(idx + 1, remW - W[idx]) + P[idx],
				state(idx + 1, remW));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(bf.readLine());
			P = new int[n];
			W = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				P[i] = Integer.parseInt(st.nextToken());
				W[i] = Integer.parseInt(st.nextToken());
			}
			int g = Integer.parseInt(bf.readLine());
			MW = new int[g];
			int ans = 0;
			for (int i = 0; i < g; i++) {
				MW[i] = Integer.parseInt(bf.readLine());
				dp = new int[n][MW[i]+1];
				for (int j = 0; j < n; j++)
					Arrays.fill(dp[j], -1);
				ans += state(0, MW[i]);
			}
			System.out.println(ans);
		}
	}
}
