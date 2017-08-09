import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Racing {
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
				return a.cost - cost;
			return a.to - to;
		}

	}

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = Integer.parseInt(bf.readLine());
		while (c-- > 0) {
			st = new StringTokenizer(bf.readLine());
			v = Integer.parseInt(st.nextToken());
			adjlist = new ArrayList[v];
			for (int i = 0; i < v; i++)
				adjlist[i] = new ArrayList<>();
			int e = Integer.parseInt(st.nextToken());
			int total = 0;
			while (e-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				total += cost;
				adjlist[from].add(new Pair(to, cost));
				adjlist[to].add(new Pair(from, cost));
			}
			System.out.println(total - Prim());
		}
	}

}
