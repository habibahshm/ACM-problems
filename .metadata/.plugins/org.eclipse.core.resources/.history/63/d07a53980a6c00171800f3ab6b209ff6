import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DinnerwithEmma {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = -1;
		for (int i = 0; i < n; i++) {
			int min = 1000000001;
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) 
                 min = Math.min(min, Integer.parseInt(st.nextToken()));
			max = Math.max(max, min);
		}
		System.out.println(max);
	}
}
