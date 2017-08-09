import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheTwinTowers {
	static int[] t1;
	static int[] t2;
	static int[][] memo;
	static int n1, n2;

	static int LCS(int i, int j) {
		if (i == n1 || j == n2)
			return 0;

		if (memo[i][j] != -1)
			return memo[i][j];

		if (t1[i] == t2[j])
			return memo[i][j] = 1 + LCS(i + 1, j + 1);

		int skip1 = LCS(i, j + 1);
		int skip2 = LCS(i + 1, j);

		return memo[i][j] = Math.max(skip1, skip2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s;
		for (int c = 1; !(s = bf.readLine()).equals("0 0"); c++) {
			StringTokenizer st = new StringTokenizer(s);
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			t1 = new int[n1];
			t2 = new int[n2];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; st.hasMoreTokens(); i++)
				t1[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; st.hasMoreTokens(); i++)
				t2[i] = Integer.parseInt(st.nextToken());
			memo = new int[n1][n2];
			for (int i = 0; i < n1; i++)
				Arrays.fill(memo[i], -1);
			System.out.println("Twin Towers #" + c);
			System.out.println("Number of Tiles : " + LCS(0, 0));
			System.out.println();

		}
	}
}
