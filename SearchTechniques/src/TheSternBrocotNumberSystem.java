import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheSternBrocotNumberSystem {
	static double EPS = 1e-12;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter out = new PrintWriter(new FileWriter("test.out"));
		StringTokenizer st;
		//int c = 1;
		while (true) {
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (m == 1 && n == 1)
				break;

			int lm = 0;
			int ln = 1;
			int midm = 1;
			int midn = 1;
			double mid = 1;
			int rm = 1;
			int rn = 0;
			String ans = "";

			double target = m * 1.0 / n;

			//out.println("for case " + c + ": " + m + "/" + n);
			while (Math.abs(mid - target) > EPS) {
				if (target > mid + EPS) {
					ans += "R";
					lm = midm;
					ln = midn;
				} else {
					ans += "L";
					rm = midm;
					rn = midn;
				}

				midm = lm + rm;
				midn = ln + rn;
				mid = midm * 1.0 / midn;

			}
			//c++;
			System.out.println(ans);
		}

		System.out.flush();
		System.out.close();
	}
}
