import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Workingout {
	static int[][] gym;
	static long[][] dp1, dp2, dp3, dp4;
	static int n, m;

	public static long dp1(int i, int j) {
		long left = -1;
		long up = -1;
		if (i == 0 && j == 0)
			return gym[0][0];

		if (dp1[i][j] != -1)
			return dp1[i][j];

		if (j > 0)
			left = dp1(i, j - 1);

		if (i > 0)
			up = dp1(i - 1, j);

		return dp1[i][j] = Math.max(left, up) + gym[i][j];
	}

	public static long dp2(int i, int j) {
		long right = -1;
		long down = -1;

		if (i == n - 1 && j == m - 1)
			return gym[i][j];

		if (dp2[i][j] != -1)
			return dp2[i][j];

		if (i < n - 1)
			down = dp2(i + 1, j);
		if (j < m - 1)
			right = dp2(i, j + 1);

		return dp2[i][j] = Math.max(right, down) + gym[i][j];
	}

	public static long dp3(int i, int j) {
		long down = -1;
		long left = -1;

		if (i == n - 1 && j == 0)
			return gym[i][j];

		if (dp3[i][j] != -1)
			return dp3[i][j];

		if (i < n - 1)
			down = dp3(i + 1, j);

		if (j > 0)
			left = dp3(i, j - 1);

		return dp3[i][j] = Math.max(down, left) + gym[i][j];
	}

	public static long dp4(int i, int j) {
		long up = -1;
		long right = -1;

		if (i == 0 && j == m - 1)
			return gym[i][j];

		if (dp4[i][j] != -1)
			return dp4[i][j];

		if (i > 0)
			up = dp4(i - 1, j);

		if (j < m - 1)
			right = dp4(i, j + 1);

		return dp4[i][j] = Math.max(up, right) + gym[i][j];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		PrintWriter out = new PrintWriter(System.out);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		gym = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; st.hasMoreTokens(); j++)
				gym[i][j] = Integer.parseInt(st.nextToken());
		}

		dp1 = new long[n][m];
		dp2 = new long[n][m];
		dp3 = new long[n][m];
		dp4 = new long[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp1[i], -1);
			Arrays.fill(dp2[i], -1);
			Arrays.fill(dp3[i], -1);
			Arrays.fill(dp4[i], -1);
		}

		long ans = -1;
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				long tmp = Math.max(dp1(i, j - 1) + dp2(i, j + 1) + dp3(i + 1, j) + dp4(i - 1, j),
						dp1(i - 1, j) + dp2(i + 1, j) + dp3(i, j - 1) + dp4(i, j + 1));
				ans = Math.max(ans, tmp);
			}
		}

		out.println(ans);
		out.flush();
		out.close();
	}

}
