import java.io.*;
import java.util.*;

public class NumberingRoads {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; true; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			if (r == 0)
				break;
			int n = Integer.parseInt(st.nextToken());
			int remained = r - n;
			if (remained < 0)
				remained = 0;
			int prefix = remained / n;
			if (remained % n != 0)
				prefix++;
			if (prefix > 26)
				System.out.println("Case " + i + ": impossible");
			else
				System.out.println("Case " + i + ": " + prefix);
		}
	}
}
