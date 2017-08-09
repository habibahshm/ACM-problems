import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Rails {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			boolean flag = true;
			while (flag) {
				Stack<Integer> rail = new Stack<>();
				int d = 0;
				st = new StringTokenizer(bf.readLine());
				while (st.hasMoreTokens()) {
					int cur = Integer.parseInt(st.nextToken());
					if (cur == 0) {
						flag = false;
						break;
					}
					while (d < cur)
						rail.push(++d);

					if (rail.peek() == cur)
						rail.pop();
				}
				if (flag) {
					if (rail.isEmpty())
						System.out.println("Yes");
					else
						System.out.println("No");
				}
			}
			System.out.println();
		}
	}
}
