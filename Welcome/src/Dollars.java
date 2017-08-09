import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Dollars {
	static int[] d = { 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000 };
	static long [][]dp = new long[11][30001];

	static void dp() {
		for (int i = 0; i < 11; i++)
			dp[i][0] = 1;

		for (int rem = d[0]; rem <= 30000; rem += 5) {
			for (int coin = 0; coin < 11; coin++) {
				if (coin > 0)
					dp[coin][rem] = dp[coin - 1][rem];
				if (rem - d[coin] >= 0)
					dp[coin][rem] += dp[coin][rem - d[coin]];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s;
		dp();
		while (!(s = bf.readLine()).equals("0.00")) {
			StringTokenizer st = new StringTokenizer(s, ".");
			int c = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			while (s.length() < 6)
				s = " " + s;
			out.printf(s + "%17d\n", dp[10][c]);
		}
		out.flush();
		out.close();
	}
}
