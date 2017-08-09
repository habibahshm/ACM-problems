import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FlightPlanner {
	static int[][] w;
	static int[][] memo;
	static int width;
	static int INF = (int) 1e9;

	public static int dp(int i, int j) {

		if (i < 0 || i == 10 || j > width)
			return INF;

		if (j == width) {
			if (i == 9)
				return 0;
			return INF;
		}

		if (memo[i][j] != -1)
			return memo[i][j];

		int climb = 60 - (w[i][j]) + dp(i - 1, j + 1);

		int maintain = 30 - (w[i][j]) + dp(i, j + 1);
		int drop = 20 - (w[i][j]) + dp(i + 1, j + 1);

		return memo[i][j] = Math.min(climb, Math.min(maintain, drop));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			bf.readLine();
			width = Integer.parseInt(bf.readLine()) / 100;
			w = new int[10][width];
			memo = new int[10][width];
			for (int i = 0; i < 10; i++) {
				st = new StringTokenizer(bf.readLine());
				Arrays.fill(memo[i], -1);
				for (int j = 0; j < width; j++) {
					w[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(dp(9, 0));

			System.out.println();
		}
	}
}