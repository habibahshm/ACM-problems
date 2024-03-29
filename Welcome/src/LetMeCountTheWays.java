import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetMeCountTheWays {
	static int[] coins = { 1, 5, 10, 25, 50 };
	static long[][] dp = new long[5][30001];

	static void dp() {
		for (int i = 0; i < 5; i++)
			dp[i][0] = 1;

		for (int rem = coins[0]; rem <= 30000; rem += 1) {
			for (int coin = 0; coin < 5; coin++) {
				if (coin > 0)
					dp[coin][rem] = dp[coin - 1][rem];
				if (rem - coins[coin] >= 0)
					dp[coin][rem] += dp[coin][rem - coins[coin]];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		dp();
		while (bf.ready()) {
			int c = Integer.parseInt(bf.readLine());
			long ans = dp[4][c];
			if (ans == 1)
				System.out.println("There is only 1 way to produce " + c + " cents change.");
			else
				System.out.println("There are " + ans + " ways to produce " + c + " cents change.");
		}
	}
}
