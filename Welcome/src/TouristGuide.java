import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TouristGuide {
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
			// make edge from u to v
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; (V = Integer.parseInt(bf.readLine())) != 0; t++) {
			if (t > 1)
				System.out.println();
			TreeMap<String, Integer> tm = new TreeMap<>();
			String[] arr = new String[V];
			for (int i = 0; i < V; i++) {
				String tmp = bf.readLine();
				tm.put(tmp, i);
				arr[i] = tmp;
			}
			adjlist = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjlist[i] = new ArrayList<>();

			int e = Integer.parseInt(bf.readLine());
			while (e-- > 0) {
				st = new StringTokenizer(bf.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				adjlist[tm.get(a)].add(tm.get(b));
				adjlist[tm.get(b)].add(tm.get(a));
			}

			parent = new int[V];
			dfsCounter = 0;
			articulationVertex = new boolean[V];
			dfs_low = new int[V];
			dfs_num = new int[V];
			Arrays.fill(dfs_num, UNVISITED);
			for (int i = 0; i < V; i++) {
				if (dfs_num[i] == UNVISITED) {
					dfsRoot = i;
					rootChildren = 0;
					articulation(i);
					if (articulationVertex[dfsRoot])
						articulationVertex[dfsRoot] = (rootChildren > 1);
				}
			}

			PriorityQueue<String> pq = new PriorityQueue<>();
			int num = 0;
			for (int i = 0; i < V; i++) {
				if (articulationVertex[i]) {
					num++;
					pq.add(arr[i]);
				}
			}

			System.out.println("City map #" + t + ": " + num + " camera(s) found");
			while (!pq.isEmpty())
				System.out.println(pq.remove());
		}
	}
}
