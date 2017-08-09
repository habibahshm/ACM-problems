import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CountingWeekendDays {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] month = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		TreeMap<String, Integer> tm = new TreeMap<>();
		for (int i = 0; i < month.length; i++)
			tm.put(month[i], days[i]);
		for (int i = 0; i < week.length; i++)
			tm.put(week[i], i + 1);
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(bf.readLine());
			String m = st.nextToken();
			String d = st.nextToken();
			int ans = 0;
			if (tm.get(d) <= 6)
				ans += 2;
			else
				ans++;
			int remD = tm.get(m) - (7 - tm.get(d) + 1);
			ans += ((remD / 7) * 2);
			if (remD % 7 == 6)
				ans++;
			else if (remD % 7 == 7)
				ans += 2;
			System.out.println(ans);
		}
	}
}
