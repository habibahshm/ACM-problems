import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Luggage {
	static int w[], l, dp[][][];

	public static boolean state(int idx, int car1, int car2) {
		if (idx == l) {
			if (car1 == car2)
				return true;
			return false;
		}
		if (dp[idx][car1][car2] != -1) {
			if (dp[idx][car1][car2] == 1)
				return true;
			return false;
		}
		boolean ans = state(idx + 1, car1 + w[idx], car2)
				|| state(idx + 1, car1, car2 + w[idx]);

		if (ans)
			dp[idx][car1][car2] = dp[idx][car2][car1] = 1;
		else
			dp[idx][car1][car2] = dp[idx][car2][car1] = 0;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m = Integer.parseInt(bf.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(bf.readLine());
			l = st.countTokens();
			w = new int[l];
			for (int i = 0; st.hasMoreTokens(); i++)
				w[i] = Integer.parseInt(st.nextToken());
			dp = new int[l][201][201];
			for (int i = 0; i < l; i++)
				for (int j = 0; j < 201; j++)
					Arrays.fill(dp[i][j], -1);
			if(state(0, 0, 0))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
