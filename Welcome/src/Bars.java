import java.io.*;
import java.util.*;

public class Bars {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			int target = Integer.parseInt(bf.readLine());
			int l = Integer.parseInt(bf.readLine());
			int[] bars = new int[l];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < l; i++)
				bars[i] = Integer.parseInt(st.nextToken());
			boolean possible = false;
			for (int bitmask = 0; bitmask < (1 << l); bitmask++) {
				int sum = 0;
				for (int j = 0; j < l; j++) {
					if ((bitmask & (1 << j)) != 0)
						sum += bars[j];
				}
				if (sum == target) {
					possible = true;
					break;
				}
			}
			if (possible)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
