import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class BracketSequence {
	public static class Stack1 {
		char[] stackarr;
		int top;

		public Stack1(int n) {
			stackarr = new char[n];
			top = -1;
		}

		public boolean isEmpty() {
			return (top == -1);
		}

		public void push(char x) {
			stackarr[++top] = x;
		}

		public char pop() {
			return stackarr[top--];
		}

		public char peak() {
			return stackarr[top];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("brackets.in"));
		PrintWriter out = new PrintWriter(new FileWriter("brackets.out"));
		while (bf.ready()) {
			Stack1 st = new Stack1(10000);
			String s = bf.readLine();
			boolean ok = true;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[')
					st.push(c);
				else {
					if (!st.isEmpty()) {
						char d = st.peak();
						if ((c == ')' && d == '(') || (c == ']' && d == '['))
							st.pop();
						else {
							ok = false;
							break;
						}
					} else {
						ok = false;
						break;
					}
				}
			}
			if (ok && st.isEmpty())
				out.println("YES");
			else
				out.println("NO");
		}
		out.flush();
		out.close();
	}
}
