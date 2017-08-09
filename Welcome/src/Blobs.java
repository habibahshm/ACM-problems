import java.io.*;
import java.util.*;

public class Blobs {
	static char[][] grid;
	static boolean[][] visited;
	static Queue<Block> layer;
	static int[] dx = { 1, 0, -1, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, -1, 0, 1, 1, -1, -1, 1 };
	static int max_r;
	static int max_c;
	static int count;

	static class Block {
		int r;
		int c;

		public Block(int y, int x) {
			r = y;
			c = x;
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < max_r && c >= 0 && c < max_c && grid[r][c] == '1'
				&& !visited[r][c];
	}

	public static void bfs(int r, int c) {
		layer.add(new Block(r, c));
		visited[r][c] = true;
		count = 1;
		while (!layer.isEmpty()) {
			Block u = layer.poll();
			for (int i = 0; i < 8; i++) {
				int new_r = u.r + dy[i];
				int new_c = u.c + dx[i];
				if (isValid(new_r, new_c)) {
					visited[new_r][new_c] = true;
					layer.add(new Block(new_r, new_c));
					count++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (n-- > 0) {
			String o;
			grid = new char[25][25];
			int k;
			for (k = 0; (o = bf.readLine()) != null && o.length() != 0; k++) {
				grid[k] = o.toCharArray();
				max_r = k;
				if (k == 0)
					max_c = grid[k].length;
			}
			max_r++;

			visited = new boolean[max_r][max_c];

			layer = new LinkedList<>();
			int max = 0;
			for (int i = 0; i < max_r; i++) {
				for (int j = 0; j < max_c; j++) {
					if (isValid(i, j)) {
						bfs(i, j);
						max = Math.max(max, count);
					}
				}
			}
			System.out.println(max);
			System.out.println();
		}
	}
}
