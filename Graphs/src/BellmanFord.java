import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
	// SSSP on graph with negative cycle
	static int V;
	static ArrayList<Edge>[] adjlist;
	static int INF = (int) 1e9;

	public static boolean bellmanFord(int s) {
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		dist[s] = 0;
		boolean modified = true;
		for (int i = 0; i < V && modified; i++) {
			modified = false;
			for (int u = 0; u < V; u++) {
				for (Edge v : adjlist[u]) {
					if (dist[v.to] < dist[u] + v.cost) {
						dist[v.to] = dist[u] + v.cost;
						modified = true;
					}
				}
			}
		}

		boolean negative_cycle_exisits = false;
		for (int u = 0; u < V; u++) {
			for (Edge v : adjlist[u]) {
				if (dist[v.to] > dist[u] + v.cost)
					negative_cycle_exisits = true;

			}
		}

		return negative_cycle_exisits;
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		Edge(int t, int cost) {
			to = t;
			this.cost = cost;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return cost - e.cost;
			return to - e.to;
		}
	}

}
