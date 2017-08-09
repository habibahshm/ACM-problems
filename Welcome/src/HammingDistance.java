import java.io.*;
import java.util.*;

public class HammingDistance {
	static int n;

	public static String binary(int x) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int digit = x % 2;
			sb.insert(0, digit);
			x /= 2;
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(bf.readLine());
		while (k-- > 0) {
			bf.readLine();
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for (int i = (1 << h) - 1; i <= ((1 << h) - 1)
					* (Math.pow(2, n - h)); i++) {
				int count = 0;
				for (int j = 0; j <= n; j++) {
					if ((i & (1 << j)) != 0)
						count++;
				}
				if (count == h)
					System.out.println(binary(i));

			}
			if (k > 0)
				System.out.println();
		}
	}
}
