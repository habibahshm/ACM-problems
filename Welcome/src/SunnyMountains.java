import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SunnyMountains {
	static final double EPS = 1e-9;

	static public class Point implements Comparable<Point> {

		double x, y;

		public Point(double a, double b) {
			x = a;
			y = b;
		}

		public int compareTo(Point p) {
			return x > p.x + EPS ? -1 : 1;

		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		static double sq(double x) {
			return x * x;
		}
	}

	static public class Line {
		double a, b, c;

		Line(Point p, Point q) {
			if (Math.abs(p.x - q.x) < EPS) {
				a = 1;
				b = 0;
				c = -p.x;
			} else {
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}

		}

		Line(Point p, double m) {
			a = -m;
			b = 1;
			c = -(a * p.x + p.y);
		}

		boolean parallel(Line l) {
			return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
		}

		Point intersect(Line l) {
			if (parallel(l))
				return null;
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			if (Math.abs(b) < EPS)
				y = -l.a * x - l.c;
			else
				y = -a * x - c;

			return new Point(x, y);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			int l = Integer.parseInt(bf.readLine());
			Point[] peaks = new Point[l];
			for (int i = 0; i < l; i++) {
				st = new StringTokenizer(bf.readLine());
				peaks[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(peaks);
			double ans = peaks[0].dist(peaks[1]);
			Point current = peaks[1];
			for (int i = 1; i < l; i++) {
				if (peaks[i].y > current.y + EPS) {
					Point c = (new Line(peaks[i], peaks[i - 1])).intersect(new Line(current, 0.0));
					ans += c.dist(peaks[i]);
					current = peaks[i];
				}
			}
			DecimalFormat formatter = new DecimalFormat("0.00");
			System.out.println(formatter.format(ans));
		}
	}
}
