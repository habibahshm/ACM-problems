import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChoosingSymbolPairs {
	static long[] lf = new long[26];
	static long[] df = new long[10];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		char[] ch = s.toCharArray();
		long ans = 0;
		for (char c : ch) {
			if (c >= 'a' && c <= 'z')
				lf[c - 'a']++;
			else
				df[Integer.parseInt(c + "")]++;
		}
		for (int i = 0; i < 26; i++)
			ans += (lf[i] * lf[i]);
		for (int i = 0; i < 10; i++)
			ans += (df[i] * df[i]);
		
		System.out.println(ans);
	}
}
