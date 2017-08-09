import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class week2p1_Queue {

	static class Stack1 {
		int[] stackarr;
		int maxsize;
		int top = -1;

		public Stack1(int n) {
			stackarr = new int[n];
			maxsize = n;
		}

		public void push(int x) {
			stackarr[++top] = x;
		}

		public int pop() {
			return stackarr[top--];
		}
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader bf = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader bf = new BufferedReader(new FileReader("stack.in"));
		PrintWriter out = new PrintWriter(new FileWriter("stack.out"));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		Stack1 s = new Stack1(n);
		while (n-- > 0) {
			st = new StringTokenizer(bf.readLine());
			String sign = st.nextToken();
			if (sign.equals("-"))
				out.println(s.pop());
			else {
				int x = Integer.parseInt(st.nextToken());
				s.push(x);
			}

		}
		out.flush();
		out.close();
	}
}
