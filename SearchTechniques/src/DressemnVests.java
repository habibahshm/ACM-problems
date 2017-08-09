import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DressemnVests {

	static class Pair {
		int a;
		int b;

		public Pair(int x, int y) {
			a = x;
			b = y;
		}

		public String toString() {
			return a + " " + b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int[] soldiers = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			soldiers[i] = Integer.parseInt(st.nextToken());
		int[] vests = new int[m];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++)
			vests[i] = Integer.parseInt(st.nextToken());
		int num = 0;
		ArrayList<Pair> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			int cv = vests[j];
			int cs = soldiers[i];
			//System.out.println("i: " + i + " j: " + j);
			if (cv >= cs - x && cv <= cs + y) {
				ans.add(new Pair(i + 1, j + 1));
				num++;
				i++;
				j++;
			} else if (cv > cs + y)
				i++;
			else
				j++;

		}

		System.out.println(num);
		for (Pair p : ans) {
			System.out.println(p);
		}

	}
}
