import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KefaandPark {
	static ArrayList<Integer>[] adjlist;
	static int[] cats;
	static int m;
	static int ans;

	public static void dfs(int node, int p, int consec) {
		boolean leaf = true;
		
		if(consec >m)
			return;

		for (int v : adjlist[node]) {
			if (v != p) {
				if (cats[v] == 1)
					dfs(v, node, consec + 1);
				else
					dfs(v, node, 0);
				leaf = false;
			}
			
		}
		if (leaf && consec <= m)
			ans++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cats = new int[n + 1];
		adjlist = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			adjlist[i] = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++)
			cats[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjlist[from].add(to);
			adjlist[to].add(from);
		}
		ans = 0;
		dfs(1, 0, cats[1]);
		System.out.println(ans);
	}
}
