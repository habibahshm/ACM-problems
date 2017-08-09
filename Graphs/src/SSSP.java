import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SSSP {
	static ArrayList<Integer>[] adjlist;
	static int V;
	static int[] distance;
	static int[] p;
	static int s;

	// Single Source Shortest Path on UNweighted graph
	public static void bfs(int s) {
		Queue<Integer> layer = new LinkedList<Integer>();
		Arrays.fill(distance, -1);
		Arrays.fill(p, -1);
		distance[s] = 0;
		layer.add(s);
		while (!layer.isEmpty()) {
			int u = layer.poll();
			for (int i = 0; i < adjlist[u].size(); i++) {
				int v = adjlist[u].get(i);
				if (distance[v] == -1) {
					distance[v] = distance[u] + 1;
					p[v] = u;
					layer.add(v);
				}
			}
		}
	}

	public static void printPath(int u) {
		if (u == s) {
			System.out.print(s);
			return;
		}
		printPath(p[u]);
		System.out.print(u + " ");
	}
	
	
	
}
