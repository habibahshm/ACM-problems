import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
	static final int INF = (int) 1e9;
	static int V;
	static ArrayList<Edge>[] adjlist;

	//Single Source Shortest Path on Weighted graph
	public static int dijkstra(int s, int t) {
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		dist[s] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, 0));
		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.cost > dist[u.v])
				continue;
			if (u.v == t)
				return dist[u.v];
			for (int i = 0; i < adjlist[u.v].size(); i++) {
				Edge v = adjlist[u.v].get(i);
				if (dist[u.v] + v.cost < dist[v.v]) {
					dist[v.v] = dist[u.v] + v.cost;
					pq.add(new Edge(v.v, dist[v.v]));
				}
			}
		}
		return -1;
	}

	static class Edge implements Comparable<Edge> {
		int v;
		int cost;

		Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return cost - e.cost;
			return v - e.v;
		}
	}

}
