import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Books {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] books = new int[n];
		for (int i = 0; i < n; i++)
			books[i] = Integer.parseInt(st.nextToken());
		int sum = 0;
		int max = 0;
		int i = 0;
		int j = 0;
		while (j < n) {
			sum += books[j];
			while (sum > t && i <= j)
				sum -= books[i++];
			max = Math.max(max, j - i + 1);
			j++;
		}
		System.out.println(max);
	}

}
