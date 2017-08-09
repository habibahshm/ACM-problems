import java.io.*;
import java.util.*;

public class TrustGroups {
	static ArrayList<Integer>[] adjlist;
	static int p, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;

	static void tarjanSCC() // O(V + E)
	{
		for (int i = 0; i < p; ++i)
			if (dfs_num[i] == 0)
				tarjan(i);
	}

	public static void tarjan(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		for (int v : adjlist[u]) {
			if (dfs_num[v] == 0)
				tarjan(v);
			if (!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
		}

		if (dfs_num[u] == dfs_low[u]) {
			// SCC found
			while (true) {
				int v = stack.pop();
				inSCC[v] = true;
				if (v == u)
					break;
			}
			SCC++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		while (!(s = bf.readLine()).equals("0 0")) {
			TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
			st = new StringTokenizer(s);
			p = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList[p];
			for (int i = 0; i < p; i++) {
				String name = bf.readLine();
				tm.put(name, i);
				adjlist[i] = new ArrayList<Integer>();
			}
			while (t-- > 0) {
				String s1 = bf.readLine();
				String s2 = bf.readLine();
				int from = tm.get(s1);
				int to = tm.get(s2);
				adjlist[from].add(to);
			}
			counter = SCC = 0;
			dfs_num = new int[p];
			dfs_low = new int[p];
			inSCC = new boolean[p];
			stack = new Stack<Integer>();
			tarjanSCC();
			System.out.println(SCC);
		}
	}
}
