import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

//Recurrence for Even Fibonacci sequence is:
//    EFn = 4EFn-1 + EFn-2
//with seed values
//    EF0 = 0 and EF1 = 2.
//
//EFn represents n'th term in Even Fibonacci sequence.

public class ProjectEuler2_EvenFibonacciNumbers {
	static long sum;

	public static void efib(long limit) {
		long ef0 = 0;
		long ef1 = 2;

		sum = ef0 + ef1;

		while (ef1 <= limit) {
			long ef2 = 4 * ef1 + ef0;
			if (ef2 > limit)
				break;
			sum += ef2;
			ef0 = ef1;
			ef1 = ef2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			sum = 0;
			long n = Long.parseLong(bf.readLine());
			efib(n);
			System.out.println(sum);
		}
	}
}
