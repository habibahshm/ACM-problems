import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubPrime {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		while (!(s = bf.readLine()).equals("0 0")) {
			st = new StringTokenizer(s);
			int b = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] m = new int[b + 1];
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i < b + 1; i++)
				m[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				int d = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				m[d] -= v;
				m[c] += v;
			}
			boolean possible = true;
			for (int i = 1; i < b + 1; i++)
				if (m[i] < 0)
					possible = false;
			if (possible)
				System.out.println("S");
			else
				System.out.println("N");
		}
	}
}
