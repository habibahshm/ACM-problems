import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GameofTwoStacks {
	static long[] prefixsumA;
	static long[] prefixsumB;
	static int n, m, x;

	public static boolean isValid(int k) {
		// System.out.println(k);
		int takeA = k;
		int takeB = 0;
		boolean valid = false;
		while (takeB <= k) {
			long sumA = 0;
			long sumB = 0;

			if (takeA > n && takeB > m)
				continue;

			if (takeA > 0 && takeA <= n)
				sumA = prefixsumA[takeA - 1];
			if (takeB > 0 && takeB <= m)
				sumB = prefixsumB[takeB - 1];

			if (sumA + sumB <= x && !(takeB > m) && !(takeA > n)) {
//				System.out.println(takeA + " " + takeB);
//				System.out.println(sumA + sumB);
				valid = true;
			}
			takeA--;
			takeB++;
		}
		return valid;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(bf.readLine());
		while (g-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			int[] A = new int[n];
			int[] B = new int[m];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++)
				A[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < m; i++)
				B[i] = Integer.parseInt(st.nextToken());

			prefixsumA = new long[n];
			prefixsumB = new long[m];

			for (int i = 0; i < n; i++) {
				if (i > 0)
					prefixsumA[i] = prefixsumA[i - 1];
				prefixsumA[i] += A[i];
			}

			for (int i = 0; i < m; i++) {
				if (i > 0)
					prefixsumB[i] = prefixsumB[i - 1];
				prefixsumB[i] += B[i];
			}

//			System.out.println(Arrays.toString(prefixsumA));
//			System.out.println(Arrays.toString(prefixsumB));

			long ans = 0;
			long lo = 0;
			long high = m + n;
			while (lo <= high) {
				long mid = (lo + high) >> 1;
				if (isValid((int) mid)) {
					ans = mid;
					lo = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			System.out.println(ans);

		}
	}
}
