import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MontescoVsCapuleto {
	static ArrayList<Integer>[] adjlist;
	static int[] color;
	static boolean isBipartite;
	static int zeroes, ones;

	public static void bipartiteCheck(int s) {
		Queue<Integer> layer = new LinkedList<Integer>();
		color[s] = 0;
		zeroes = 1;
		ones = 0;
		isBipartite = true;
		layer.add(s);
		while (!layer.isEmpty()) {
			int u = layer.poll();
			for (int i = 0; i < adjlist[u].size(); i++) {
				int v = adjlist[u].get(i);
				if (color[v] == -1) {
					color[v] = color[u] ^ 1;
					if (color[v] == 1)
						ones++;
					else
						zeroes++;
					layer.add(v);
				} else if (color[v] == color[u]) 
					isBipartite = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			bf.readLine();
			int v = Integer.parseInt(bf.readLine());
			color = new int[v + 1];
			Arrays.fill(color, -1);
			adjlist = new ArrayList[v + 1];
			for (int i = 0; i < v + 1; i++)
				adjlist[i] = new ArrayList<Integer>();
			for (int k = 1; k <= v; k++) {
				st = new StringTokenizer(bf.readLine());
				int enimies = Integer.parseInt(st.nextToken());
				while (enimies-- > 0) {
					int x = Integer.parseInt(st.nextToken());
					if (x <= v) {
						adjlist[k].add(x);
						adjlist[x].add(k);
					}
				}
			}
			int ans = 0;
			for (int i = 1; i < v + 1; i++) {
				if (color[i] == -1) {
					bipartiteCheck(i);
					if (!isBipartite)
						zeroes = ones = 0;
					ans += Math.max(zeroes, ones);
				}
			}
			System.out.println(ans);
		}
	}
}
