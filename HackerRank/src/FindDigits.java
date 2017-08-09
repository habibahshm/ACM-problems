import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindDigits {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			String s = bf.readLine();
			int n = Integer.parseInt(s);
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				int d = Integer.parseInt(s.charAt(i) + "");
				if (d != 0 && n % d == 0)
					count++;
			}
			System.out.println(count);
		}
	}
}
