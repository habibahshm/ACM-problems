import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RankList {
	static Pair[] ranks;

	public static class Pair implements Comparable<Pair> {
		int p;
		int t;

		public Pair(int problems, int penalty) {
			p = problems;
			t = penalty;
		}

		public int compareTo(Pair o) {
			if (this.p != o.p)
				return o.p - this.p;
			if (this.t != o.t)
				return this.t - o.t;
			return 0;
		}

	}

	public static int BSfindFirst(int start, int end, Pair t) {
		while (start < end) {

			int mid = start + ((end - start) / 2);
			if (ranks[mid].compareTo(t) < 0) {
				start = mid + 1;
			} else if (ranks[mid].compareTo(t) > 0) {
				end = mid - 1;
			} else
				end = mid;
		}

		return start;
	}

	public static int BSfindLast(int start, int end, Pair t) {
		while (start < end) {
			int mid = start + ((end - start + 1) / 2);
			if (ranks[mid].compareTo(t) < 0)
				start = mid + 1;
			else if (ranks[mid].compareTo(t) > 0)
				end = mid - 1;
			else
				start = mid;
		}

		return start;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ranks = new Pair[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			ranks[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(ranks);
		Pair target = ranks[k - 1];
		int start = BSfindFirst(0, n - 1, target);
		int end = BSfindLast(0, n - 1, target);
		//System.out.println("finally " + start + " " + end);
		System.out.println((end - start) + 1);
	}
}
