import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Animals {
	static int n;
	static int[] c;
	static int[][] dp;

	public static int dp(int ind, int remfood) {
		if (remfood < 0)
			return -1000000000;

		if (ind == n || remfood == 0)
			return 0;

		if (dp[ind][remfood] != -1)
			return dp[ind][remfood];

		int take = dp(ind + 1, remfood - (c[ind] * (n - ind))) + 1;
		int leave = dp(ind + 1, remfood);

		return dp[ind][remfood] = Math.max(take, leave);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		c = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; st.hasMoreTokens(); i++)
			c[i] = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][x + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], -1);
		out.println(dp(0, x));
		out.flush();
		out.close();
	}
}
