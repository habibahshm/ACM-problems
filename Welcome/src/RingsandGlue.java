import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RingsandGlue {
	static final double EPS = 1e-12;
	static int[] r, rank, setSize;
	static int numSets;

	public static void UnionFind(int N) {
		r = new int[N];
		rank = new int[N];
		setSize = new int[N];
		numSets = N;
		for (int i = 0; i < N; i++) {
			r[i] = i;
			setSize[i] = 1;
		}
	}

	public static int findSet(int i) {
		if (r[i] == i)
			return i;
		else
			return r[i] = findSet(r[i]);
	}

	public static Boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}

	public static void unionSet(int i, int j) {
		if (isSameSet(i, j))
			return;
		numSets--;
		int x = findSet(i), y = findSet(j);
		// rank is used to keep the tree short
		if (rank[x] > rank[y]) {
			r[y] = x;
			setSize[x] += setSize[y];
		} else {
			r[x] = y;
			setSize[y] += setSize[x];
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}

	public static int numDisjointSets() {
		return numSets;
	}

	public static int sizeOfSet(int i) {
		return setSize[findSet(i)];
	}

	public static class Point {
		double x;
		double y;

		public Point(double a, double b) {
			x = a;
			y = b;
		}

		public double dist(Point a) {
			double c = sq(x - a.x);
			double b = sq(y - a.y);
			return b + c;
		}
	}

	public static double sq(double a) {
		return a * a;
	}

	public static class Circle {
		Point c;
		double r;

		public Circle(Point a, double b) {
			c = a;
			r = b;
		}

		public boolean intersects(Circle a) {
			return a.c.dist(c) < sq(r + a.r) + EPS && a.c.dist(c) + EPS > sq(Math.abs(r - a.r));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		while ((n = Integer.parseInt(bf.readLine())) != -1) {
			UnionFind(n);
			Circle[] rings = new Circle[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				double r = Double.parseDouble(st.nextToken());
				rings[i] = new Circle(new Point(x, y), r);
			}
			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
					if (rings[i].intersects(rings[j]))
						unionSet(i, j);

			int max = 0;
			for (int i = 0; i < n; i++)
				if (r[i] == i)
					max = Math.max(max, sizeOfSet(i));
			if (max==0 || max >1)
				System.out.println("The largest component contains " + max + " rings.");
			else
				System.out.println("The largest component contains " + max + " ring.");
		}
	}
}
