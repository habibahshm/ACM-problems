import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class OddSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			int a = Integer.parseInt(bf.readLine());
			int b = Integer.parseInt(bf.readLine());
			if (a != b) {
				if (a % 2 == 0)
					a++;
				for (int j = a; j <= b; j += 2)
					sum += j;
			}
			System.out.println("Case " + i + ": " + sum);
		}
	}
}
