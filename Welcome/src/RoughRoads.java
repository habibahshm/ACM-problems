import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RoughRoads {
	static final int INF = (int) 1e9;
	static int V;
	static ArrayList<Edge>[] adjlist;

	// Single Source Shortest Path on Weighted graph
	public static int dijkstra(int s, int t) {
		PriorityQueue<Triple> pq = new PriorityQueue<>();
		pq.add(new Triple(s, 0, 0));
		int[][] dist = new int[V][2];
		for (int i = 0; i < V; i++)
			Arrays.fill(dist[i], INF);
		dist[0][0] = 0;
		while (!pq.isEmpty()) {
			Triple u = pq.poll();

			if (u.walking == 1 && u.cost > dist[u.to][1] || u.walking == 0 && u.cost > dist[u.to][0])
				continue;
			for (int i = 0; i < adjlist[u.to].size(); i++) {
				Edge v = adjlist[u.to].get(i);

				int totaldist = v.cost + u.cost;

				if (totaldist < dist[v.v][(u.walking + 1) % 2]) {
					dist[v.v][(u.walking + 1) % 2] = totaldist;
					pq.add(new Triple(v.v, totaldist, (u.walking + 1) % 2));
				}

			}
		}
		return dist[t][0];
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

	static class Triple implements Comparable<Triple> {
		int to;
		int cost;
		int walking;// 1 for walking, 0 for riding

		Triple(int t, int c, int e) {
			to = t;
			cost = c;
			walking = e;
		}

		public int compareTo(Triple e) {
			if (cost != e.cost)
				return cost - e.cost;
			return to - e.to;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; true; i++) {
			st = new StringTokenizer(bf.readLine());
			V = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList[V];

			for (int j = 0; j < V; j++)
				adjlist[j] = new ArrayList<>();
			while (e-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				adjlist[from].add(new Edge(to, cost));
				adjlist[to].add(new Edge(from, cost));
			}
			System.out.println("Set #" + i);
			int ans = dijkstra(0, V - 1);
			if (ans == INF)
				System.out.println("?");
			else
				System.out.println(ans);
		}
	}
}
