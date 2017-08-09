import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheBridgesOfKolsberg {
	static Pair[] north;
	static Pair[] south;
	static IntPair[][] memo;
	static int ln;
	static int ls;

	static class Pair {
		String op;
		int val;

		public Pair(String o, int v) {
			op = o;
			val = v;
		}
	}

	public static class IntPair {
		int sum;
		int bridges;

		public IntPair(int s, int b) {
			sum = s;
			bridges = b;
		}

		public IntPair add(IntPair x) {
			return new IntPair(sum + x.sum, bridges + x.bridges);
		}

		public static IntPair max(IntPair p1, IntPair p2) {
			if (p1.sum == p2.sum)
				if (p1.bridges < p2.bridges)
					return p1;
				else
					return p2;
			else if (p1.sum > p2.sum)
				return p1;
			return p2;
		}
	}

		public static IntPair dp(int i, int j) {
			IntPair ans = new IntPair(0, 0);

			if (i == ln || j == ls)
				return ans;

			if (memo[i][j].sum != -1)
				return memo[i][j];

			if ((north[i].op).equals(south[j].op)) {
				IntPair a = dp(i + 1, j + 1);
				ans.sum += (north[i].val + south[j].val + a.sum);
				ans.bridges += (1 + a.bridges);
			}

			IntPair b = dp(i, j + 1);
			IntPair c = dp(i + 1, j);

			return memo[i][j] = IntPair.max(ans, IntPair.max(b, c));

		}

		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int n = Integer.parseInt(bf.readLine());
			while (n-- > 0) {
				ln = Integer.parseInt(bf.readLine());
				north = new Pair[ln];
				for (int i = 0; i < ln; i++) {
					st = new StringTokenizer(bf.readLine());
					st.nextToken();
					String op = st.nextToken();
					int val = Integer.parseInt(st.nextToken());
					north[i] = new Pair(op, val);
				}
				ls = Integer.parseInt(bf.readLine());
				south = new Pair[ls];
				for (int i = 0; i < ls; i++) {
					st = new StringTokenizer(bf.readLine());
					st.nextToken();
					String op = st.nextToken();
					int val = Integer.parseInt(st.nextToken());
					south[i] = new Pair(op, val);
				}
				memo = new IntPair[ln][ls];
				for (int i = 0; i < ln; i++)
					Arrays.fill(memo[i], new IntPair(-1, -1));
				IntPair ans = dp(0, 0);
				System.out.println(ans.sum + " " + ans.bridges);
			}
		}
	}

