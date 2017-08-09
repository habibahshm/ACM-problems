import java.io.*;
import java.util.*;

public class AddingReversedNo {
	public static String reverse(String s) {
		if (s.length() == 0)
			return "";
		else
			return s.charAt(s.length() - 1)
					+ reverse(s.substring(0, s.length() - 1));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String t = bf.readLine();
		int n = Integer.parseInt(t);
		for (int i = 1; i <= n; i++) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(reverse(st.nextToken()));
			int y = Integer.parseInt(reverse(st.nextToken()));
			int z = x + y;
			String answer = reverse("" + z);
			int j;
			for (j = 0; answer.charAt(j) == 48; j++) {
			}
			answer = answer.substring(j, answer.length());
			System.out.println(answer);

		}

	}

}
