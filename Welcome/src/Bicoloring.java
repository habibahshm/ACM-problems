import java.io.*;
import java.util.*;

public class Bicoloring {
	static ArrayList<Integer>[] graph;
	static int[] colour;
	static Queue<Integer> layer;

	public static boolean bfs() {
		layer.add(0);
		colour[0] = 0;
		while (!layer.isEmpty()) {
			int u = layer.poll();
			for (int i = 0; i < graph[u].size(); i++) {
				int v = graph[u].get(i);
				if (colour[v] == -1) {
					colour[v] = 1 - colour[u];
					layer.add(v);
				}
				if (colour[u] == colour[v])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			int edges = Integer.parseInt(bf.readLine());
			graph = new ArrayList[n];
			for (int i = 0; i < n; i++)
				graph[i] = new ArrayList();
			colour = new int[n];
			Arrays.fill(colour, -1);
			while (edges-- > 0) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int source = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				graph[source].add(dest);
				graph[dest].add(source);
			}
			layer = new LinkedList<>();

			if (bfs())
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");

			Arrays.fill(colour, -1);
		}
	}
}
