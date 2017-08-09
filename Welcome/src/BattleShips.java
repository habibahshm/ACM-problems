import java.io.*;


public class BattleShips {
	static char[][] grid;
	static int[] x = { 1, -1, 0, 0 };
	static int[] y = { 0, 0, 1, -1 };
	static int n;

	public static boolean valid(int r, int c) {
		return r < n && r >= 0 && c < n && c >= 0 && grid[r][c] != '.';
	}

	public static boolean dfs(int r, int c) {
		boolean alive = (grid[r][c] == 'x');

		grid[r][c] = '.';

		for (int i = 0; i < 4; i++) {
			if (valid(r + y[i], c + x[i]))
				alive = alive | dfs(r + y[i], c + x[i]);
		}
		return alive;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int k = 1; k <= t; k++) {
			n = Integer.parseInt(bf.readLine());
			grid = new char[n][];
			for (int i = 0; i < n; i++)
				grid[i] = bf.readLine().toCharArray();
			int ships = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (grid[i][j] != '.' && dfs(i, j))
						ships++;

			System.out.println("Case " + k + ": " + ships);
		}
	}
}
