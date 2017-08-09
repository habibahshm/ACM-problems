import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AlyonaAndaTree {
	static long[] a;
	static ArrayList<Pair>[] adjlist;
	static ArrayList<Pair> ancestors;
	static long[] ans;

	static class Pair {
		int to;
		long weight;

		public Pair(int t, long w) {
			to = t;
			weight = w;
		}
	}

	public static void dfs(int u, int p, long cost) {
		ancestors.add(new Pair(u, cost));
		for (Pair v : adjlist[u]) {
			if (v.to != p)
				dfs(v.to, u, cost + v.weight);
		}
		int l = 0;
		int h = ancestors.size() - 1;
		int far_ancestor = -1;
		while (l <= h) {
			int mid = (l + h) >> 1;
			if (ancestors.get(ancestors.size() - 1).weight - ancestors.get(mid).weight <= a[u]) {
				h = mid - 1;
				far_ancestor = ancestors.get(mid).to;
			} else
				l = mid + 1;
		}

		if (far_ancestor != -1) {
			ans[far_ancestor]--;
			ans[u]++;
		}

		ancestors.remove(ancestors.size() - 1);
	}

	public static long clac(int u, int p) {
		long res = 0;
		for (Pair v : adjlist[u])
			if (v.to != p)
				res += clac(v.to, u);
		long old = ans[u];
		ans[u] = res;
		return res + old;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		a = new long[n + 1];
		adjlist = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			adjlist[i] = new ArrayList<>();
		ancestors = new ArrayList<>();
		ans = new long[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjlist[i].add(new Pair(from, w));
			adjlist[from].add(new Pair(i, w));
		}
		dfs(1, 0, 0);
		clac(1, 0);
		for (int i = 1; i <= n; i++) {
			out.print(ans[i]);
			if (i < n)
				out.print(" ");
		}
		out.println();
        out.flush();
        out.close();
	}
}
