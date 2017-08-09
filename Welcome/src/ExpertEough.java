import java.io.*;
import java.util.*;

public class ExpertEough {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		TreeMap tm = new TreeMap<Integer, String>();
		while (n-- > 0) {
			int d = Integer.parseInt(bf.readLine());
			int[][] database = new int[d][2];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(bf.readLine());
				tm.put(i, st.nextToken());
				database[i][0] = Integer.parseInt(st.nextToken());
				database[i][1] = Integer.parseInt(st.nextToken());
			}
			int q = Integer.parseInt(bf.readLine());
			while (q-- > 0) {
				int p = Integer.parseInt(bf.readLine());
				int count = 0;
				int idx = -1;
				for (int i = 0; i < d; i++)
					if (p >= database[i][0] && p <= database[i][1]) {
						count++;
						idx = i;
					}
				if (count == 1)
					System.out.println(tm.get(idx));
				else
					System.out.println("UNDETERMINED");
			}
			if (n > 0)
				System.out.println();
		}
	}
}
