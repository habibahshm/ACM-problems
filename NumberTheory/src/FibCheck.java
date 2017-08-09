
public class FibCheck {
	public static boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt((double) x);
		return (s * s == x);
	}

	public static boolean isFib(int n) {
		return isPerfectSquare(5 * n * n - 4) || isPerfectSquare(5 * n * n + 4);
	}
}
