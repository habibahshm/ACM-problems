import java.util.*;
import java.io.*;

public class SocialConstrain {
	public static int[] nextPerm(int[] arr) {
		int len = arr.length;
		int prev = arr[len - 1];
		int i;
		for (i = len - 2; i >= 0; i--) {
			if (arr[i] < prev)
				break;
			prev = arr[i];
		}
		for (int j = len - 1; j > i; j--) {
			if (arr[j] > arr[i]) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				break;
			}
		}
		int s = i + 1;
		int e = len - 1;
		while (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}
		return arr;
	}

	public static int fact(int x) {
		int res = 1;
		for (int i = x; i >= 2; i--)
			res *= i;
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		while (!(s = bf.readLine()).equals("0 0")) {
			st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] seats = new int[n];
			for (int i = 0; i < n; i++)
				seats[i] = i;
			int[][] rules = new int[m][3];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				rules[i][0] = Integer.parseInt(st.nextToken());
				rules[i][1] = Integer.parseInt(st.nextToken());
				rules[i][2] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			int f = fact(n);
			for (int i = 0; i < f; i++) {
				boolean satisfies = true;
				for (int j = 0; j < m; j++) {
					int a = rules[j][0];
					int b = rules[j][1];
					int c = rules[j][2];
					int idxa = -1;
					int idxb = -1;
					for (int k = 0; k < n; k++) {
						if (seats[k] == a)
							idxa = k;
						if (seats[k] == b)
							idxb = k;
					}
					int diff = Math.abs(idxa - idxb);
					if (c < 0) {
						if (diff < Math.abs(c))
							satisfies = false;
					} else {
						if (diff > Math.abs(c))
							satisfies = false;
					}
				}
				if (satisfies)
					count++;
				if (i < f - 1)
					seats = nextPerm(seats);
			}
			System.out.println(count);
		}
	}
}
