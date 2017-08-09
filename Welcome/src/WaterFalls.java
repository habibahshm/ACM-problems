import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WaterFalls {
	static public class Point {
		static final double EPS = 1e-9;

		int x, y;

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	static public class LineSegment implements Comparable<LineSegment> {

		Point p, q;

		LineSegment(Point a, Point b) {
			p = a;
			q = b;
		}

		public int compareTo(LineSegment x) {
			int a = (Math.max(x.p.y, x.q.y));
			int b = (Math.max(p.y, q.y));
			if (a > b)
				return 1;
			if (a < b)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= n; i++) {
			bf.readLine();
			LineSegment[] tmp = new LineSegment[Integer.parseInt(bf.readLine())];
			for (int j = 0; j < tmp.length; j++) {
				st = new StringTokenizer(bf.readLine());
				tmp[j] = new LineSegment(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
						new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Arrays.sort(tmp);
			int s = Integer.parseInt(bf.readLine());
			ArrayList<LineSegment>[] main = new ArrayList[s];
			for (int j = 0; j < s; j++)
				main[j] = new ArrayList<LineSegment>();
			Point[] sources = new Point[s];
			for (int j = 0; j < s; j++) {
				st = new StringTokenizer(bf.readLine());
				Point source = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				sources[j] = source;
				for (int k = 0; k < tmp.length; k++) {
					int maxy = Math.max(tmp[k].p.y, tmp[k].q.y);
					int minx = Math.min(tmp[k].p.x, tmp[k].q.x);
					int maxx = Math.max(tmp[k].p.x, tmp[k].q.x);
					if (source.y >= maxy && source.x >= minx && source.x <= maxx) {
						main[j].add(tmp[k]);
					}
				}
			}
			Point ans;
			for (int j = 0; j < s; j++) {
				ans = sources[j];
				System.out.println("source:" + (j + 1));
				for (int j2 = 0; j2 < main[j].size(); j2++) {
					LineSegment x = main[j].get(j2);
					int minx = Math.min(x.p.x, x.q.x);
					int maxx = Math.max(x.p.x, x.q.x);
					if (ans.x >= minx && ans.x <= maxx) {

						if (x.p.y < x.q.y) {
							ans = x.p;
							System.out.println("am in the then");
						} else {
							ans = x.q;
							System.out.println("am in the else");
						}
					}
					System.out.println(ans.x + " " + ans.y);

					for (int k = 0; k < s; k++) {
						for (int k2 = 0; k2 < sources.length; k2++) {
							System.out.print(main[k].get(k2));
						}

					}
				}
				// System.out.println(ans.x);
			}
			if (i != n)
				System.out.println();
		}
	}
}
