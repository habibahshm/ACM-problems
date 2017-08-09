import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wormholes {
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

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(bf.readLine());
			V = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjlist[i] = new ArrayList<>();
			int e = Integer.parseInt(st.nextToken());
			while (e-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				adjlist[from].add(new Edge(to, cost));
			}
			if (bellmanFord(0))
				System.out.println("possible");
			else
				System.out.println("not possible");
		}
	}
}
