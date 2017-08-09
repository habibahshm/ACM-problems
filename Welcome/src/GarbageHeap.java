import java.io.*;
import java.util.*;

public class GarbageHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a;
		int b;
		int c;
		int[][][] cube;
		int[][][] B;
		int n = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			cube = new int[a][b][c];
			B = new int[a][b][c];
			boolean all_negative = true;
			st = new StringTokenizer(bf.readLine());
			int max_neg = -10 ^ 6;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					for (int k = 0; k < c; k++) {
						cube[i][j][k] = Integer.parseInt(st.nextToken());
						if (cube[i][j][k] > 0)
							all_negative = false;
						B[i][j][k] = cube[i][j][k];
						if (k > 0)
							B[i][j][k] += B[i][j][k - 1];
						if (all_negative)
							max_neg = Math.max(max_neg, cube[i][j][k]);
					}
				}
			}

			if (!all_negative) {
				int max = -10 ^ 6;
				for (int j = 0; j < c; j++) {
					for (int k = j; k < c; k++) {
						int sum = 0;
						for (int row = 0; row < b; row++) {
							for (int i = 0; i < a; i++) {
								if (j > 0)
									sum += B[i][row][k] - B[i][row][j - 1];
								else
									sum += B[i][row][k];

								if (sum < 0)
									sum = 0;

								max = Math.max(sum, max);
							}
						}
					}
				}
				System.out.println(max);
			} else
				System.out.println(max_neg);

		}
	}
}
