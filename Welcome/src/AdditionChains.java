import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class AdditionChains {
	static int[] generatedSeq, ansSeq, minDepth;
	static int leastLengthSofar;

	public static void computeDepth(int n) {
		minDepth = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int currentNum = i;
			int cnt = 0;
			for (; currentNum < n; cnt++)
				currentNum <<= 1;
			minDepth[i] = cnt;
		}
	}

	public static void dfs(int d, int n) {

		if (d + minDepth[generatedSeq[d]] > leastLengthSofar)
			return;

		if (generatedSeq[d] == n) {
			leastLengthSofar = d;
			for (int i = 1; i <= d; i++)
				ansSeq[i] = generatedSeq[i];
		}

		for (int i = d; i > 0; i--) {
			int nextinSeq = generatedSeq[d] + generatedSeq[i];
			if (nextinSeq <= n) {
				generatedSeq[d + 1] = nextinSeq;
				dfs(d + 1, n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			generatedSeq = new int[n + 1];
			ansSeq = new int[n + 1];
			leastLengthSofar = n;
			computeDepth(n);
			generatedSeq[1] = 1;
			dfs(1, n);
			for (int i=1; i<=leastLengthSofar; i++){
				System.out.print(ansSeq[i]);
				if(i!=leastLengthSofar)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
