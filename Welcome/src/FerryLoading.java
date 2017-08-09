import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FerryLoading {
	static int[] cars;
	static int[][] memo;
	static int i;

	public static int dp(int idx, int leftRem, int rightRem) {
		if (idx == i)
			return 0;

		if (memo[idx][leftRem] != -1)
			return memo[idx][leftRem];

		int left = 0;
		int right = 0;

		if (cars[idx] <= leftRem)
			left = 1 + dp(idx + 1, leftRem - cars[idx], rightRem);

		if (cars[idx] <= rightRem)
			right = 1 + dp(idx + 1, leftRem, rightRem - cars[idx]);

		return memo[idx][leftRem] = Math.max(left, right);
	}

	public static void print(int idx, int leftRem, int rightRem) {
		if (idx == i)
			return;
		int optimal = dp(idx, leftRem, rightRem);
		if (cars[idx] <= leftRem) {
			int left = 1 + dp(idx + 1, leftRem - cars[idx], rightRem);
			if (optimal == left) {
				System.out.println("port");
				print(idx + 1, leftRem - cars[idx], rightRem);
				return;
			}
		}
		if (cars[idx] <= rightRem) {
			int right = 1 + dp(idx + 1, leftRem, rightRem - cars[idx]);
			if (optimal == right) {
				System.out.println("starboard");
				print(idx + 1, leftRem, rightRem - cars[idx]);
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			bf.readLine();
			int l = Integer.parseInt(bf.readLine()) * 100;
			cars = new int[500];
			int cur;
			for (i = 0; (cur = Integer.parseInt(bf.readLine())) != 0; i++)
				cars[i] = cur;
			memo = new int[i][l + 1];
			for (int j = 0; j < i; j++)
				Arrays.fill(memo[j], -1);
			System.out.println(dp(0, l, l));
			print(0, l, l);
			if (n > 0)
				System.out.println();

		}
	}
}
