import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LuckyTree {
	static ArrayList<Pair>[] adjlist;
	static boolean[] visited;

	static class Pair {
		int to;
		boolean lucky;

		public Pair(int t, boolean l) {
			to = t;
			lucky = l;
		}
	}

	public static boolean lucky(int x) {
		while (x > 0) {
			int d = x % 10;
			if (d != 7 && d != 4)
				return false;
			x /= 10;
		}
		return true;
	}

	public static int dfs(int u) {
		int sz = 1;
		visited[u] = true;
		for (Pair v : adjlist[u])
			if (!v.lucky && !visited[v.to])
				sz += dfs(v.to);
		return sz;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		visited = new boolean[n];
		adjlist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			boolean l = lucky(w);
			adjlist[from].add(new Pair(to, l));
			adjlist[to].add(new Pair(from, l));
		}
		long ans = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				long comp = dfs(i);
				ans += comp * (n - comp) * (n - comp - 1);
			}
		}
		System.out.println(ans);

	}
}
