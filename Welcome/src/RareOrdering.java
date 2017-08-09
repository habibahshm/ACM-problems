import java.io.*;
import java.util.*;

public class RareOrdering {
	static ArrayList<String> input;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static Queue<Integer> topo;

	public static void dfs(int u) {
		if (visited[u])
			return;
		visited[u] = true;
		for (int i = 0; i < graph[u].size(); i++)
			dfs(graph[u].get(i));
		topo.add(u);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		TreeMap<Integer, Character> p = new TreeMap<Integer, Character>();
		int count = 0;
		input = new ArrayList();
		String o = bf.readLine();
		while (!o.equals("#")) {
			for (int i = 0; i < o.length(); i++) {
				char c = o.charAt(i);
				if (!tm.containsKey(c)) {
					tm.put(c, count);
					p.put(count, c);
					count++;
				}
			}
			input.add(o);
			o = bf.readLine();
		}

		graph = new ArrayList[count];
		for (int i = 0; i < count; i++)
			graph[i] = new ArrayList();

		visited = new boolean[count];
		topo = new LinkedList();

		for (int i = 0; i < input.size() - 1; i++) {
			String first = input.get(i);
			String second = input.get(i + 1);
			int min = Math.min(first.length(), second.length());
			for (int j = 0; j < min; j++) {
				if (first.charAt(j) != second.charAt(j)) {
					graph[tm.get(second.charAt(j))]
							.add(tm.get(first.charAt(j)));
					break;
				}
			}
		}

		for (int i = 0; i < count; i++) {
			if (!visited[i])
				dfs(i);
		}
		while (!topo.isEmpty())
			System.out.print(p.get(topo.poll()));
		System.out.println();
	}

}
