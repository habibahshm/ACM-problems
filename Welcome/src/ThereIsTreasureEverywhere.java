import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class ThereIsTreasureEverywhere {
	static public class Point {
		static final double EPS = 1e-9;

		double x, y;

		public Point(double a, double b) {
			x = a;
			y = b;
		}

		public int compareTo(Point p) {
			if (Math.abs(x - p.x) > EPS)
				return x > p.x ? 1 : -1;
			if (Math.abs(y - p.y) > EPS)
				return y > p.y ? 1 : -1;
			return 0;
		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		static double sq(double x) {
			return x * x;
		}

		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	static final double angle = degToRad(45.0);

	static double degToRad(double d) {
		return d * Math.PI / 180.0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		for (int k = 1; !(s = bf.readLine()).equals("END"); k++) {
			System.out.println();
			Point pos = new Point(0, 0);
			st = new StringTokenizer(s, ",");
			while (st.hasMoreTokens()) {
				String a = st.nextToken();
				String direction = "";
				int num = 0;
				for (int i = 0; i < a.length(); i++) {
					if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
						direction = a.substring(i);
						num = Integer.parseInt(a.substring(0, i));
						break;
					}
				}
				if ((direction.charAt(direction.length() - 1)) == '.')
					direction = direction.substring(0, direction.length() - 1);
				switch (direction) {
				case "N":
					pos.y += num;
					break;
				case "S":
					pos.y -= num;
					break;
				case "E":
					pos.x += num;
					break;
				case "W":
					pos.x -= num;
					break;
				case "NE":
					pos.x += num * Math.cos(angle);
					pos.y += num * Math.sin(angle);
					break;
				case "NW":
					pos.x -= num * Math.cos(angle);
					pos.y += num * Math.sin(angle);
					break;
				case "SW":
					pos.x -= num * Math.cos(angle);
					pos.y -= num * Math.sin(angle);
					break;
				case "SE":
					pos.x += num * Math.cos(angle);
					pos.y -= num * Math.sin(angle);
					break;
				}
			}
			DecimalFormat formatter = new DecimalFormat("0.000");
			pos.x = pos.x;
			pos.y = pos.y;
			double dist = pos.dist(new Point(0, 0));
			System.out.println("Map #" + k);
			System.out.println("The treasure is located at " + formatter.format(pos) + ".");
			System.out.println("The distance to the treasure is " + formatter.format(dist)+ ".");
		}
	}
}
