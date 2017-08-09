import java.util.*;
import java.io.*;

public class ArticulationPointsAndBridges { // in Undirected Graphs.
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
				if (dfs_low[v] > dfs_num[u])
					System.out
							.println("edge " + u + "--->" + v + "is a bridge");
				//else
				//make edge from u to v
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			} else if (v != parent[u])
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
			//make edge from u to v
		}
	}

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(dfs_num, UNVISITED);
		dfsCounter = 0;
		for (int i = 0; i < V; i++) {
			if (dfs_num[i] == UNVISITED) {
				rootChildren = 0;
				dfsRoot = i;
				articulation(i);
				articulationVertex[dfsRoot] = (rootChildren > 1);
			}
		}

	}
}
