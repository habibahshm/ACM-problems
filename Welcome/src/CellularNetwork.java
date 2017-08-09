import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CellularNetwork {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] cit = new int[c];
		int[] tow = new int[t];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < c; i++)
			cit[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < t; i++)
			tow[i] = Integer.parseInt(st.nextToken());
     
		int j = 0;
		int ans = 0;

		if (t == 1) {
			for (int i = 0; i < c; i++) {
				int d = Math.abs(cit[i] - tow[0]);
				ans = Math.max(d, ans);
			}
		} else {
			for (int i = 0; i < c; i++) {
				int curc = cit[i];
				while (true) {
					int min = tow[j];
					int max = tow[j + 1];
					if (curc >= min && curc <= max) {
						int d1 = curc - min;
						int d2 = max - curc;
						int tmp = Math.min(d1, d2);
						ans = Math.max(ans, tmp);
						break;
					}
					if (curc < min) {
						int d = min - curc;
						ans = Math.max(ans, d);
						break;
					}
					if (curc > max && j + 1 == tow.length - 1) {
						int d = curc - max;
						ans = Math.max(ans, d);
						break;
					}
					if (curc > max && j + 1 < tow.length - 1) {
						j++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
