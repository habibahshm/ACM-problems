import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulMatrix {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x = 0;
		int y = 0;
		boolean cont = true;
		for (int i = 1; i <= 5 && cont; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= 5; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					x = j;
					y = i;
					cont=false;
					break;
				}
			}
		}
		int dx = Math.abs(3 - x);
		int dy = Math.abs(3 - y);
		System.out.println(dx + dy);
	}

}
