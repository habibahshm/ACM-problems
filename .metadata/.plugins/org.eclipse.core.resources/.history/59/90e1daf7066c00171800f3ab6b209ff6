import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Itisallaboutwisdom {
	static ArrayList<Edge>[] adjlist;
	static int N;
	static int k;
	static final int INF = (int) 1e9;

	public static class Edge {
		int node;
		int cost;
		int wisdom;

		public Edge(int n, int c, int w) {
			node = n;
			cost = c;
			wisdom = w;
		}
	}

	public static class Pair implements Comparable<Pair> {
		int node;
		int cost;

		public Pair(int n, int c) {
			node = n;
			cost = c;
		}

		@Override
		public int compareTo(Pair o) {
			if (cost != o.cost)
				return cost - o.cost;
			return node - o.node;
		}
	}

	// Single Source Shortest Path on Weighted graph
	public static int dijkstra(int s, int t, int w) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[s] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(s, 0));
		while (!pq.isEmpty()) {
			Pair u = pq.poll();
			if (u.cost > dist[u.node])
				continue;
			if (u.node == t)
				return dist[u.node];
			for (int i = 0; i < adjlist[u.node].size(); i++) {
				Edge v = adjlist[u.node].get(i);
				if (v.wisdom > w)
					continue;
				if (dist[u.node] + v.cost < dist[v.node]) {
					dist[v.node] = dist[u.node] + v.cost;
					pq.add(new Pair(v.node, dist[v.node]));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int maxWisdom = -1;

			adjlist = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++)
				adjlist[i] = new ArrayList<>();

			while (m-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				maxWisdom = Math.max(maxWisdom, w);
				adjlist[from].add(new Edge(to, c, w));
				adjlist[to].add(new Edge(from, c, w));
			}

			int lo = 1;
			int high = maxWisdom;
			int ans = -1;

			while (lo <= high) {
				int mid = (lo + high) >> 1;
				int pans = dijkstra(1, N, mid);
				if (pans >= k || pans == -1)
					lo = mid + 1;
				else {
					ans = mid;
					high = mid - 1;
				}
			}

			System.out.println(ans);

		}
	}
}
