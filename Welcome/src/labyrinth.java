import java.io.*;
import java.util.*;

public class labyrinth {
	static char[][] maze;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int max_rows;
	static int max_columns;
	static int[][] dist;
	static Queue<Block> layer;

	static class Block {
		int r;
		int c;

		public Block(int y, int x) {
			r = y;
			c = x;
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < max_rows && c >= 0 && c < max_columns;
	}

	public static void bfs(int r, int c) {
		layer.add(new Block(r, c));
		dist[r][c] = 0;
		while (!layer.isEmpty()) {
			Block u = layer.poll();
			for (int i = 0; i < 4; i++) {
				int new_r = u.r + dx[i];
				int new_c = u.c + dy[i];
				if (isValid(new_r, new_c) && maze[new_r][new_c] == '.'
						&& dist[new_r][new_c] == -1) {
					dist[new_r][new_c] = dist[u.r][u.c] + 1;
					layer.add(new Block(new_r, new_c));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			max_rows = r;
			max_columns = c;
			maze = new char[r][c];
			dist = new int[r][c];
			for (int i = 0; i < r; i++)
				Arrays.fill(dist[i], -1);
			int starti = -1;
			int startj = -1;
			for (int i = 0; i < r; i++) {
				maze[i] = bf.readLine().toCharArray();
				for (int j = 0; j < maze[i].length; j++) {
					if (starti == -1 && maze[i][j] == '.') {
						starti = i;
						startj = j;
					}
				}
			}
			layer = new LinkedList<>();
			bfs(starti, startj);
			int max = -1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (dist[i][j] > max) {
						max = dist[i][j];
						starti = i;
						startj = j;
					}
				}
			}
			for (int i = 0; i < r; i++)
				Arrays.fill(dist[i], -1);
			bfs(starti, startj);
			max = -1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (dist[i][j] > max)
						max = dist[i][j];
				}
			}
			System.out.println("Maximum rope length is " + max + ".");
		}
	}
}
