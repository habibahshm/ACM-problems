import java.io.*;
import java.util.*;

public class WalkingOnTheSafeSide {
	static int r;
	static int c;
	static int[][] map;
	static int[][] dp;

	public static boolean isValid(int i, int j) {
		return i > 0 && i < r && j > 0 && j < c && map[i][j] != 1;
	}

	public static int paths(int i, int j) {
		int path = 0;
		if (!isValid(i, j))
			return 0;
		if (i == r - 1 && j == c - 1)
			return 1;
		if (dp[i][j] != -1)
			return dp[i][j];
		path += paths(i + 1, j);
		path += paths(i, j + 1);

		return dp[i][j] = path;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			r = Integer.parseInt(st.nextToken()) + 1;
			c = Integer.parseInt(st.nextToken()) + 1;
			map = new int[r][c];
			dp = new int[r][c];
			for (int i = 1; i < r; i++)
				Arrays.fill(dp[i], -1);
			String o;
			while ((o = bf.readLine()) != null && o.length() > 0) {
				st = new StringTokenizer(o);
				int i = Integer.parseInt(st.nextToken());
				while (st.hasMoreTokens())
					map[i][Integer.parseInt(st.nextToken())] = 1;
			}
			System.out.println(paths(1, 1));
			if(n>0)
			System.out.println();
		}
	}
}
