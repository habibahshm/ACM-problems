import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bee {
	static int fib[];

	static int fibonacci(int n) // O(log n)
	{
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;
		if (fib[n] != -1)
			return fib[n];

		int k = n >> 1;
		int a = fibonacci(k), b = fibonacci(k + 1);

		if (n % 2 == 0)
			return fib[n] = a * (2 * b - a);
		return fib[n] = b * b + a * a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		fib = new int[100001];
		Arrays.fill(fib, -1);
		while ((n = Integer.parseInt(bf.readLine())) != -1) {
			long male = 0;
			long total = 0;
			if (n < 2) {
				male = fibonacci(n);
				total = fibonacci(n + 2);
			} else {
				while ((n + 1) >= 2) {
					total += fibonacci(n + 1);
					male += fibonacci(n);
					n--;
				}
				total++;
			}
			System.out.println(male + " " + total);

		}
	}
}
