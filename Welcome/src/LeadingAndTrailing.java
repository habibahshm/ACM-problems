import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeadingAndTrailing {
	static int bigMod(int a, int e, int mod) // O(log e)
	{
		a %= mod;
		int res = 1;
		while (e > 0) {
			if ((e & 1) == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			e >>= 1;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int trailing = bigMod(n, k, 1000);
			double p = k * Math.log10(n);
			double decimalPart = p - ((int) p);
			double c = Math.pow(10, decimalPart) * 100;
			int leading = (int) c;
			System.out.printf("%03d...%03d\n", leading , trailing);
		}
	}
}
