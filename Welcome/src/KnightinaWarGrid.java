import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class KnightinaWarGrid {
	static int[][] grid;
	static int r;
	static int c;
	static int[] dx;
	static int[] dy;
	static int even;
	static int odd;
	static boolean[][] visited;
	static boolean[][] checked;

	static class Pair {
		int i;
		int j;

		public Pair(int a, int b) {
			i = a;
			j = b;
		}
	}

	public static boolean valid(int i, int j) {
		return i >= 0 && i < r && j >= 0 && j < c && grid[i][j] != 1;
	}

	static void dfs(int i, int j) {
		visited[i][j] = true;
		int ans = 0;
		ArrayList<Pair> tmp = new ArrayList<>();
		for (int k = 0; k < 8; k++)
			if (valid(i + dx[k], j + dy[k]) && !checked[i + dx[k]][j + dy[k]]) {
				ans++;
				checked[i + dx[k]][j + dy[k]] = true;
				tmp.add(new Pair(i + dx[k], j + dy[k]));
			}
		
		if(ans==0 && i==0 && j==0)
			even++;

		if (ans != 0) {
			if (ans % 2 == 0)
				even++;
			else
				odd++;
		}

		for (Pair a : tmp) {
			checked[a.i][a.j] = false;
		}
		for (Pair a : tmp) {
			if (!visited[a.i][a.j])
				dfs(a.i, a.j);
		}

		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for (int a = 1; a <= t; a++) {
			st = new StringTokenizer(bf.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			dx = new int[] { m, m, -m, -m, n, n, -n, -n };
			dy = new int[] { n, -n, n, -n, m, -m, m, -m };

			grid = new int[r][c];
			visited = new boolean[r][c];
			checked = new boolean[r][c];

			int w = Integer.parseInt(bf.readLine());
			while (w-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				grid[i][j] = 1;
			}
			odd = 0;
			even = 0;
			dfs(0, 0);
			System.out.println("Case " + a + ": " + even + " " + odd);
		}
	}

}
