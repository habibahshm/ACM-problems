import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*let's assume en R = 3 and C = 3, so there are 9 cells in the grid and so we would need 9 bits to represent them so we
 *need R * C bits to represent our board (here R and C <= 4), now to actually represent a cell, each cell must 
 *have a unique bit to represent it
if this is our grid number from 0 to 8
0 1 2
3 4 5
6 7 8
we can see that each cell has a unique number and we can use those numbers as positions for our bitmask, 
but we will need a formula to get this number, for each cell we have the row and column (0 based) formula 
would be row * MAX_ROW + column
in the first row (row 0), at column (0) we have a blob, we need to set (row * MAX_ROW + column)th bit on hence we get 000000001, 
then same row, column 1 we also have a blob, we do the same and set the 2nd LSB on and we end up with 000000011 and so on*/

/*Consider a grid having the dimensions R and C. number all cells from top to bottom and from left to right from 0 till R * C - 1
0  1  2  3
4  5  6  7
8  9 10 11
This is an example for R = 3, C = 4. So cell (0, 0) has value 0, cell (2, 2) has the value 10. cell (x, y) has the value x * C + y. 
having a 2D id can be mapped to 1D id using this function (x, y) => cell = x * C + y. cell => (x / C, x % C)*/
public class BlobsInTheBoard {
	static int R;
	static int C;
	static int N;
	static int[][][] memo;
	static int[] destinationx = { -2, 2, 0, 0, -2, 2, -2, 2 };
	static int[] destinationy = { 0, 0, -2, 2, -2, 2, 2, -2 };
	static int[] transtionx = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] transtiony = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static int function(int x, int y) {
		return x * C + y;
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	public static int dp(int mask) {
		int blobs = Integer.bitCount(mask);
		int steps = N - blobs;

		if (blobs == 1 && steps == N - 1)
			return 1;

		if (memo[R][C][mask] != -1)
			return memo[R][C][mask];

		int ans = 0;
		for (int i = 0; i <= (R * C); i++) {
			if ((mask & (1 << i)) != 0) {
				for (int j = 0; j < 8; j++) {
					int t, d;
					if (isValid((i / C) + transtionx[j], (i % C) + transtiony[j])
							&& isValid((i / C) + destinationx[j], (i % C) + destinationy[j])) {
						t = function((i / C) + transtionx[j], (i % C) + transtiony[j]);
						d = function((i / C) + destinationx[j], (i % C) + destinationy[j]);
						if (((mask & (1 << t)) != 0) & ((mask & (1 << d)) == 0))
							ans += (dp(((mask ^ (1 << i)) ^ (1 << t)) ^ (1 << d)));
					}
				}
			}
		}

		return memo[R][C][mask] = ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		memo = new int[5][5][1 << 16];
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				Arrays.fill(memo[i][j], -1);

		int t = Integer.parseInt(bf.readLine());

		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(bf.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int n = N;
			int mask = 0;
			while (n-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int a = function(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
				mask |= (1 << a);
			}

			System.out.println("Case " + i + ": " + dp(mask));
		}
	}
}
