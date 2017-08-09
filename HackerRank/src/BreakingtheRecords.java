import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreakingtheRecords {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int first = Integer.parseInt(st.nextToken());
		int max = first;
		int min = first;
		int high = 0;
		int low = 0;
		while (st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur > max) {
				max = cur;
				high++;
			}
			if (cur < min) {
				min = cur;
				low++;
			}
		}

		System.out.println(high + " " + low);
	}
}
