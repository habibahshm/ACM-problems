import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pangrams {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		s = s.toLowerCase();
		boolean[] complete = new boolean[26];
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			String curr = st.nextToken();
			for (int i = 0; i < curr.length(); i++) {
				char c = curr.charAt(i);
				complete[c - 97] = true;
			}
		}

		boolean flag = true;
		for (int i = 0; i < 26; i++) {
			if (!complete[i]) {
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("pangram");
		else
			System.out.println("not pangram");
	}
}
