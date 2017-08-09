import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pSort {
	static int[] r, rank, setSize;
	static int numSets;

	public static void UnionFind(int N) {
		r = new int[N];
		rank = new int[N];
		setSize = new int[N];
		numSets = N;
		for (int i = 0; i < N; i++) {
			r[i] = i;
			setSize[i] = 1;
		}
	}

	public static int findSet(int i) {
		if (r[i] == i)
			return i;
		else
			return r[i] = findSet(r[i]); // path compression
	}

	public static Boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}

	public static void unionSet(int i, int j) {
		if (isSameSet(i, j))
			return;
		numSets--;
		int x = findSet(i), y = findSet(j);
		// rank is used to keep the tree short
		if (rank[x] > rank[y]) {
			r[y] = x;
			setSize[x] += setSize[y];
		} else {
			r[x] = y;
			setSize[y] += setSize[x];
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}

	public static int numDisjointSets() {
		return numSets;
	}

	public static int sizeOfSet(int i) {
		return setSize[findSet(i)];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		UnionFind(n + 1);
		int[] p = new int[n + 1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++)
			p[i] = Integer.parseInt(st.nextToken());
		int[] fav = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++)
			fav[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (Math.abs(j - i) == fav[i])
					unionSet(i, j);
			}
		}
		boolean reachable = true;
		for (int i = 1; i <= n; i++) {
			if (!isSameSet(i, p[i])) {
				reachable = false;
				break;
			}
		}
		if (reachable)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
