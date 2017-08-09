import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PowerOfTwo {

	public static boolean power(long n) {
		return (n & (n - 1)) == 0 && n != 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				long sum = arr[i] + arr[j];
				if (power(sum))
					ans++;
			}
		}
		System.out.println(ans);
	}
}
