import java.io.*;
import java.util.*;

public class TweentythreeOutOfFive {
	static int[] num;
	static boolean found;

	public static int[] nextPerm(int[] arr) {
		int len = arr.length;
		int prev = arr[len - 1];
		int i;
		for (i = len - 2; i >= 0; i--) {
			if (arr[i] < prev)
				break;
			prev = arr[i];
		}
		for (int j = len - 1; j > i && i>=0; j--) {
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

	public static void backtrack(int idx, int sum) {
		if (idx == 5) {
			if (sum == 23 && !found)
				found = true;
			return;
		}

		backtrack(idx + 1, sum + num[idx]);
		backtrack(idx + 1, sum - num[idx]);
		backtrack(idx + 1, sum * num[idx]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		while (!(s = bf.readLine()).equals("0 0 0 0 0")) {
			st = new StringTokenizer(s);
			num = new int[5];
			for (int i = 0; st.hasMoreTokens(); i++)
				num[i] = Integer.parseInt(st.nextToken());
			found = false;
			for(int i=0; i<120 && !found; i++){
				backtrack(1, num[0]);
				num = nextPerm(num);
			}
			if (found)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}
	}
}
