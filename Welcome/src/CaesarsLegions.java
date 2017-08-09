import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CaesarsLegions {
	static int k1, k2;
	static long mod = 100000000;
	static long dp[][][][];

	public static long dp(int succf, int succh, int remf, int remh) {
		long putf = 0;
		long puth = 0;
		if (remf == 0 || remh == 0) {
			if (remh == 0 && remf > k1)
				return 0;

			if (remf == 0 && remh > k2)
				return 0;
			return 1;
		}
		if (dp[succf][succh][remf][remh] != -1)
			return dp[succf][succh][remf][remh];
		if (succf < k1)
			putf = dp(succf + 1, 0, remf - 1, remh);
		if (succh < k2)
			puth = dp(0, succh + 1, remf, remh - 1);

		return dp[succf][succh][remf][remh] = ((putf + puth) % mod);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		k1 = Integer.parseInt(st.nextToken());
		k2 = Integer.parseInt(st.nextToken());
		dp = new long[k1 + 1][k2 + 1][n1 + 1][n2 + 1];
		for (int i = 0; i <= k1; i++)
			for (int j = 0; j <= k2; j++)
				for (int k = 0; k <= n1; k++)
					Arrays.fill(dp[i][j][k], -1);
		System.out.println(dp(0, 0, n1, n2));
	}
}
