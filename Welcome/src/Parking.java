import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Parking {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			int l = Integer.parseInt(bf.readLine());
			int min = 100;
			int max = -1;
			st = new StringTokenizer(bf.readLine());
			while (st.hasMoreTokens()) {
				int p = Integer.parseInt(st.nextToken());
				min = Math.min(p, min);
				max = Math.max(p, max);
			}
			System.out.println((max-min)*2);
		}
	}
}
