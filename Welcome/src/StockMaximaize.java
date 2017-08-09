import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StockMaximaize {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int l = Integer.parseInt(bf.readLine());
			int[] price = new int[l];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; st.hasMoreTokens(); i++)
				price[i] = Integer.parseInt(st.nextToken());
			long profit = 0;
			int max = price[l - 1];
			for (int i = l - 2; i >= 0; i--) {
				if (price[i] > max)
					max = price[i];
				else
					profit += max - price[i];
			}
			System.out.println(profit);
		}
	}
}
