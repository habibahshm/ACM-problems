import java.io.*;
import java.util.*;

public class QueensChess {
	static int[] row = new int[8];
	static int a;
	static int b;
	static int linecounter;

	public static boolean ok(int r, int c) {
		for (int i = 0; i < c; i++)
			if (row[i] == r || Math.abs(row[i] - r) == Math.abs(c - i))
				return false;
		return true;
	}

	public static void backtrack(int c) {
		if (c == 8 && row[b] == a) {
			System.out.printf("%2d      %d", ++linecounter, row[0] + 1);
			for (int j = 1; j < 8; j++)
				System.out.print(" " + (row[j] + 1));
			System.out.println();
		}
		for (int r = 0; r < 8; r++) {
			if (ok(r, c)) {
				row[c] = r;
				backtrack(c + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			bf.readLine();
			st = new StringTokenizer(bf.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			linecounter = 0;
			System.out.println("SOLN       COLUMN");
			System.out.println(" #      1 2 3 4 5 6 7 8");
			System.out.println();
			backtrack(0);
			if(n>0)
			System.out.println();
		}
	}
}
