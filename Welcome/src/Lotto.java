import java.util.*;
import java.io.*;

public class Lotto {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String x;
		int n = 0;
		while (!(x = bf.readLine()).equals("0")) {
			if (n == 0)
				n++;
			else
				System.out.println();
			st = new StringTokenizer(x);
			int k = Integer.parseInt(st.nextToken());
			int[] s = new int[k];
			for (int i = 0; i < k; i++)
				s[i] = Integer.parseInt(st.nextToken());
			for (int a = 0; a < k - 5; a++)
				for (int b = a + 1; b < k - 4; b++)
					for (int c = b + 1; c < k - 3; c++)
						for (int d = c + 1; d < k - 2; d++)
							for (int e = d + 1; e < k - 1; e++)
								for (int f = e + 1; f < k; f++)
									System.out.println(s[a] + " " + s[b] + " "
											+ s[c] + " " + s[d] + " " + s[e]
											+ " " + s[f]);
		}
	}
}
