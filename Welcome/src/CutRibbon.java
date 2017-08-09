import java.io.*;
import java.util.*;

public class CutRibbon {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = -1;
		int k = 0;
		for (int i = 0; i <= n / a; i++) {
			for (int j = 0; j <= n / b; j++) {
				int temp = n - i * a - j * b;
				if (temp % c == 0 && temp >= 0) {
					k = temp / c;
					max = Math.max(max, i + j + k);
				}
			}
		}
		System.out.println(max);
	}
}
