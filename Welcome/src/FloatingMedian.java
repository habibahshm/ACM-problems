import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloatingMedian {
	static int[] a;
	static int[] values;

	public long sumOfMedians(int seed, int mul, int add, int N, int K) {
		long ans = 0;
		a = new int[N];
		a[0] = seed;
		for (int i = 1; i < N; i++)
			a[i] = ((a[i - 1] * mul) + add) % 65536;
		values = new int[65537];
		for (int i = 0; i < N - K + 1; i++) {
			int b = i;
			int e = i + K - 1;
			int min = 70000;
			int max = 0;
			for (int j = b; j <= e; j++) {
				values[a[j]] = 1;
				min = Math.min(a[j], min);
				max = Math.max(a[j], max);
			}
			int idx = (K + 1) / 2;
			int ctr = 0;
			for (int j = min; j <= max; j++) {
				if (values[j] == 1)
					ctr++;
				if (ctr == idx) {
					ans += j;
					break;
				}
			}
			Arrays.fill(values, 0);
		}
		return ans;
	}

	
}
