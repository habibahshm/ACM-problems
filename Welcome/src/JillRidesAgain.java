import java.io.*;
import java.util.*;

public class JillRidesAgain {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			int stops = s.nextInt();
			int[] routes = new int[stops - 1];
			for (int j = 0; j < stops - 1; j++) {
				routes[j] = s.nextInt();
			}
			int sum = 0;
			int max = -10 ^ 6;
			int from = 0;
			int best_from = 0;
			int to = 0;
			for (int j = 0; j < stops - 1; j++) {
				sum += routes[j];
				if (sum < 0) {
					from = j + 1;
					sum = 0;
				}
				if (sum > max) {
					max = sum;
					to = j;
					best_from = from;

				} else if (sum == max)
					if ((j - from) > (to - best_from)) {
						best_from = from;
						to = j;
					}

			}
			if (max == 0)
				System.out.println("Route " + i + " has no nice parts");
			else
				System.out.println("The nicest part of route " + i
						+ " is between stops " + (best_from + 1) + " and "
						+ (to + 2));

		}
	}
}
