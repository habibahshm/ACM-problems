import java.io.*;
import java.util.*;

public class TheSultanSuccessors {
	static int[] row = new int[8];
	static int[][] board = new int[8][8];
	static int sum;
	static int ans;

	public static boolean ok(int r, int c) {
		for (int i = 0; i < c; i++)
			if (row[i] == r || Math.abs(row[i] - r) == Math.abs(c - i))
				return false;
		return true;
	}

	public static void backtrack(int c) {
		if (c == 8) {
			for (int i = 0; i < 8; i++)
				sum += board[row[i]][i];
			ans = Math.max(sum, ans);
			sum = 0;
		}
		for (int r = 0; r < 8; r++) {
			if (ok(r, c)) {
				row[c] = r;
				backtrack(c + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(bf.readLine());
		while (k-- > 0) {
			sum = 0;
			ans = -1;
			for (int i = 0; i < 8; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 8; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			backtrack(0);
			System.out.printf("%5d", ans);
			System.out.println();
		}
	}
}
