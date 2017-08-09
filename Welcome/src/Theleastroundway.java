import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Theleastroundway {
	static int n;
	static int[][][] facto;
	static int INF = (int) 1e9;
	static long[][][] dp;
	static StringBuilder sb;

	static int factorize(int n, int f) {
		int ans = 0;
		while (n % f == 0) {
			ans++;
			n /= f;
		}
		return ans;
	}

	static long dp(int k, int i, int j) {
		if (i == n - 1 && j == n - 1)
			return dp[k][i][j] = facto[k][i][j];

		if (dp[k][i][j] != -1)
			return dp[k][i][j];

		long right = INF;
		long down = INF;
		if (j < n - 1 && facto[k][i][j + 1] != -1)// avoiding the zero in the
													// path
			right = dp(k, i, j + 1);
		if (i < n - 1 && facto[k][i + 1][j] != -1)
			down = dp(k, i + 1, j);

		return dp[k][i][j] = Math.min(right, down) + facto[k][i][j];
	}

	static void getPath(int k, int i, int j) {

		if (i == n - 1 && j == n - 1)
			return;

		if (i < n - 1 && dp[k][i][j] == dp[k][i + 1][j] + facto[k][i][j]) {
			sb.append("D");
			getPath(k, i + 1, j);
			return;
		}
		if (j < n - 1 && dp[k][i][j] == dp[k][i][j + 1] + facto[k][i][j]) {
			sb.append("R");
			getPath(k, i, j + 1);
			return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		facto = new int[2][n][n];
		dp = new long[2][n][n];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++)
				Arrays.fill(dp[i][j], -1);
		}
		int zerox = -1;
		int zeroy = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0) {
					zerox = i;
					zeroy = j;
					facto[0][i][j] = -1; // means that I have a zero in the path
					facto[1][i][j] = -1;
				} else {
					facto[0][i][j] = factorize(num, 2);
					facto[1][i][j] = factorize(num, 5);
				}
			}
		}
		sb = new StringBuilder();
		long path2 = dp(0, 0, 0);
		long path5 = dp(1, 0, 0);

		if (Math.min(path2, path5) <= 1 || zerox == -1) {
			if (path2 <= path5) {
				out.println(path2);
				getPath(0, 0, 0);
			} else {
				out.println(path5);
				getPath(1, 0, 0);
			}
		} else {
			if (zerox != -1) {
				out.println("1");
				int i = 0;
				int j = 0;
				while (i < zerox) {
					sb.append("D");
					i++;
				}
				while (j < zeroy) {
					sb.append("R");
					j++;
				}
				while (i < n - 1) {
					sb.append("D");
					i++;
				}
				while (j < n - 1) {
					sb.append("R");
					j++;
				}
			}
		}

		out.println(sb);

		out.flush();
		out.close();
	}
}
