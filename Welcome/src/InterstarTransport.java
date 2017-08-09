import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class InterstarTransport {
	static Pair[][] adjmatrix;
	static int[][] p;
	static int INF = (int) 1e9;
	static int V;
	static ArrayList<Character> ans;

	// APSP
	public static void Floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise
		p = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				p[i][j] = i;

		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++) {
					Pair tmp = new Pair(adjmatrix[i][k].inter + adjmatrix[k][j].inter,
							adjmatrix[i][k].cost + adjmatrix[k][j].cost);
					if (tmp.compareTo(adjmatrix[i][j]) < 0) {
						adjmatrix[i][j] = tmp;
						p[i][j] = p[k][j];
					}
				}
	}

	static void printPath(int i, int j) {
		if (i != j)
			printPath(i, p[i][j]);
		ans.add((char) (j + 'A'));
	}

	static class Pair implements Comparable<Pair> {
		int inter;
		int cost;

		public Pair(int t, int c) {
			inter = t;
			cost = c;
		}

		public int compareTo(Pair a) {
			if (cost != a.cost)
				return cost - a.cost;
			return inter - a.inter;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		st.nextToken();
		ans = new ArrayList<>();
		V = 26;
		adjmatrix = new Pair[V][V];
		for (int i = 0; i < V; i++) {
			Arrays.fill(adjmatrix[i], new Pair(INF, INF));
			adjmatrix[i][i] = new Pair(1, 0);
		}

		int p = Integer.parseInt(st.nextToken());
		while (p-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int a = st.nextToken().charAt(0) - 65;
			int b = st.nextToken().charAt(0) - 65;
			int c = Integer.parseInt(st.nextToken());
			adjmatrix[a][b] = new Pair(2, c);
			adjmatrix[b][a] = new Pair(2, c);
		}
		Floyd();
		st = new StringTokenizer(bf.readLine());
		int q = Integer.parseInt(st.nextToken());
		while (q-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int s = st.nextToken().charAt(0) - 65;
			int d = st.nextToken().charAt(0) - 65;
			printPath(s, d);
			for (int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i));
				if (i != ans.size() - 1)
					System.out.print(" ");
				else
					System.out.println();
			}
			ans.clear();
		}
	}
}
