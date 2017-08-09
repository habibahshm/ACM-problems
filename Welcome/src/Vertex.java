import java.util.*;
import java.io.*;

public class Vertex {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void dfs(int startn) {
		for (int i = 0; i < graph[startn].size(); i++) {
			int u = graph[startn].get(i);
			if (visited[u])
				continue;
			else {
				visited[u] = true;
				dfs(u);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			graph = new ArrayList[n + 1];
			for (int i = 0; i < n + 1; i++)
				graph[i] = new ArrayList<Integer>();
			String s;
			StringTokenizer st;
			String node;
			while (!(s = bf.readLine()).equals("0")) {
				st = new StringTokenizer(s);
				int from = Integer.parseInt(st.nextToken());
				while (!(node = st.nextToken()).equals("0")) {
					int to = Integer.parseInt(node);
					graph[from].add(to);
				}
			}
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			ArrayList<Integer> v = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				visited = new boolean[n + 1];
				int r = Integer.parseInt(st.nextToken());
				dfs(r);
				int count = 0;
				for (int j = 1; j < visited.length; j++) {
					if (!visited[j]) {
						count++;
						v.add(j);
					}
				}
				System.out.print(count);
				for (int k = 0; k < v.size(); k++)
					System.out.print(" " + v.get(k));
				System.out.println();
				v.clear();
			}
		}
	}
}
