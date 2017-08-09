import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BearandPrimeNumbers {
	static int[] numpf;
	static int N;
	static int l, r;
	static int[] frequency;
	static int[] primedivides;
	static long[] prefixsum;
	static final int limit = (int)1e7;

	public static void countPF() {
		for (int i = 2; i <= N; i++) {
			if (numpf[i] == 0) {
				for (int j = i; j <= N; j += i) {
					numpf[j]++;

					primedivides[i] += frequency[j];

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int max = -1;
		frequency = new int[(int) 1e7 + 1];
		for (int i = 0; st.hasMoreTokens(); i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			frequency[arr[i]]++;
			max = Math.max(max, arr[i]);
		}

		primedivides = new int[max + 1];
		prefixsum = new long[(int) 1e7 + 1];
		N = max;
		numpf = new int[max + 1];
		countPF();
		prefixsum[0] = primedivides[0];

		for (int i = 1; i < prefixsum.length; i++) {
			prefixsum[i] = prefixsum[i - 1];
			if (i < primedivides.length)
				prefixsum[i] += primedivides[i];
		}

		int m = Integer.parseInt(bf.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(bf.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			l = Math.min(l, limit);
			r = Math.min(r, limit);
			System.out.println(prefixsum[r] - prefixsum[l - 1]);
		}

	}
}
