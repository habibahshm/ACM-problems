import java.io.*;
import java.util.*;

public class Nature {
	static class DisjointSets {
		int[] representitves;
		int[] rank;
		int[] size;

		public DisjointSets(int n) {
			representitves = new int[n];
			rank = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				representitves[i] = i;
			}
			Arrays.fill(rank, 1);
			Arrays.fill(size, 1);
		}

		int findSet(int x) {
			if (representitves[x] == x)
				return x;
			return representitves[x] = findSet(representitves[x]);
		}

		void union(int x, int y) {
			int x1 = findSet(x);
			int y1 = findSet(y);
			if (x1 != y1)
				if (rank[x1] > rank[y1]) {
					representitves[y1] = x1;
					int sum = size[x1] + size[y1];
					size[x1] = sum;
				} else if (rank[y1] > rank[x1]) {
					representitves[x1] = y1;
					int sum = size[x1] + size[y1];
					size[y1] = sum;
				} else {
					representitves[x1] = y1;
					rank[y1]++;
					int sum = size[x1] + size[y1];
					size[y1] = sum;
				}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String n = bf.readLine();
			StringTokenizer st = new StringTokenizer(n);
			int c = Integer.parseInt(st.nextToken());
			if (c == 0)
				break;
			int r = Integer.parseInt(st.nextToken());
			TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
			for (int i = 0; i < c; i++) {
				tm.put(bf.readLine(), i);
			}
			DisjointSets ds = new DisjointSets(c);
			while (r > 0) {
				String s = bf.readLine();
				StringTokenizer sk = new StringTokenizer(s);
				String s1 = sk.nextToken();
				String s2 = sk.nextToken();
				int y = tm.get(s1);
				int x = tm.get(s2);
				ds.union(x, y);
				r--;
			}
			int max_size = Integer.MIN_VALUE;
			for (int i = 0; i < c; i++) {
				max_size = Math.max(ds.size[i], max_size);

			}
			System.out.println(max_size);
			String trash = bf.readLine();
		}
	}
}
