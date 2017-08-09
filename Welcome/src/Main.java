
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static class SegmentTree {
		int N; // the number of elements in the array as a power of 2 (i.e.
				// after padding)
		int[] array, sTree, lazy;

		SegmentTree(int[] in) {
			array = in;
			N = in.length - 1;
			sTree = new int[N << 1]; // no. of nodes = 2*N - 1, we add one to
										// cross out index zero
			lazy = new int[N << 1];
			build(1, 1, N);
		}

		void build(int node, int b, int e) // O(n)
		{
			if (b == e)
				sTree[node] = array[b];
			else {
				int mid = b + e >> 1;
				build(node << 1, b, mid);
				build(node << 1 | 1, mid + 1, e);
				sTree[node] = sTree[node << 1] * sTree[node << 1 | 1];
			}
		}

		void update_point(int index, int val) // O(log n)
		{
			index += N - 1;
			sTree[index] = val;
			while (index > 1) {
				index >>= 1;
				sTree[index] = sTree[index << 1] * sTree[index << 1 | 1];
			}
		}

		int query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		int query(int node, int b, int e, int i, int j) // O(log n)
		{
			if (i > e || j < b)
				return 1;
			if (b >= i && e <= j)
				return sTree[node];
			int mid = b + e >> 1;
			int q1 = query(node << 1, b, mid, i, j);
			int q2 = query(node << 1 | 1, mid + 1, e, i, j);
			return q1 * q2;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (bf.ready()) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int N = 1;
			while (N < n)
				N <<= 1;
			int in[] = new int[N + 1];
			Arrays.fill(in, 1);
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= n; i++) {
				int x = Integer.parseInt(st.nextToken());
				if (x != 0)
					in[i] = x / Math.abs(x);
				else
					in[i] = x;
			}
			SegmentTree t = new SegmentTree(in);
			while (k-- > 0) {
				st = new StringTokenizer(bf.readLine());
				char comm = st.nextToken().charAt(0);
				int indx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				if (comm == 'C') {
					if (val != 0)
						val /= Math.abs(val);
					t.update_point(indx, val);

				} else {
					int tmp = t.query(indx, val);
					out.print(tmp > 0 ? "+" : tmp < 0 ? "-" : "0");
				}
			}
			out.println();
		}
		out.flush();
		out.close();
	}

}
