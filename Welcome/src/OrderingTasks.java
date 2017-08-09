import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class OrderingTasks {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static Queue<Integer> topo;

	public static void dfs(int n) {
		if (visited[n])
			return;
		visited[n] = true;
		for (int i = 0; i < graph[n].size(); i++) {
			dfs(graph[n].get(i));
		}
		topo.add(n);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String in = bf.readLine();
		while (!in.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(in);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			graph = new ArrayList[n];
			visited = new boolean[n];

			for (int i = 0; i < n; i++)
				graph[i] = new ArrayList<Integer>();

			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int to = Integer.parseInt(st.nextToken()) - 1;
				int from = Integer.parseInt(st.nextToken()) - 1;
				graph[from].add(to);
			}
			topo = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				if (!visited[i])
					dfs(i);
			}
			while (!topo.isEmpty()) {
				System.out.print(topo.poll() + 1 + " ");
			}
			System.out.println();
			in = bf.readLine();
		}

	}
}
