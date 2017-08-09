import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnidirectionalTSP {
	static int[][] map;
	static int r;
	static int c;
	static int[][] memo;

	public static int dp(int i, int j) {
		if (j == c)
			return 0;

		if (memo[i][j] != -1)
			return memo[i][j];

		int[] rows = { fix(i - 1), i, fix(i + 1) };
		Arrays.sort(rows);

		int dioup = map[i][j] + dp(rows[0], j + 1);
		int str = map[i][j] + dp(rows[1], j + 1);
		int diodown = map[i][j] + dp(rows[2], j + 1);

		return memo[i][j] = Math.min(dioup, Math.min(diodown, str));
	}

	public static int fix(int x) {
		return ((x % r) + r) % r;
	}

	public static void print(int i, int j) {
		if (j == c)
			return;

		System.out.print(i + 1);
		if (j < c - 1)
			System.out.print(" ");

		int optimal = dp(i, j);

		int[] rows = { fix(i - 1), i, fix(i + 1) };
		Arrays.sort(rows);

		if (map[i][j] + dp(rows[0], j + 1) == optimal) {
			print(rows[0], j + 1);
			return;
		}
		if (map[i][j] + dp(rows[1], j + 1) == optimal) {
			print(rows[1], j + 1);
			return;
		}
		if (map[i][j] + dp(rows[2], j + 1) == optimal) {
			print(rows[2], j + 1);
			return;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (bf.ready()) {
			st = new StringTokenizer(bf.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new int[r][c];
			memo = new int[r][c];

			for (int i = 0; i < r; i++)
				Arrays.fill(memo[i], -1);

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (!st.hasMoreTokens())
						st = new StringTokenizer(bf.readLine());
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			int min = dp(0, 0);
			int indx = 0;
			for (int i = 1; i < r; i++) {
				int cur = dp(i, 0);
				if (cur < min) {
					min = cur;
					indx = i;
				}
			}

			print(indx, 0);
			System.out.println();
			System.out.println(min);
		}
	}
}
