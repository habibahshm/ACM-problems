import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
	static int v;
	static ArrayList<Pair>[] adjlist;

	public static int Prim() {
		int mst = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v];
		pq.add(new Pair(0, 0));
		while (!pq.isEmpty()) {
			Pair current = pq.poll();
			if (!visited[current.to]) {
				mst += current.cost;
				visited[current.to] = true;
				for (Pair a : adjlist[current.to]) {
					if (!visited[a.to])
						pq.add(a);
				}
			}
		}
		
		return mst;
	}

	static class Pair implements Comparable<Pair> {
		int to;
		int cost;

		public Pair(int t, int c) {
			to = t;
			cost = c;
		}

		public int compareTo(Pair a) {
			if (a.cost != cost)
				return cost - a.cost;
			return to - a.to;
		}

	}
}
