import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Compromise {
	static ArrayList<String> a;
	static ArrayList<String> b;
	static int[][] memo;
	static String ans;

	static int LCS(int i, int j) {
		if (i == a.size() || j == b.size())
			return memo[i][j] = 0;

		if (memo[i][j] != -1)
			return memo[i][j];

		if (a.get(i).equals(b.get(j)))
			return memo[i][j] = 1 + LCS(i + 1, j + 1);

		int skip1 = LCS(i, j + 1);
		int skip2 = LCS(i + 1, j);

		return memo[i][j] = Math.max(skip1, skip2);
	}

	public static void print(int i, int j) {
		if (i == a.size() || j == b.size())
			return;

		if (a.get(i).equals(b.get(j))) {
			ans += (a.get(i) + " ");
			print(i + 1, j + 1);
		} else if (memo[i][j + 1] > memo[i + 1][j])
			print(i, j + 1);
		else
			print(i + 1, j);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (bf.ready()) {
			a = new ArrayList<>();
			b = new ArrayList<>();
			String s;
			StringTokenizer st;
			while (!(s = bf.readLine()).equals("#")) {
				st = new StringTokenizer(s);
				while (st.hasMoreTokens())
					a.add(st.nextToken());
			}
			while (!(s = bf.readLine()).equals("#")) {
				st = new StringTokenizer(s);
				while (st.hasMoreTokens())
					b.add(st.nextToken());
			}
			ans = "";
			memo = new int[a.size() + 1][b.size() + 1];
			for (int i = 0; i <= a.size(); i++)
				Arrays.fill(memo[i], -1);

			LCS(0, 0);
			print(0, 0);
			for (int i = 0; i < ans.length() - 1; i++)
				System.out.print(ans.charAt(i));
			System.out.println();
		}
	}
}
