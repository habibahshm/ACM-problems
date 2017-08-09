import java.io.*;
import java.util.*;

public class Dartamania {
	static int[] possiblevalues;
	static boolean[][][] taken;
	static int l;
	static int permutations;
	static int combinations;

	public static void play(int s) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				for (int k = 0; k < l; k++) {
					int a = possiblevalues[i];
					int b = possiblevalues[j];
					int c = possiblevalues[k];
					if (a + b + c == s) {
						permutations++;
						if (!taken[a][b][c]) {
							combinations++;
							taken[a][b][c] = taken[a][c][b] = true;
							taken[b][a][c] = taken[b][c][a] = true;
							taken[c][a][b] = taken[c][b][a] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Set<Integer> temp = new HashSet<Integer>();
		for (int i = 0; i <= 20; i++) {
			temp.add(i);
			temp.add(i * 2);
			temp.add(i * 3);
		}
		temp.add(50);
		Iterator<Integer> itr = temp.iterator();
		possiblevalues = new int[l = temp.size()];
		for (int i = 0; i < temp.size(); i++)
			possiblevalues[i] = itr.next();
		int score;
		while ((score = Integer.parseInt(bf.readLine())) > 0) {
			permutations = 0;
			combinations = 0;
			taken = new boolean[61][61][61];
			play(score);
			if (permutations == 0)
				System.out.println("THE SCORE OF " + score
						+ " CANNOT BE MADE WITH THREE DARTS.");
			else {
				System.out.println("NUMBER OF COMBINATIONS THAT SCORES "
						+ score + " IS " + combinations+".");
				System.out.println("NUMBER OF PERMUTATIONS THAT SCORES "
						+ score + " IS " + permutations+".");
			}
			System.out
					.println("**********************************************************************");
		}
		System.out.println("END OF OUTPUT");
	}
}
