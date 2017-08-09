import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LearningLanguages {
	static ArrayList<Integer>[] adjlist;
	static ArrayList<Integer>[] speakers;
	static boolean[] visited;

	public static void dfs(int u) {
		visited[u] = true;
		for (int v : adjlist[u]) {
			if (!visited[v])
				dfs(v);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		adjlist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();
		int m = Integer.parseInt(st.nextToken());
		speakers = new ArrayList[m + 1];
		for (int i = 0; i < m + 1; i++)
			speakers[i] = new ArrayList<>();
		int gahla = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int lang = Integer.parseInt(st.nextToken());
			if (lang == 0)
				gahla++;
			while (lang-- > 0) {
				int currlang = Integer.parseInt(st.nextToken());
				for (int e : speakers[currlang]) {
					adjlist[i].add(e);
					adjlist[e].add(i);
				}
				speakers[currlang].add(i);
			}
		}
		int cc = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i);
				cc++;
			}
		}
		if (gahla == n)
			System.out.println(cc);
		else
			System.out.println(cc - 1);

	}
}
