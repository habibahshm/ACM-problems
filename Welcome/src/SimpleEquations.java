import java.io.*;
import java.util.*;

public class SimpleEquations {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int x, y, z;
			boolean found = false;
			for (x = -22; x <= 22 && !found; x++) {
				for (y = -100; y <= 100 && !found; y++) {
					for (z = -100; z <= 100 && !found; z++) {
						if (x != y && y != z && x != z)
							if (x + y + z == a && x * y * z == b
									&& x * x + y * y + z * z == c) {
								found = true;
								System.out.println(x + " " + y + " " + z);
							}
					}
				}
			}
			if(!found)
				System.out.println("No solution.");
		}
	}
}
