import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Beverages {
	static ArrayList<Integer>[] adjlist;
	static int V;
	static ArrayList<Integer> sortedArray;

	public static void topo2() {
		int[] p = new int[V];
		for (int i = 0; i < V; i++)
			for (int v : adjlist[i])
				++p[v];
		PriorityQueue<Integer> roots = new PriorityQueue<Integer>();
		for (int i = 0; i < V; i++)
			if (p[i] == 0)
				roots.add(i);
		while (!roots.isEmpty()) {
			int u = roots.remove();
			sortedArray.add(u);
			for (int v : adjlist[u])
				if (--p[v] == 0)
					roots.add(v);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = 0;
		while (bf.ready()) {
			TreeMap<String, Integer> tm = new TreeMap<>();
			TreeMap<Integer, String> tm1 = new TreeMap<>();
			sortedArray = new ArrayList<Integer>();

			V = Integer.parseInt(bf.readLine());
			adjlist = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjlist[i] = new ArrayList<Integer>();

			for (int i = 0; i < V; i++) {
				String s = bf.readLine();
				tm.put(s, i);
				tm1.put(i, s);
			}

			int m = Integer.parseInt(bf.readLine());
			while (m-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int from = tm.get(st.nextToken());
				int to = tm.get(st.nextToken());
				adjlist[from].add(to);
			}

			System.out.print("Case #" + (++c) + ": Dilbert should drink beverages in this order: ");

			topo2();

			for (int i = 0; i < sortedArray.size(); i++) {
				if (i != V - 1)
					System.out.print(tm1.get(sortedArray.get(i)) + " ");
				else
					System.out.println(tm1.get(sortedArray.get(i)) + ".");
			}
			System.out.println();
			bf.readLine();
		}

	}
}
