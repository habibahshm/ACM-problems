import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XeniaandBitOperations {
	static class SegmentTree {
		int N;
		int[] sTree, array;
		int treeheight;

		static int log(int N) {
			int ans = 0;
			for (int i = 1; (1 << i) <= N; i++) {
				ans++;
			}
			return ans;
		}

		public SegmentTree(int[] n) {
			array = n;
			N = n.length - 1;
			sTree = new int[2 * N];
			treeheight = log(sTree.length);
			build(1, 1, N);
		}

		void build(int node, int b, int e) {
			if (b == e) {
				sTree[node] = array[b];
				return;
			}
			int mid = b + e >> 1;
			build(node << 1, b, mid);
			build(node << 1 | 1, mid + 1, e);
			int lvl = log(node);
			if (treeheight % 2 == lvl % 2)
				sTree[node] = sTree[node << 1] | sTree[node << 1 | 1];
			else
				sTree[node] = sTree[node << 1] ^ sTree[node << 1 | 1];
		}

		void update_point(int index, int val) // O(log n)
		{
			index += N - 1;
			sTree[index] = val;
			while (index > 1) {
				index >>= 1;
				int lvl = log(index);
				if (treeheight % 2 == lvl % 2)
					sTree[index] = sTree[index << 1] | sTree[index << 1 | 1];
				else
					sTree[index] = sTree[index << 1] ^ sTree[index << 1 | 1];
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] in = new int[(1 << n) + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= (1 << n); i++)
			in[i] = Integer.parseInt(st.nextToken());
		SegmentTree s = new SegmentTree(in);
		while (m-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			s.update_point(idx, val);
			System.out.println(s.sTree[1]);
		}

	}
}


