import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class StringPopping {
	static TreeSet<String> memo;

	public static boolean pop(StringBuilder s) {
		if (memo.contains(s.toString()))
			return false;
		if (s.length() == 0)
			return true;

		memo.add(s.toString());
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int j = i + 1;
			for (; j < s.length(); j++)
				if (s.charAt(j) != c)
					break;
			if (j - i < 2)
				continue;
			if (pop(new StringBuilder(s).delete(i, j)))
				return true;
			i = j - 1;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			memo = new TreeSet<String>();
			StringBuilder s = new StringBuilder(bf.readLine());
			System.out.println(pop(s) ? 1 : 0);
		}
	}
}
