import java.util.Arrays;

public class Kruskal {
	static Edge[] edgeList;
	static int v;

	public static int Kruskal() {
		int mst = 0;
		Arrays.sort(edgeList);
		DisjointSet d = new DisjointSet(v);
		for (Edge e : edgeList) {
			if (!d.sameSet(e.from, e.to)) {
				d.union(e.from, e.to);
				mst += e.cost;
			}
		}
		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int cost, from, to;

		public Edge(int c, int f, int t) {
			cost = c;
			from = f;
			to = t;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return cost - e.cost;
			if (from != e.from)
				return from - e.from;
			return to - e.to;
		}
	}

	static class DisjointSet {
		int[] rank;
		int[] r;

		public DisjointSet(int n) {
			rank = new int[n];
			r = new int[n];
			for (int i = 0; i < n; i++)
				r[i] = i;
			Arrays.fill(rank, 1);
		}

		public int findSet(int x) {
			if (r[x] == x)
				return x;
			return r[x] = findSet(r[x]);
		}

		public boolean sameSet(int x, int y) {
			return findSet(x) == findSet(y);
		}

		public void union(int x, int y) {
			int x1 = findSet(x);
			int y1 = findSet(y);

			if (x1 != y1) {
				if (rank[x1] > rank[y1])
					r[y1] = x1;
				else if (rank[x1] < rank[y1])
					r[x1] = y1;
				else {
					r[y1] = x1;
					rank[x1]++;
				}
			}
		}
	}

}
