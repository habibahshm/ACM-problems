import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BashsBigDay {
	/*
	 * la2a. for every i, the inner loop executes N / i times. f htb2a N / 2 + N
	 * / 3 + N / 4 + ... + N / N = N (1/ 2 + 1 / 3 + 1 / 4 + ... + 1 / N) which
	 * is a harmonic series approximately = N log N
	 *///
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = 100001;
		int n = Integer.parseInt(bf.readLine());
		int[] cnt = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		while (n-- > 0)
			cnt[Integer.parseInt(st.nextToken())]++;
		int max = 1;
		for (int i = 2; i < N; i++) {
			int cur = 0;
			for (int j = i; j < N; j += i)
				cur += cnt[j];
			max = Math.max(cur, max);
		}

		System.out.println(max);
	}
}
