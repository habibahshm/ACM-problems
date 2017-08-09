import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class TheKnightsOfTheRoundTable {
	public static class Triangle {
		double a, b, c;

		Triangle(double A, double B, double C) // counter clockwise
		{
			a = A;
			b = B;
			c = C;
		}

		double perm() {
			return a + b + c;
		}

		double area() {
			double s = (a + b + c) / 2.0; // s = half perimeter
			return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // take care
																// of
																// overflow
		}

		double rInCircle() {
			return area() / (perm() * 0.5);
		}

		static double round(double x) {
			return Math.round(x * 1000) / 1000.0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (bf.ready()) {
			st = new StringTokenizer(bf.readLine());
			Triangle t = new Triangle(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()),
					Double.parseDouble(st.nextToken()));
			double r = Triangle.round(t.rInCircle());
			DecimalFormat formatter = new DecimalFormat("0.000");
			System.out.println("The radius of the round table is: " + formatter.format(r));
		}
	}
}
