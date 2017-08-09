import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheColorGame {
	static int N;
	static int[][] matrix;
	static int[][] moves;
	static int n1;
	static int n2;
	static int n3;

	static class State {
		int n1;
		int n2;

		public State(int a, int b) {
			n1 = a;
			n2 = b;
		}
	}

	public static int bfs() {
		Queue<State> layer = new LinkedList<>();
		layer.add(new State(n1, n2));
		moves[n1][n2] = 0;
		while (!layer.isEmpty()) {
			State curr = layer.poll();
			if (curr.n1 == n3 || curr.n2 == n3) {
				return moves[curr.n1][curr.n2];
			}
			int c = matrix[curr.n1][curr.n2];
			if (c != -1 && moves[c][curr.n2] == -1) {
				moves[c][curr.n2] = moves[curr.n1][curr.n2] + 1;
				layer.add(new State(c, curr.n2));
			}
			c = matrix[curr.n2][curr.n1];
			if (c != -1 && moves[curr.n1][c] == -1) {
				moves[curr.n1][c] = moves[curr.n1][curr.n2] + 1;
				layer.add(new State(curr.n1, c));
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; (N = Integer.parseInt(bf.readLine())) != 0; i++) {
			matrix = new int[N][N];
			moves = new int[N][N];
			for (int j = 0; j < N; j++)
				Arrays.fill(moves[j], -1);
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < N; k++)
					matrix[j][k] = Integer.parseInt(st.nextToken()) - 1;
			}

			st = new StringTokenizer(bf.readLine());
			n1 = Integer.parseInt(st.nextToken())-1;
			n2 = Integer.parseInt(st.nextToken())-1;
			n3 = Integer.parseInt(st.nextToken())-1;
			int ans = bfs();
			System.out.println("Game #" + i);
			if (ans == -1)
				System.out.println("Destination is Not Reachable !");
			else
				System.out.println("Minimum Number of Moves = " + ans);
			System.out.println();
		}
	}
}
