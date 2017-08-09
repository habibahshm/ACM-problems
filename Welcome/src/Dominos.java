import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Dominos {
	static ArrayList<Integer>[] adjlist;
	static int V, counter, SCC, dfs_num[], dfs_low[];

	static boolean[] inSCC;
	static Stack<Integer> stack;
	static int ans;
	static int[] scc_num;
	static boolean[] outer_edge;

	static void tarjanSCC() // O(V + E)
	{
		for (int i = 0; i < V; ++i)
			if (dfs_num[i] == -1)
				tarjan(i);
	}

	public static void tarjan(int u) {
		dfs_num[u] = dfs_low[u] = counter++;
		stack.push(u);
		for (int v : adjlist[u]) {
			if (dfs_num[v] == -1)
				tarjan(v);

			if (!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
		}

		if (dfs_num[u] == dfs_low[u]) {
			// SCC found
			while (true) {
				int v = stack.pop();
				inSCC[v] = true;
				scc_num[v] = SCC;
				if (v == u)
					break;
			}
			SCC++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			counter = 0;
			SCC = 0;
			ans = 0;
			st = new StringTokenizer(bf.readLine());
			V = Integer.parseInt(st.nextToken());
			dfs_num = new int[V];
			Arrays.fill(dfs_num, -1);
			dfs_low = new int[V];
			inSCC = new boolean[V];
			scc_num = new int[V];
			stack = new Stack<>();
			adjlist = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjlist[i] = new ArrayList<>();
			int e = Integer.parseInt(st.nextToken());
			while (e-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				adjlist[from].add(to);
			}
			tarjanSCC();
			outer_edge = new boolean[SCC];

			for (int u = 0; u < V; u++)
				for (int v : adjlist[u]) {
					if (scc_num[u] != scc_num[v])
						outer_edge[scc_num[v]] = true;
				}

			for (int i = 0; i < SCC; i++)
				if (!outer_edge[i])
					ans++;
			System.out.println(ans);

		}
	}
}
