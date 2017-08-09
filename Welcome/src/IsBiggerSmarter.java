import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IsBiggerSmarter {
	static ArrayList<Triple> e;
	static int[][] memo;
	
	static class Triple implements Comparable<Triple> {
		int w;
		int iq;
		int idx;

		public Triple(int a, int b, int c) {
			w = a;
			iq = b;
			idx = c;
		}

		@Override
		public int compareTo(Triple o) {
			if (w != o.w)
				return w - o.w;
			return o.iq - iq;
		}

		public String toString() {
			return w + " " + iq + " " + idx;
		}
	}

	static int LDS(int idx, int prev, int prevW) {
		if (idx == e.size())
			return 0;

		if (memo[idx][prev] != -1)
			return memo[idx][prev];

		int leave = LDS(idx + 1, prev, prevW);
		int take = 0;
		if (prev > e.get(idx).iq && prevW != e.get(idx).w)
			take = LDS(idx + 1, e.get(idx).iq, e.get(idx).w) + 1;

		return memo[idx][prev] = Math.max(take, leave);
	}

	static void print(int idx, int prev) {
		if (idx == e.size())
			return;
		int best = memo[idx][prev];
		if (best == memo[idx + 1][e.get(idx).iq] + 1) {
			System.out.println(e.get(idx).idx);
			print(idx + 1, e.get(idx).iq);
		} else
			print(idx + 1, prev);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		e = new ArrayList<>();
		StringTokenizer st;
		int i = 1;
		int max = 0;
		while (bf.ready()) {
			st = new StringTokenizer(bf.readLine());
			int w = Integer.parseInt(st.nextToken());
			int iq = Integer.parseInt(st.nextToken());
			max = Math.max(max, iq);
			e.add(new Triple(w, iq, i++));
		}
		e.sort(null);
		
		memo = new int[e.size() + 1][max + 2];
		for (int j = 0; j < e.size(); j++)
			Arrays.fill(memo[j], -1);
		Arrays.fill(memo[e.size()], 0);
		
		System.out.println(LDS(0, max + 1, 0));
		print(0, max + 1);
	}

}
