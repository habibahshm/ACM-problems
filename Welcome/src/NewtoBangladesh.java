import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class NewtoBangladesh {
	static Pair[][] adjmatrix;
	static int INF = (int) 1e9;
	static int V;

	public static void Floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise

		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++) {
					Pair tmp = new Pair(adjmatrix[i][k].t + adjmatrix[k][j].t, adjmatrix[i][k].d + adjmatrix[k][j].d);
					if (tmp.compareTo(adjmatrix[i][j]) < 0)
						adjmatrix[i][j] = tmp;
				}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = Integer.parseInt(bf.readLine());
		while (c-- > 0) {
			bf.readLine();
			st = new StringTokenizer(bf.readLine());
			V = Integer.parseInt(st.nextToken());
			adjmatrix = new Pair[V][V];
			for (int i = 0; i < V; i++) {
				Arrays.fill(adjmatrix[i], new Pair(INF, INF));
				adjmatrix[i][i] = new Pair(0, 0);
			}

			int e = Integer.parseInt(st.nextToken());
			while (e-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int t = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Pair tmp = new Pair(t, d);
				if (tmp.compareTo(adjmatrix[from][to]) < 0) {
					adjmatrix[from][to] = new Pair(t, d);
					adjmatrix[to][from] = new Pair(t, d);
				}

			}
			Floyd();
			int q = Integer.parseInt(bf.readLine());
			while (q-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken()) - 1;
				if (adjmatrix[s][d].d == INF)
					System.out.println("No Path.");
				else
					System.out.println("Distance and time to reach destination is " + adjmatrix[s][d].d + " & "
							+ adjmatrix[s][d].t + ".");
			}

			if (c > 0)
				System.out.println();

		}
	}

	static class Pair implements Comparable<Pair> {
		int t;
		int d;

		public Pair(int a, int b) {
			t = a;
			d = b;
		}

		public int compareTo(Pair a) {
			if (t != a.t)
				return t - a.t;
			return d - a.d;
		}

	}
}
