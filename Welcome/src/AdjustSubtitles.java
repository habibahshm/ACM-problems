import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AdjustSubtitles {

	static int secToAdd = 3;
	static int totalScences = 1404;

	static String adjust(String str) {
		StringTokenizer st1 = new StringTokenizer(str, ":");
		int h = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		int s = Integer.parseInt(st1.nextToken());
		int t = h * 3600 + m * 60 + s;
		if (t + secToAdd < 0)
			return str;

		t += secToAdd;

		int nh = t / 3600;
		t %= 3600;
		int nm = t / 60;
		t %= 60;
		int ns = t;

		return String.format("%02d:%02d:%02d", nh, nm, ns);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("/media/habiba/AC04F47704F4463C/sherlock holmes/Sherlock Holmes orig.srt"));
		PrintWriter out = new PrintWriter(new FileWriter("/media/habiba/AC04F47704F4463C/sherlock holmes/Sherlock Holmes.srt"));
		while (totalScences-- > 0) {
			out.println(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine(), ",");
			String s = st.nextToken();
			String ns = adjust(s);
			String ans = ns + ",";
			StringTokenizer st1 = new StringTokenizer(st.nextToken());
			ans += st1.nextToken() + " --> ";
			st1.nextToken();
			String ne = adjust(st1.nextToken());
			ans += ne + "," + st.nextToken();
			out.println(ans);
			String l;
			while ((l = bf.readLine()) != null && l.length() > 0)
				out.println(l);
			out.println();
		}
	}
}
