import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange {
	static int[] coins = { 50, 25, 10, 5, 1 };
	static int dp[][];

	public static int ways(int idx, int remM) {
		if (remM == 0)
			return 1;
		if (remM < 0 || idx == 5)
			return 0;
		if (dp[idx][remM] != -1)
			return dp[idx][remM];
		int take = ways(idx, remM - coins[idx]);
		int leave = ways(idx + 1, remM);
		return dp[idx][remM] = take + leave;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[5][8000];
		while (bf.ready()) {
			int amount = Integer.parseInt(bf.readLine());
			for (int i = 0; i < 5; i++)
				Arrays.fill(dp[i], -1);
			long x = ways(0, amount);
			System.out.println(x);
		}
	}
}
