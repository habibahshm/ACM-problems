import java.io.*;
import java.util.*;

public class BrickGame {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int l = Integer.parseInt(st.nextToken());
			int[] players = new int[l];
			for (int j = 0; j < l; j++)
				players[j] = Integer.parseInt(st.nextToken());
			int answer;
			if (l % 2 == 1)
				answer = players[l / 2];
			else
				answer = (players[l / 2] + players[(l / 2) + 1]) / 2;
			System.out.println("Case " + i + ": " + answer);

		}
	}
}
