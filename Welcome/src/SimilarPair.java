import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SimilarPair {
	static ArrayList<Integer>[] adjlist;
	static int t;
	static SegmentTree s;

	public static class SegmentTree { // 1-based DS, OOP

		int N; // the number of elements in the array as a power of 2 (i.e.
				// after padding)
		int[] sTree;

		SegmentTree(int in) {
			int N = 1;
			while (N < in)
				N <<= 1; // padding
			N--;
			sTree = new int[N << 1]; // no. of nodes = 2*N - 1, we add one to
										// cross out index zero
		}

		void update_point(int index) // O(log n)
		{
			index += N - 1;
			sTree[index] ^= 1;
			while (index > 1) {
				index >>= 1;
				sTree[index] = sTree[index << 1] + sTree[(index << 1) + 1];
			}
		}

		int query(int node, int b, int e, int i, int j) // O(log n)
		{
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return sTree[node];
			int q1 = query(node << 1, b, (b + e) / 2, i, j);
			int q2 = query((node << 1) + 1, (b + e) / 2 + 1, e, i, j);
			return q1 + q2;

		}

	}

	public static long dfs(int u, int p) {
		s.update_point(u);
		int ancestors = 0;
		for (int i = 0; i < adjlist[u].size(); i++) {
			int v = adjlist[u].get(i);
			if (v != p) {
				int l = u - t;
				int r = u + t;
				ancestors = s.query(1, 1, s.N, l, r);
				ancestors += dfs(v, u);
			}

		}
		s.update_point(u);
		return ancestors;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		adjlist = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			adjlist[i] = new ArrayList<Integer>();
		boolean[] isRoot = new boolean[n + 1];
		Arrays.fill(isRoot, true);
		int e = n - 1;
		while (e-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjlist[from].add(to);
			adjlist[to].add(from);
			isRoot[to] = false;
		}
		int root = 0;
		for (int i = 1; i <= n; i++) {
			if (isRoot[i])
				root = i + 1;
		}
		s = new SegmentTree(n);
		System.out.println(dfs(root, -1));
	}
}
