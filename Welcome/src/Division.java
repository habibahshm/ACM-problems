import java.io.*;

public class Division {
	public static boolean unique(int a, int b) {
		int[] u = new int[10];
		for (int i = 0; i < 5; i++) {
			int d = a % 10;
			if (u[d] == 1)
				return false;
			u[d]++;
			a /= 10;
		}
		for (int i = 0; i < 5; ++i) {
			int d = b % 10;
			if (u[d] == 1)
				return false;
			u[d]++;
			b /= 10;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		int k = 0;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			if (k == 0)
				k++;
			else
				System.out.println();
			boolean found = false;
			for (int b = 01234; b <= 98765 / n; b++) {
				int a = b * n;
				if (unique(a, b)) {
					String a1 = String.format("%05d", a);
					String b1 = String.format("%05d", b);
					System.out.println(a1 + " / " + b1 + " = " + n);
					found = true;
				}
			}
			if (!found)
				System.out.println("There are no solutions for " + n + ".");

		}
	}

}
