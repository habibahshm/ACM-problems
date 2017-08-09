import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EternalVictory {
	static int v;
	static ArrayList<Pair>[] adjlist;
	static int[] dist;
	static long max;

	static void dfs(int u) {
		for (Pair c : adjlist[u]) {
			if (dist[c.to] == -1) {
				dist[c.to] = dist[u] + c.cost;
				max = Math.max(max, dist[c.to]);
				dfs(c.to);
			}
		}
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

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(bf.readLine());
		adjlist = new ArrayList[v];
		for (int i = 0; i < v; i++)
			adjlist[i] = new ArrayList<>();
		dist = new int[v];
		Arrays.fill(dist, -1);
		long total = 0;
		for (int i = 0; i < v - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int to = Integer.parseInt(st.nextToken()) - 1;
			int from = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			total += (w * 2);
			adjlist[to].add(new Pair(from, w));
			adjlist[from].add(new Pair(to, w));
		}

		for (int i = 0; i < v; i++) {
			if (dist[i] == -1) {
				dist[i] = 0;
				dfs(i);
			}
		}
		System.out.println(total - max);
	}
}
