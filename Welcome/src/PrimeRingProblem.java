import java.io.*;
import java.util.*;

import javax.annotation.processing.SupportedSourceVersion;

public class PrimeRingProblem {
	static int n;
	static int[] s;
	static PrintWriter pw;

	public static boolean isPrime(int x) {
		if (x == 1)
			return true;
		for (int i = 2; i < x; i++)
			if (x % i == 0)
				return false;
		return true;
	}

	public static boolean ok(int num, int idx) {
		boolean[] a = new boolean[n + 1];
		a[num] = true;
		boolean unique = true;
		for (int i = 0; i < idx; i++) {
			if (a[s[i]]) {
				unique = false;
				break;
			} else
				a[s[i]] = true;
		}
		return isPrime(num + s[idx - 1]) && unique;
	}

	public static void backtrack(int idx) {
		if (idx == n) {
			if (isPrime(s[0] + s[n - 1])) {
				for (int i = 0; i < n; i++) {
					pw.print(s[i]);
					if (i < n - 1)
						pw.print(" ");
				}
				pw.println();
			}
		} else {
			for (int i = 2; i <= n; i++) {
				if (ok(i, idx)) {
					s[idx] = i;
					backtrack(idx + 1);
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		for (int i = 1; bf.ready(); i++) {
			n = Integer.parseInt(bf.readLine());
			s = new int[n];
			s[0] = 1;
			pw.println("Case " + i + ":");
			backtrack(1);
			if (bf.ready())
				pw.println();
		}
		pw.flush();
		pw.close();
	}
}
