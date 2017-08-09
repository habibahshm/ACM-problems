import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] chimps;

	public static int lastShort(int start, int end, int luchu) {
		while (start < end) {
			int mid = start + ((end - start+1) / 2);
			if (chimps[mid] < luchu)
				start = mid;
			else
				end = mid - 1;
		}
		
		if (chimps[start] < luchu)
			return chimps[start];
		return -1;
	}

	public static int firstTall(int start, int end, int luchu) {
		while (start < end) {
			int mid = start + ((end - start) / 2);
			if (chimps[mid] > luchu)
				end = mid;
			else
				start = mid + 1;
		}
		
		if (chimps[start] > luchu)
			return chimps[start];
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		chimps = new int[N];
		for (int i = 0; st.hasMoreTokens(); i++)
			chimps[i] = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		while (st.hasMoreTokens()) {
			int luchu = Integer.parseInt(st.nextToken());
			int lastShort = lastShort(0, N - 1, luchu);
			int firstTall = firstTall(0, N - 1, luchu);
			System.out.print((lastShort == -1) ? "X" : lastShort);
			System.out.print(" ");
			System.out.print((firstTall == -1) ? "X" : firstTall);
			System.out.println();
		}
	}
}


