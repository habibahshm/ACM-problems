import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ExchangeRates {
	static int[][] adjmatrix;
	static int N;
	static TreeMap<String, Integer> tm = new TreeMap<>();
	static boolean[] visited;

	public static void assertion(int a, String b, int c, String d) {
		if (!tm.containsKey(b))
			tm.put(b, N++);
		if (!tm.containsKey(d))
			tm.put(d, N++);

		int gcd = gcd(a, c);

		adjmatrix[tm.get(b)][tm.get(d)] = a / gcd;
		adjmatrix[tm.get(d)][tm.get(b)] = c / gcd;

	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static Pair dfs(int u, int v) {
		visited[u] = true;
		for (int i = 0; i < N; i++) {
			if (adjmatrix[u][i] != 0 && !visited[i]) {
				if (i == v)
					return new Pair(adjmatrix[u][i], adjmatrix[i][u]);

				Pair mid = dfs(i, v);
				if (mid == null)
					continue;

				int gcd = gcd(adjmatrix[u][i] * mid.a, adjmatrix[i][u] * mid.b);
				return new Pair(adjmatrix[u][i] * mid.a / gcd, adjmatrix[i][u] * mid.b / gcd);

			}
		}

		return null;
	}

	public static void query(String a, String b) {
		if (!tm.containsKey(a) || !tm.containsKey(b))
			System.out.println("? " + a + " = " + "? " + b);
		else {
			visited = new boolean[N];
			Pair ans = dfs(tm.get(a), tm.get(b));
			if (ans != null)
				System.out.println(ans.a + " " + a + " = " + ans.b + " " + b);
			else
				System.out.println("? " + a + " = " + "? " + b);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		adjmatrix = new int[60][60];
		N = 0;
		while (!(s = bf.readLine()).equals(".")) {
			st = new StringTokenizer(s);
			if ((st.nextToken()).equals("!")) {
				int n = Integer.parseInt(st.nextToken());
				String a = st.nextToken();
				st.nextToken();
				int m = Integer.parseInt(st.nextToken());
				String b = st.nextToken();
				assertion(n, a, m, b);
			} else {
				String a = st.nextToken();
				st.nextToken();
				String b = st.nextToken();
				query(a, b);
			}

		}

	}

	static class Pair {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
