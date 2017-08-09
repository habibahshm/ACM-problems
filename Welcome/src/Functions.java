import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Functions {
	static int[][] comb;
	static long[] fact;
	static int mod = ((int) 1e9 + 7);
	static long[][] power;
	static long[][] f;

	public static void fact(int x) {
		fact = new long[x + 1];
		fact[0] = 1;
		for (int i = 1; i <= x; i++)
			fact[i] = i * fact[i - 1] % mod;

	}

	public static void power(int x, int y) {
		power = new long[x][y];
		for (int i = 1; i < x; i++) {
			power[i][0] = 1;
			for (int j = 1; j < y; j++)
				power[i][j] = i * power[i][j - 1] % mod;
		}
	}

	static void nCr2(int N) // O(N * N)
	{
		comb = new int[N][N];
		comb[0][0] = 1;
		for (int i = 1; i < N; i++) {
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++)
				comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod; // may
																			// use
																			// mod
		}
	}

	static void f(int x, int y) {
		f = new long[x][y];
		f[0][0] = 1;
		for (int i = 1; i < x; i++) {
			for (int j = 1; j < y; j++) {
				long tmp = 0;
				for (int k = 1; k <= i; k++) {
					long a = (1L * comb[i][k] * f[i - k][j - 1]) % mod;
					tmp = (tmp + a) % mod;
				}
				f[i][j] = tmp % mod;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		fact(1000);
		nCr2(1000 + 1);
		power(1001, 101);
		f(101, 1001);
		for (int c = 1; c <= t; c++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long bi = 0;

			for (int i = 1; i <= Math.min(x, y); i++) {
				long a = (1L * comb[y][i] * comb[x][i]) % mod;
				long b = (fact[i] % mod);
				long d = (a * b) % mod;
				bi = bi + (d % mod);
			}
			bi = bi % mod;
			long inj = 0;
			for (int j = 1; j <= y; j++) {
				long tmp = 0;
				for (int i = 1; i <= j; i++) {
					long r = (1L * comb[x][i] * comb[j][i]) % mod;
					long s = r * fact[i] % mod;
					tmp = tmp + s;
				}
				tmp = tmp % mod;
				long q = comb[y][j] * tmp % mod;
				inj = inj + q;
			}
			inj = inj % mod;
			long total = 0;
			for (int j = 1; j <= y; j++) {
				for (int i = 1; i <= x; i++) {
					long o = (1L * comb[x][i] * comb[y][j]) % mod;
					long o1 = o * power[j][i] % mod;
					total = (total + o1) % mod;
				}
			}
			total = total % mod;
			long sur = 0;
			for (int i = 1; i <= x; i++) {
				for (int j = 1; j <= y; j++) {
					long r1 = 1L * comb[y][j] * comb[x][i] % mod;
					long r2 = r1 * f[i][j] % mod;
					sur = (sur + r2) % mod;
				}
			}
			sur = sur % mod;
			System.out.println("Case " + c + ": " + inj + " " + sur + " " + bi + " " + total);
		}
	}
}
