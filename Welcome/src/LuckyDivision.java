import java.io.*;

public class LuckyDivision {
	public static boolean isLucky(int x) {
		while (x != 0) {
			int d = x % 10;
			if (d != 7 && d != 4)
				return false;
			x /= 10;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		boolean al = false;
		for (int i = 4; i <= n; i++) {
			if (isLucky(i)) {
				if (n % i == 0) {
					al = true;
					break;
				}
			}
		}
		if(al)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
