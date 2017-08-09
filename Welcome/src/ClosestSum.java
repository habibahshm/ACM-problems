import java.io.*;
import java.util.*;

public class ClosestSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		for (int t = 1; (n = Integer.parseInt(bf.readLine())) != 0; t++) {
			int[] ns = new int[n];
			for (int i = 0; i < n; i++)
				ns[i] = Integer.parseInt(bf.readLine());
			int m = Integer.parseInt(bf.readLine());
			System.out.println("Case " + t + ":");
			for (int k = 1; k <= m; k++) {
				int curr = Integer.parseInt(bf.readLine());
				int diff = Integer.MAX_VALUE;
				int ans = 0;
				for (int i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						int sum = ns[i] + ns[j];
						int a = Math.abs(curr - sum);
						if (a < diff) {
							diff = a;
							ans = sum;
						}
					}
				}
				System.out.println("Closest sum to " + curr + " is " + ans
						+ ".");
			}
		}
	}
}
