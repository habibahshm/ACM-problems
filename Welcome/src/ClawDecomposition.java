import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ClawDecomposition {
	static int V;
	static int[] color ;
	static ArrayList<Integer>[] adjlist;

	public static boolean bipartiteCheck(int s) {
		Queue<Integer> layer = new LinkedList<Integer>();
		Arrays.fill(color, -1);
		color[s] = 0;
		boolean isBipartite = true;
		layer.add(s);
		while (!layer.isEmpty() && isBipartite) {
			int u = layer.poll();
			for (int i = 0; i < adjlist[u].size(); i++) {
				int v = adjlist[u].get(i);
				if (color[v] == -1) {
					color[v] = color[u] ^ 1;
					layer.add(v);
				} else if (color[v] == color[u]) {
					isBipartite = false;
					break;
				}
			}
		}

		return isBipartite;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while ((V = Integer.parseInt(bf.readLine())) != 0) {
			adjlist = new ArrayList[V];
			for(int i=0; i<V; i++)
				adjlist[i] = new ArrayList<Integer>();
		  color = new int[V];
			while (true) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (from != 0 && to != 0) {
					adjlist[from-1].add(to-1);
					adjlist[to-1].add(from-1);
				} else
					break;
			}
			if (bipartiteCheck(0))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
