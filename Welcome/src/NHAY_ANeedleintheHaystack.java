import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NHAY_ANeedleintheHaystack {

	static int[] KMP(char[] s) {
		int n = s.length;
		int[] pi = new int[n];

		for (int i = 1, j = 0; i < n; i++) {
			while (j > 0 && (s[i] != s[j]))
				j = pi[j - 1];
			if (s[i] == s[j])
				j++;

			pi[i] = j;
		}

		return pi;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (bf.ready()) {
			int pl = Integer.parseInt(bf.readLine());
			StringBuilder sb = new StringBuilder();
			String p = bf.readLine();
			String txt = bf.readLine();
			sb.append(p);
			sb.append('&');
			sb.append(txt);
			int[] ans = KMP(sb.toString().toCharArray());
			ArrayList<Integer> ind = new ArrayList<>();
			for (int i = 1; i < sb.length(); i++) {
				if (ans[i] == pl) {
					ind.add(i - (2*pl));
				}
			}
			for (int i = 0; i < ind.size(); i++) {
				System.out.print(ind.get(i));
				if (i != ind.size() - 1)
					System.out.println();
			}
			
				System.out.println();
		}
	}
}
