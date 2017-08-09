import java.io.*;
import java.util.*;

public class Network {
	static int V;
	static int[] parent;
	static int UNVISITED = -1;
	static int dfsCounter;
	static int[] dfs_num;
	static int[] dfs_low;
	static boolean[] articulationVertex;
	static ArrayList<Integer>[] adjlist;
	static int dfsRoot;
	static int rootChildren;

	public static void articulation(int u) {
		dfs_num[u] = dfs_low[u] = dfsCounter++;
		for (int v : adjlist[u]) {
			if (dfs_num[v] == UNVISITED) {
				parent[v] = u;
				if (u == dfsRoot)
					rootChildren++;

				articulation(v);

				if (dfs_low[v] >= dfs_num[u])
					articulationVertex[u] = true;
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			} else if (v != parent[u])
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while ((V = Integer.parseInt(bf.readLine())) != 0) {
			adjlist = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjlist[i] = new ArrayList<Integer>();
			parent = new int[V];
			dfs_num = new int[V];
			Arrays.fill(dfs_num, UNVISITED);
			dfs_low = new int[V];
			articulationVertex = new boolean[V];
			st = new StringTokenizer(bf.readLine());
			int from;
			while ((from = Integer.parseInt(st.nextToken())) != 0) {
				from--;
				while (st.hasMoreTokens()) {
					int to = Integer.parseInt(st.nextToken()) - 1;
					if (!adjlist[from].contains(to))
						adjlist[from].add(to);
					if (!adjlist[to].contains(from))
						adjlist[to].add(from);
				}
				st = new StringTokenizer(bf.readLine());
			}
			dfsCounter = 0;
			for (int i = 0; i < V; i++) {
				if (dfs_num[i] == UNVISITED) {
					rootChildren = 0;
					dfsRoot = i;
					articulation(i);
					if (articulationVertex[dfsRoot])
						articulationVertex[dfsRoot] = (rootChildren > 1);
				}
			}
			int critical = 0;
			for (int i = 0; i < V; i++)
				if (articulationVertex[i])
					critical++;
			System.out.println(critical);
		}
	}
}
