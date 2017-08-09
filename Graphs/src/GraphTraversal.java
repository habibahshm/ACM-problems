import java.util.*;
import java.io.*;

public class GraphTraversal {
	static final int VISITED = 1;
	static final int UNVISITED = -1;
	static final int EXPLORED = -2;
	static ArrayList<Integer>[] adjlist;
	static boolean[][] adjmat;
	static boolean[] visited;
	static int V;
	static int[] distance;

	public static void preTraversal() {
		int cc = 0;
		for (int i = 0; i < V; i++) {
			// not connected
			if (!visited[i]) {
				dfs(i); // or BFS
				cc++;
			}
		}
	}

	// 1. DFS
	public static void dfs(int u) {
		visited[u] = true;

		// for adjlist
		for (int i = 0; i < adjlist[u].size(); i++) {
			int v = adjlist[u].get(i);
			if (!visited[v])
				dfs(v);
		}
		// for adjmat
		for (int i = 0; i < V; i++) {
			if (adjmat[u][i] && !visited[i])
				dfs(i);
		}
	}

	// 2.bfs
	public static void bfs(int s) {
		Queue<Integer> layer = new LinkedList<Integer>();
		Arrays.fill(distance, -1);
		distance[s] = 0;
		layer.add(s);
		while (!layer.isEmpty()) {
			int u = layer.poll();
			for (int i = 0; i < adjlist[u].size(); i++) {
				int v = adjlist[u].get(i);
				if (distance[v] == -1) {
					distance[v] = distance[u] + 1;
					layer.add(v);
				}
			}
		}
	}

	// 3.Topological sort (Tarjan's Algorithm). Only applicable on DAGs.
	static Stack<Integer> stack = new Stack<Integer>();

	public static void topoSort(int u) {
		visited[u] = true;
		for (int i = 0; i < adjlist[u].size(); i++) {
			int v = adjlist[u].get(i);
			if (!visited[v])
				topoSort(v);
		}
		stack.push(u);
	}

	// (kahn's Algorithm).
	static ArrayList<Integer> sortedArray = new ArrayList<Integer>();

	public static void topo2() {
		int[] p = new int[V];
		for (int i = 0; i < V; i++)
			for (int v : adjlist[i])
				++p[v];
		Queue<Integer> roots = new LinkedList<Integer>();
		for (int i = 0; i < V; i++)
			if (p[i] == 0)
				roots.add(i);
		while (!roots.isEmpty()) {
			int u = roots.poll();
			sortedArray.add(u);
			for (int v : adjlist[u])
				if (--p[v] == 0)
					roots.add(v);
		}
	}

	// 4. Bipartite graph check.
	static int[] color = new int[V];

	public static void bipartiteCheck(int s) {
		Queue<Integer> layer = new LinkedList<Integer>();
		Arrays.fill(color, -1);
		color[s] = 0;
		boolean isBipartite = true;
		layer.add(s);
		while (!layer.isEmpty() && isBipartite) {
			int u = layer.poll();
			for (int i = 0; i < adjlist[u].size(); i++) {
				int v = adjlist[u].get(i);
				if (color[v] == -1) {
					color[v] = color[u] ^ 1;
					layer.add(v);
				} else if (color[v] == color[u]) {
					isBipartite = false;
					break;
				}
			}
		}
	}

	// 5. Types of edges.
	static int[] p = new int[V];
	static int[] state = new int[V];

	public static void edgeCheck(int u) {
		state[u] = EXPLORED;
		for (int v : adjlist[u]) {
			if (state[v] == UNVISITED) {
				System.out.println("tree edge");
				p[v] = u;
				dfs(v);
			} else if (state[v] == EXPLORED) {
				if (p[u] == v)
					System.out.println("bidirectional edge");
				else
					System.out.println("back edge");
			} else if (state[v] == VISITED)
				System.out.println("forward edge");
		}
		state[u]=VISITED;
	}
}
