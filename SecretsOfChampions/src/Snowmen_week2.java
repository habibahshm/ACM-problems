import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Snowmen_week2 {
	static class Stack {
		Stack s;
		long sum;
		int element;

		public Stack(Stack s, long sum, int e) {
			this.s = s;
			this.sum = sum;
			element = e;
		}

		public Stack push(int n) {
			return new Stack(this, sum + n, n);
		}
	}

	public static void main(String[] args) throws IOException {
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 BufferedReader bf = new BufferedReader(new FileReader("snowmen.in"));
		 PrintWriter out = new PrintWriter(new FileWriter("snowmen.out"));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		Stack[] snowmen = new Stack[n + 1];
		snowmen[0] = new Stack(null, 0,0);
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (m == 0) {
				snowmen[i] = snowmen[t].s;
			} else {
				snowmen[i] = snowmen[t].push(m);
			}
			sum += (snowmen[i].sum);
		}

		out.println(sum);
		
		out.flush();
		out.close();
	}
}
