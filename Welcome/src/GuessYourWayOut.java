import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuessYourWayOut {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int h = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		long dist = n + (1L << h) - 1;
		long[] path = new long[h + 1];
		path[h] = dist;
		for (int i = h - 1; i >= 0; i--)
			path[i] = path[i + 1] / 2;
		long ans = h;
		int level = 0;
		int dir = 0;
		for (int i = 0; i < path.length - 1; i++) {
			long nxt = (path[i] * 2) + dir;
			level++;
			if (nxt != path[i + 1]) {
				ans += (1L << (h - level + 1)) - 1;
			} else {

				dir = dir ^ 1;
			}
		}
		System.out.println(ans);
	}
}
