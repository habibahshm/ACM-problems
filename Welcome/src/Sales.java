import java.io.*;
import java.util.*;

public class Sales {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			int l = Integer.parseInt(bf.readLine());
			int[] a = new int[l];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; st.hasMoreTokens(); i++)
				a[i] = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int i = 0; i < l - 1; i++) {
				int count = 0;
				int ref = a[i + 1];
				for (int j = i; j >= 0; j--)
					if (a[j] <= ref)
						count++;

				sum += count;
			}
			System.out.println(sum);
		}
	}
}
