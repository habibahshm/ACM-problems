import java.io.*;
import java.util.*;

public class StreetDirection {
	static ArrayList<Integer>[] adjlist;
	static int n;
	static int[] parent;
	static int UNVISITED = -1;
	static int dfsCounter;
	static int[] dfs_num;
	static int[] dfs_low;
	static boolean[][]checked;

	public static void articulation(int u) {
		dfs_num[u] = dfs_low[u] = dfsCounter++;
		for (int v : adjlist[u]) {
			if (dfs_num[v] == UNVISITED) {
				parent[v] = u;

				articulation(v);

				if (dfs_low[v] > dfs_num[u]) {
					System.out.println(u + " " + v);
					System.out.println(v + " " + u);
				} else
					System.out.println(u + " " + v);

				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			} else if (v != parent[u] && !checked[u][v]) {
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
				checked[u][v]=checked[v][u]=true;
				System.out.println(u + " " + v);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		for (int t = 1; !(s = bf.readLine()).equals("0 0"); t++) {
			st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			parent = new int[n + 1];
			checked = new boolean[n+1][n+1];
			dfsCounter = 0;
			dfs_num = new int[n + 1];
			Arrays.fill(dfs_num, -1);
			dfs_low = new int[n + 1];
			int m = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList[n + 1];
			for (int i = 0; i < n + 1; i++)
				adjlist[i] = new ArrayList<Integer>();
			while (m-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (!adjlist[from].contains(to))
					adjlist[from].add(to);
				if (!adjlist[to].contains(from))
					adjlist[to].add(from);
			}
			System.out.println(t);
			System.out.println();
			for (int i = 1; i < n + 1; i++)
				if (dfs_num[i] == UNVISITED)
					articulation(i);

			System.out.println("#");
		}
	}
}
