import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoButtons {
	static ArrayList<Integer>[] adjlist;
	static int[] distance;

	public static void bfs(int s) {
		Queue<Integer> layer = new LinkedList<Integer>();
		Arrays.fill(distance, -1);
		distance[s] = 0;
		layer.add(s);
		while (!layer.isEmpty()) {
			int u = layer.poll();
			for (int i = 0; i < adjlist[u].size(); i++) {
				int v = adjlist[u].get(i);
				if (distance[v] == -1) {
					distance[v] = distance[u] + 1;
					layer.add(v);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = Math.max(m, n);

		adjlist = new ArrayList[max * 4 + 1];
		for (int i = 0; i < max * 4 + 1; i++)
			adjlist[i] = new ArrayList<>();
		for (int i = 1; i < max*2 + 1; i++) {
			int red = i * 2;
			int blue = i - 1;
			adjlist[i].add(red);
			adjlist[i].add(blue);

		}
		distance = new int[max * 4 + 1];

		bfs(n);
		System.out.println(distance[m]);
	}
}
