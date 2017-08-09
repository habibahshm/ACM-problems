import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RestaurantTables {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int g = Integer.parseInt(st.nextToken());
		int single = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int denied = 0;
		int half = 0;
		while (g-- > 0) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur == 1) {
				if (single > 0)
					single--;
				else {
					if (d > 0) {
						d--;
						half++;
					} else if (half > 0)
						half--;
					else
						denied++;
				}
			} else {
				if (d > 0)
					d--;
				else
					denied += 2;
			}
		}
		System.out.println(denied);
	}
}
