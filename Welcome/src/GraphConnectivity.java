
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;




public class GraphConnectivity {
	static class DisjointSets {
		int[] representitves;
		int[] rank;

		public DisjointSets(int n) {
			representitves = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++)
				representitves[i] = i;
			Arrays.fill(rank, 1);
		}

		int findRepresentitve(int x) {
			if (representitves[x] == x)
				return x;
			return representitves[x] = findRepresentitve(representitves[x]);
		}

		void union(int x, int y) {
			int x1 = findRepresentitve(x);
			int y1 = findRepresentitve(y);
			if (x1 != y1) {
				if (rank[x1] > rank[y1]) {
					representitves[y1] = x1;
				} else {
					if (rank[y1] > rank[x1]) {
						representitves[x1] = y1;
					} else {
						representitves[x1] = y1;
						rank[y1]++;
					}

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (n-- > 0) {
			TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
			char heighest = bf.readLine().charAt(0);
			DisjointSets ds = new DisjointSets(heighest - 'A' + 1);
			String o;
			int i = 0;
			while ((o = bf.readLine()) != null && o.length() > 0) {
				char source = o.charAt(0);
				char dest = o.charAt(1);
				if (!tm.containsKey(source)) {
					tm.put(source, i);
					i++;
				}
				if (!tm.containsKey(dest)) {
					tm.put(dest, i);
					i++;
				}
				ds.union(tm.get(source), tm.get(dest));
			}
			int count = 0;
			for (int j = 0; j < ds.representitves.length; j++) {
				if (ds.representitves[j] == j)
					count++;
			}
			System.out.println(count);
			if (n != 0)
				System.out.println();

		}
	}
}
