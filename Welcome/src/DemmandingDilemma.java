import java.io.*;
import java.util.*;

public class DemmandingDilemma {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[n][m];
			boolean[][] connected = new boolean[n][n];

			if (m != 0)
				for (int i = 0; i < n; i++) {
					st = new StringTokenizer(bf.readLine());
					for (int j = 0; j < m; j++) {
						matrix[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			boolean inst = true;
			for (int j = 0; j < m; j++) {
				int count = 0;
				String c = "";
				for (int i = 0; i < n; i++) {
					if (matrix[i][j] == 1) {
						count++;
						c += i;
					}
				}
				if (count != 2) {
					inst = false;
					break;
				}
				int a = Integer.parseInt(c.charAt(0) + "");
				int b = Integer.parseInt(c.charAt(1) + "");
				if (connected[a][b]) {
					inst = false;
					break;
				} else
					connected[a][b] = connected[b][a] = true;

			}
			if (inst)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
