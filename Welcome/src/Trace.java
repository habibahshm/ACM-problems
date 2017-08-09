import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Trace {
	public static int[] reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			int tmp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = tmp;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] r = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			r[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(r);
		reverse(r);
		double ans = 0;
		int sign = 1;
		for (int i = 0; i < r.length; i++) {
			if (sign == 1)
				ans += (Math.PI * r[i] * r[i]);
			else
				ans -= (Math.PI * r[i] * r[i]);
			sign ^= 1;
		}
		System.out.println(ans);
	}
}
