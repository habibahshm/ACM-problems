import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boxes {
	static int w[], ml[], n, dp[][];

	public static int state(int idx, int load) {
		if (load < 0)
			return -100000;
		if (idx == n || load == 0)
			return 0;
		if (dp[idx][load] != -1)
			return dp[idx][load];
		int take = 1 + state(idx + 1, Math.min(ml[idx], load - w[idx]));
		int leave = state(idx + 1, load);
		return dp[idx][load] = Math.max(take, leave);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			w = new int[n];
			ml = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				ml[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[n][6001];
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], -1);
			int ans = state(0, 6000);
			System.out.println(ans);
		}
	}
}
