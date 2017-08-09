import java.util.*;
import java.io.*;


public class BackToIntermediateMath {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			double d = Double.parseDouble(st.nextToken());
			double v = Double.parseDouble(st.nextToken());
			double u = Double.parseDouble(st.nextToken());
			if (u == 0 || v == 0 || u <= v)
				System.out.println("Case " + i + ": can't determine");
			else {
				double fastestPath = d / u;
				double shortestPath = d / Math.sqrt((u * u) - (v * v));
				System.out.printf("Case %d: %.3f\n", i,
						Math.abs(shortestPath - fastestPath));
			}
		}
	}
}
