import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Divisibility {
	public static int[] seq;
	public static int k;
	static int dp[][];

	public static int isDiv(int modSum, int idx) {
		if (idx == seq.length) {
			if (modSum % k == 0)
				return 1;
			return 0;
		}
		if (dp[modSum][idx] != -1)
			return dp[modSum][idx];

		return dp[modSum][idx] = isDiv(fix(modSum + seq[idx]), idx + 1) | isDiv(fix(modSum - seq[idx]), idx + 1);

	}

	public static int fix(int x) {
		return ((x % k) + k) % k;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m = Integer.parseInt(bf.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			dp = new int[k][n];
			for (int i = 0; i < k; i++)
				Arrays.fill(dp[i], -1);
			seq = new int[n];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++)
				seq[i] = Integer.parseInt(st.nextToken());
			if (isDiv(fix(seq[0]), 1) == 1)
				System.out.println("Divisible");
			else
				System.out.println("Not divisible");
		}
	}
}
