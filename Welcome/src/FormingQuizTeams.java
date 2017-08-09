import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FormingQuizTeams {
	static int doublen;
	static double[] memo;
	static Pair[] locations;

	public static class Pair {
		int x;
		int y;

		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static double dist(int i, int j) {
		double xdist = locations[i].x - locations[j].x;
		double ydist = locations[i].y - locations[j].y;
		return Math.sqrt((xdist * xdist) +(ydist * ydist));
	}

	public static double dp(int mask) {
		if (mask == (1 << doublen) - 1)
			return 0;
        
		if (memo[mask] !=0)
			return memo[mask];

		double ans = 1e9;
		int p1, p2;

		for (p1 = 0; p1 < doublen; p1++)
			if ((mask & (1 << p1)) == 0)
				break;

		for (p2 = p1 + 1; p2 < doublen; p2++) {
			if ((mask & (1 << p2)) == 0)
				ans = Math.min(ans, dist(p1, p2) + dp(mask | (1 << p1) | (1 << p2)));

		}
		return memo[mask] = ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		for (int j=1; (n=Integer.parseInt(bf.readLine()))!=0; j++) {
			doublen = n * 2;
			locations = new Pair[doublen];
			for (int i = 0; i < doublen; i++) {
				st = new StringTokenizer(bf.readLine());
				st.nextToken();
				locations[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			memo = new double[(1<<doublen)];
			System.out.printf("Case %d: %.2f%n",j,dp(0));
		}
	}
}
